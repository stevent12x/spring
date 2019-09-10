package com.codeup.springblog.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "posts")
public class Post {

    @Id @GeneratedValue
    public long id;
    @Column (nullable = false)
    public String title;
    @Column (nullable = false)
    public String content;
    @Column (name = "last_name", nullable = false, length = 50)
    private String authorLastName;
    @Column (name = "first_name", nullable = false, length = 50)
    private String authorFirstName;

//    Create a connection to Users table
    @OneToOne
    private User user;

//    This will not create a new column
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> images;


//    Empty Constructor - required by JPA
    public Post() {}

//    Recommended Contructor with Everything - gives ability to read everything from the database
    public Post(long id, String title, String content, String authorLastName, String authorFirstName, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorLastName = authorLastName;
        this.authorFirstName = authorFirstName;
        this.user = user;
    }


    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthorLastName() { return authorLastName; }

    public void setAuthorLastName(String authorLastName) { this.authorLastName = authorLastName; }

    public String getAuthorFirstName() { return authorFirstName; }

    public void setAuthorFirstName(String authorFirstName) { this.authorFirstName = authorFirstName; }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public List<PostImage> getImages() { return images; }

    public void setImages(List<PostImage> images) { this.images = images; }
}


