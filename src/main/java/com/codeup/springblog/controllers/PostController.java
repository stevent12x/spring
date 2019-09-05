package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class PostController {
    @GetMapping(path = "/posts")
    @ResponseBody
    public String welcome(){
        return "<h3>Here are all the posts!</h3>";
    }
    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String individualPost(@PathVariable int id){
        return "<h2>Here is Post #"+id+".</h2>";
    }
    @GetMapping(path = "/posts/create")
    @ResponseBody
    public String create(){
        return "<h2>Write a new post here!</h2>";
    }
    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String post(){
        return "<h2>Your post has been posted!</h2>";
    }
}
