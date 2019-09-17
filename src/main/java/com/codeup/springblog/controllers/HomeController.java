//package com.codeup.springblog.controllers;
//
//import com.codeup.springblog.repos.PostRepository;
//import com.codeup.springblog.repos.Users;
//import com.codeup.springblog.services.EmailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//class HomeController {
//
//    private final PostRepository postDao;
//    private final Users userDao;
//
//    @Autowired
//    private EmailService emailService;
//
//    HomeController(PostRepository postDao, Users userDao) {
//        this.postDao = postDao;
//        this.userDao = userDao;
//    }
//
//    @GetMapping("/")
//    public String home() {
//        return "tachyon/home";
//    }
//}