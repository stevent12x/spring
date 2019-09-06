package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class PostController {
    @GetMapping(path = "/posts")
    public String index(@PathVariable String index, Model model) {
        model.addAttribute("index", index);
        return "/posts/index";
    }

    @GetMapping("/posts/show")
    public String show(@PathVariable String post, Model model) {
        model.addAttribute("post", post);
        return "/posts/show";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String individualPost(@PathVariable long id){
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
