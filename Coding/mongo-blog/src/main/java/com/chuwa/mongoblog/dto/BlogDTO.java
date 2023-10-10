package com.chuwa.mongoblog.dto;

public class BlogDTO {

    private String id;
    private String title;
    private String content;

    public BlogDTO() {

    }
    public BlogDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public BlogDTO(String id, BlogDTO blogDTO) {
        this.id = id;
        this.content = blogDTO.getContent();
        this.title = blogDTO.getTitle();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
