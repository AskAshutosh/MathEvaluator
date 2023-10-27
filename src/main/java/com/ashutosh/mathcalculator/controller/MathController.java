package com.ashutosh.mathcalculator.controller;

import com.ashutosh.mathcalculator.entity.MathEntity;
import com.ashutosh.mathcalculator.service.MathService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  MathController {
    private final MathService mathService;


    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/math/{expression}")
    public ResponseEntity<MathEntity> getRapidApi(@PathVariable("expression") String expression){
        //int ans = mathService.getValue(expression);
        return ResponseEntity.ok(mathService.getValue(expression));
    }
}
