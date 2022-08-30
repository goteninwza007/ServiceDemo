package com.example.demo;
import java.lang.Math;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
@RestController
public class GeneratePasswordService {
    @RequestMapping(value = "/generate/{name}.generate", method = RequestMethod.GET)
    public String generate(@PathVariable("name") String name) {
        double rand = Math.random();
        return "Hi," + name + "\nYour new password is " + ((int)(rand * 1000000000)) + '.';
    }
}
