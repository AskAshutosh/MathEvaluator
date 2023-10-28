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
        try {
            String encodedExpression = URLEncoder.encode(s, StandardCharsets.UTF_8.toString());
            return encodedExpression;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
