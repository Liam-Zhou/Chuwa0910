package com.hyc.mongoblog.payload;

/**
 * @Description:
 * @Author: hyc
 */
public class PostDTO {
    private String id;
    private String title;
    private String description;
    private String content;

    // DateTime don't needed

    public PostDTO() {}

    public PostDTO(String id, String title, String description, String content) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
