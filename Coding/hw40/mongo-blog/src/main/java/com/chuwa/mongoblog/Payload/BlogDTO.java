package com.chuwa.mongoblog.Payload;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlogDTO {
    private String id;

    private String title;
    private String discription;
    private String content;

    public BlogDTO() {}

    public BlogDTO(String id, String title, String discription, String content) {
        this.id = id;
        this.title = title;
        this.discription = discription;
        this.content = content;
    }
}
