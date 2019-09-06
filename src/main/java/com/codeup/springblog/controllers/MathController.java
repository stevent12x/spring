package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class MathController {
    @RequestMapping(value = "/add/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String addition(@PathVariable int number1, @PathVariable int number2) {
        return number1 + " plus " + number2 + " equals " + (number1 + number2) + "!";
    }

    @RequestMapping(value = "/subtract/{number1}/from/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public String subtraction(@PathVariable int number1, @PathVariable int number2) {
        return number2 + " minus " +number1+ " equals " + (number2 - number1) + "!";
    }

    @GetMapping(value = "multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiplication(@PathVariable int num1, @PathVariable int num2){
        return num1 +" times "+num2+ " is " +(num1*num2)+"!";
    }

    @RequestMapping( value = "/divide/{num1}/by/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String division(@PathVariable double num1, @PathVariable double num2){
        return num1+" divided by "+num2+" equals "+(num1/num2)+"!";
    }
}


