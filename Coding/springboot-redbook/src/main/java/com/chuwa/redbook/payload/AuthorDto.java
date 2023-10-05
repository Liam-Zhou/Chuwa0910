package com.chuwa.redbook.payload;

public class AuthorDto {
    private Long id;

    private String email;

    public AuthorDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public AuthorDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
