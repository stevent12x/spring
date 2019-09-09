package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.repos.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class PostController {

    private final PostRepository postDao;

    PostController(PostRepository postRepository) {
        postDao = postRepository;
    }

    // Roll-Dice Controller //
    @GetMapping(path="/dice")
    public String dice() {
        return "/roll-dice";
    }

    // SpringBlog Controllers //
    @GetMapping(path = "/posts")
    public String index(Model viewModel) {
        Iterable<Post> posts = postDao.findAll();
        viewModel.addAttribute("posts", posts);
        return "/index";
    }

    @GetMapping("/posts/show")
    public String show(Post post) {
        postDao.deletePostBy(post.getId());
        return "/show";
    }








//    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public String individualPost(@PathVariable long id){
//        return "<h2>Here is Post #"+id+".</h2>";
//    }
//
//    @GetMapping(path = "/posts/create")
//    @ResponseBody
//    public String create(){
//        return "<h2>Write a new post here!</h2>";
//    }
//
//    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
//    @ResponseBody
//    public String post(){
//        return "<h2>Your post has been posted!</h2>";
//    }
}
