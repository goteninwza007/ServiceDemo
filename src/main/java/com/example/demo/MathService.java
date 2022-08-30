package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class MathService {
    @RequestMapping(value = "/add/{num1}/{num2}", method = RequestMethod.GET)
    public Double add(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
        return num1 + num2;
    }
    @RequestMapping(value = "/minus/{num1}/{num2}", method = RequestMethod.GET)
    public String minus(@PathVariable("num1") Double num1, @PathVariable("num2") Double num2) {
        return (num1 - num2) + "";
    }
    @RequestMapping(value = "/multiply", method = RequestMethod.GET)
    public String multiply(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
        return (num1 * num2) + "";
    }
    @RequestMapping(value = "/divide", method = RequestMethod.GET)
    public String divide(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
        return (num1 / num2) + "";
    }
}
