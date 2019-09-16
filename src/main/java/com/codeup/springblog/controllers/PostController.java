package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repos.PostRepository;
import com.codeup.springblog.repos.Users;
import com.codeup.springblog.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
class PostController {

    private final PostRepository postDao;
    private final Users userDao;

    public PostController(PostRepository postRepo, Users userDao) {
        this.userDao = userDao;
        this.postDao = postRepo;
    }

    @Autowired
    private EmailService emailService;

    // SpringBlog Controllers //
    @GetMapping(path = "/posts")
    public String index(Model viewModel) {
        Iterable<Post> posts = postDao.findAll();
        viewModel.addAttribute("posts", posts);
        return "/index";
    }

    @GetMapping(path = "/profile")
    public String userPosts(Model viewModel, User user) {
        Iterable<Post> userPosts = postDao.findAll();
        viewModel.addAttribute("userPosts", userPosts);
        return "/profile";

    }

    @GetMapping("/show/{id}")
    public String show(@PathVariable long id, Model viewModel) {
        Post post = postDao.findOne(id);
        viewModel.addAttribute("post", post);
        return "/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @ModelAttribute Post post
    ) {
        User userDB = userDao.findOne(((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        post.setUser(userDB);
        postDao.save(post);
        emailService.prepareAndSend(
                post,
                "Ad Created!",
                String.format("Ad with the id of %d has been created", post.getId())
        );
        return "redirect:/show/" + post.getId();
    }

    @GetMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, Model vModel){
        Post post = postDao.findOne(id);
        vModel.addAttribute("post", post);
        return "/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id,
                           @RequestParam(name = "title") String title,
                           @RequestParam(name = "content") String content,
                           @RequestParam(name = "authorFirstName") String authorFirstName,
                           @RequestParam(name = "authorLastName") String authorLastName,
                           Model vmodel) {
        Post postToBeUpdated = postDao.findOne(id);
        if (postToBeUpdated.getUser().getId() == ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()) {
            postToBeUpdated.setTitle(title);
            postToBeUpdated.setContent(content);
            postToBeUpdated.setAuthorFirstName(authorFirstName);
            postToBeUpdated.setAuthorLastName(authorLastName);
            postDao.save(postToBeUpdated);
            return "redirect:/show/" + postToBeUpdated.getId();
        } else {
            return "redirect:/posts";
        }
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id, Model vModel) {
        Post post = postDao.findOne(id);
        if (post.getUser().getId() == ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()) {
            postDao.delete(post);
            return "redirect:/posts";
        } else {
            return "redirect:/posts";
        }
    }
}
