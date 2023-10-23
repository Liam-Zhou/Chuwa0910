package com.hyc.redbookblog.payload;

/**
 * @Description:
 * @Author: hyc
 */
public class AuthorDTO {
    private String name;
    private boolean gender; // true: male, false female

    private String description;

    public AuthorDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AuthorDTO(String name, boolean gender, String description) {
        this.name = name;
        this.gender = gender;
        this.description = description;
    }
}
