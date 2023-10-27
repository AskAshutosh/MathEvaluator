package com.ashutosh.mathcalculator;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ExpressionMapper {
    public String expression;

    public ExpressionMapper(String expression) {
        this.expression = expression;
    }
    public static String convertToURLEncoder(String s){
        String ans="";
        try {
            String encodedExpression = URLEncoder.encode(s, StandardCharsets.UTF_8.toString());
            ans = encodedExpression;
//            String htmlURL = "<a href='https://example.com?expression=" + encodedExpression + "'>Evaluate Expression</a>";
            /*
            System.out.println("Original Expression: " + s);
            System.out.println("URL-Encoded Expression: " + encodedExpression);
            System.out.println("HTML URL: " + htmlURL);
             */
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return ans;
    }
}
