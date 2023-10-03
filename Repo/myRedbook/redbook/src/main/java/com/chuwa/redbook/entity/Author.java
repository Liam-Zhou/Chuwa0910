package com.chuwa.redbook.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(
        name="authors"
)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="firstName", nullable = false)
    private String firstName;

    @Column(name="lastName", nullable = false)
    private String lastName;

    @Column(name="sex")
    private String sex;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    public Author() {
    }

    public Author(String firstName, String lastName, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
    }

    public Author(Long id, String firstName, String lastName, String sex, LocalDateTime createDateTime) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.createDateTime = createDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }
}
