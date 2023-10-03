package com.chuwa.redbookblog.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDTO {
    private Long id;
    private String name;
    private String password;
}
