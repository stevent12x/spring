package com.codeup.springblog.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public String hello() {
        return "<h2>This is the landing page!</h2>";
    }

//    Dice Roll   //
    @GetMapping("/roll-dice")
    public String dice() {
        return "/roll-dice";
    }
}