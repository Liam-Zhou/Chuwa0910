package com.chuwa.redbookblog.payload;

public class AuthorDTO {

    private Long id;
    private String name;
    private String gender;
    private String birthday;

    public AuthorDTO(){

    }

    public AuthorDTO(String name, String gender, String birthday, long id) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
