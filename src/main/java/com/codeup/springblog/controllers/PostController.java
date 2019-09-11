package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repos.PostRepository;
import com.codeup.springblog.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postRepo, UserRepository userRepo) {
        this.userDao = userRepo;
        this.postDao = postRepo;
    }

    // SpringBlog Controllers //
    @GetMapping(path = "/posts")
    public String index(Model viewModel) {
        Iterable<Post> posts = postDao.findAll();
        viewModel.addAttribute("posts", posts);
        return "/index";
    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable long id, Model viewModel) {
        Post post = postDao.findOne(id);
        viewModel.addAttribute("post", post);
        return "/show";
    }

    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id) {
        postDao.delete(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
//            @RequestParam(name = "title") String titleParam,
//            @RequestParam(name = "content") String contentParam,
//            @RequestParam(name = "authorFirstName") String authorFirstNameParam,
//            @RequestParam(name = "authorLastName") String authorLastNameParam
            @ModelAttribute Post post
    ) {
        User userDB = userDao.findOne(1L);
//        Post postToBeCreated = new Post();
//
//        postToBeCreated.setTitle(titleParam);
//        postToBeCreated.setContent(contentParam);
//        postToBeCreated.setAuthorFirstName(authorFirstNameParam);
//        postToBeCreated.setAuthorLastName(authorLastNameParam);
        post.setUser(userDB);
        postDao.save(post);
//        Post newPost = postDao.save(postToBeCreated);
        return "redirect:/show/" + post.getId();
    }
}
