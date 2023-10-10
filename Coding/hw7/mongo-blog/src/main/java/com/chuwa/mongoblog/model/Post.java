package com.chuwa.mongoblog.model;

import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "posts")
public class Post {
    private String title;
    private String description;
    private String content;
    private LocalDateTime createDateTime;
    //private LocalDateTime updateDateTime;
    public Post() {
    }
    public Post(String title, String description, String content, LocalDateTime createDateTime) {
        this.title = title;
        this.description = description;
        this.content = content;
        this.createDateTime = createDateTime;
        //this.updateDateTime = updateDateTime;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    //public LocalDateTime getUpdateDateTime() {
    //    return updateDateTime;
    //}

    //public void setUpdateDateTime(LocalDateTime updateDateTime) {
    //    this.updateDateTime = updateDateTime;
    //}
}
