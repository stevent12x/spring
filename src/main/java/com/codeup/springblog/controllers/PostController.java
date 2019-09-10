package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repos.PostRepository;
import com.codeup.springblog.repos.UserRepository;
import javafx.geometry.Pos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postRepo, UserRepository userRepo) {
        this.userDao = userRepo;
        this.postDao = postRepo;
    }
//
//    // Roll-Dice Controller //
//    @GetMapping(path="/dice")
//    public String dice() {
//        return "/roll-dice";
//    }

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
    public String showCreateForm() {
        return "/create";
    }

    @PostMapping("/posts/create")
    public String createPost(
            @RequestParam(name = "title") String titleParam,
            @RequestParam(name = "content") String contentParam,
            @RequestParam(name = "authorFirstName") String authorFirstNameParam,
            @RequestParam(name = "authorLastName") String authorLastNameParam
    ) {
        User userDB = userDao.findOne(1L);
        Post postToBeCreated = new Post();

        postToBeCreated.setTitle(titleParam);
        postToBeCreated.setContent(contentParam);
        postToBeCreated.setAuthorFirstName(authorFirstNameParam);
        postToBeCreated.setAuthorLastName(authorLastNameParam);
        postToBeCreated.setUser(userDB);

        Post newPost = postDao.save(postToBeCreated);
        return "redirect:/show/" + newPost.getId();
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
