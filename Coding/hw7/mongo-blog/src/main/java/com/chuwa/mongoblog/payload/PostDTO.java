package com.chuwa.mongoblog.payload;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PostDTO {
    private String title;
    private String description;
    private String content;

    private LocalDateTime createDateTime;
    //private LocalDateTime updateDateTime;
    public PostDTO(String title, String description, String content) {
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public PostDTO(){

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

    public void setCreateDateTime(LocalDateTime createDateTime){
        this.createDateTime = createDateTime;
    }

    //public void setUpdateDateTime(LocalDateTime updateDateTime){
    //    this.updateDateTime = updateDateTime;
    //}

    public LocalDateTime getCreateDateTime(){
        return createDateTime;
    }

    //public LocalDateTime getUpdateDateTime(){
    //    return updateDateTime;
    //}
}
