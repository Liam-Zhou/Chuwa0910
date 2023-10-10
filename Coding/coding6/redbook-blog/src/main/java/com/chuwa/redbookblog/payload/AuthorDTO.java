package com.chuwa.redbookblog.payload;

public class AuthorDTO {

    private String name;

    private String sex;

    public AuthorDTO() {

    }

    public AuthorDTO(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
