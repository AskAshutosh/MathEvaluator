package com.ashutosh.mathcalculator.service;


import com.ashutosh.mathcalculator.ExpressionMapper;
import com.ashutosh.mathcalculator.entity.MathEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

/*
OkHttpClient client = new OkHttpClient();

Request request = new Request.Builder()
	.url("https://evaluate-expression.p.rapidapi.com/?expression=5%5E2")
	.get()
	.addHeader("X-RapidAPI-Key", "687d31a71cmshacc0bf27e33512cp1801eajsn3e67bc0bb780")
	.addHeader("X-RapidAPI-Host", "evaluate-expression.p.rapidapi.com")
	.build();

Response response = client.newCall(request).execute();
 */
@Service
public class MathService {
    @Value("${rapidapi.math.url}")
    String mathUrl;
    @Value("${rapidapi.key.name}")
    String apiKeyName;
    @Value("${rapidapi.key.value}")
    String apiKeyValue;
    @Value("${rapidapi.host.name}")
    String hostName;
    @Value("${rapidapi.host.math.value}")
    String hostValue;

    RestTemplate restTemplate;

    public MathService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public String getValue(String expression){
        String s  = ExpressionMapper.convertToURLEncoder(expression);
        System.out.println("Encoded string : "+s);
        String expressionUrl = mathUrl+s;
        try {
            URI uri;
            uri = new URI(expressionUrl);
            HttpHeaders headers = new HttpHeaders();
            headers.set(apiKeyName, apiKeyValue);
            headers.set(hostName, hostValue);
            //headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            HttpEntity<String> request = new HttpEntity<String>(headers);
            ResponseEntity<String> response =
                    restTemplate.exchange(uri, HttpMethod.GET, request, String.class);
//            ResponseEntity<MathEntity> response1 =
//                    restTemplate.getForEntity(uri, MathEntity.class);
            return response.getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
