package com.ashutosh.mathcalculator;

import com.ashutosh.mathcalculator.controller.MathController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class MathCalculatorApplicationTests {

    @Autowired
    MathController mathController;

    @Test
    void contextLoads() {
        ResponseEntity<String> test1 = mathController.getRapidApi("2 * 4 * 4");
        ResponseEntity<String> test2 = mathController.getRapidApi("5+2");

    }

}
