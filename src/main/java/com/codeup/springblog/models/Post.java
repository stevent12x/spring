package com.codeup.springblog.models;
import javax.persistence.*;

@Entity
@Table( name = "posts")
public class Post {
    @Id @GeneratedValue
    private Long id;

    @Column (nullable = false)
    private String title;

    @Column (name = "last_name", nullable = false, length = 50)
    private String authorLastName;

    @Column (name = "first_name", nullable = false, length = 50)
    private String authorFirstName;

    public Post() {}

    public Post(Long id) {
        this.id = id;
    }

    public Post(String title, String authorLastName, String authorFirstName) {
        this.title = title;
        this.authorLastName = authorLastName;
        this.authorFirstName = authorFirstName;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthorLastName() { return authorLastName; }

    public void setAuthorLastName(String authorLastName) { this.authorLastName = authorLastName; }

    public String getAuthorFirstName() { return authorFirstName; }

    public void setAuthorFirstName(String authorFirstName) { this.authorFirstName = authorFirstName; }
}


