package com.codeup.springblog.repos;

import com.codeup.springblog.models.Post;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

public interface PostRepository extends CrudRepository <Post, Long> {

    Post findPostsByAuthorFirstName(String authorFirstName);
    Post findPostsByAuthorLastName(String authorLastName);
    Post findPostByTitle(String title);
    Post deletePostBy(Long id);
    Post deletePostByTitle(String title);
}
