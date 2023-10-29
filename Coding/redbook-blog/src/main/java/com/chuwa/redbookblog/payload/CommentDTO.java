package com.chuwa.redbookblog.payload;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentDTO {
    private long id;
    private String name;
    private String body;
    private String email;
}
