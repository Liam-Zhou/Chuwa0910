package org.example;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
public class BlogPost {

    @Id
    private String id;
    private String title;
    private String content;

    // Getters and setters
}
