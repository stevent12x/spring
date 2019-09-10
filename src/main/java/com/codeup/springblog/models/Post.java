package com.codeup.springblog.models;
import javax.persistence.*;

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




//    Empty Constructor - required by JPA
    public Post() {}

//    Recommended Contructor with Everything - gives ability to read everything from the database
    public Post(long id, String title, String content, String authorLastName, String authorFirstName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.authorLastName = authorLastName;
        this.authorFirstName = authorFirstName;
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
}


