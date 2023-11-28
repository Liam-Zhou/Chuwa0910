package kechen.hw8springbootredbook.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 它表示在 JSON 序列化和反序列化过程中，该字段将使用指定的名称：name
    // 如果是@jsonProperty("full name"),那么在 JSON 中将其表示为不同的名称： full_name
    @JsonProperty("name")
    private String name;
    private  String email;
    private String body;

    // manyToOne:多个comments对应一个post
    // 指定加载关联实体的方式。
    // 在加载实体时不会立即加载关联的实体数据，而是在访问关联属性时才会触发加载，这种方式也被称为延迟加载。
    @ManyToOne(fetch = FetchType.LAZY)
    // post_id 列被用作连接 Comment 实体和 Post 实体的外键
    // 这个外键列不允许为空。这意味着每个评论（Comment）必须与一个有效的帖子（Post）相关联，否则将会触发数据库的约束违规错误。
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @CreationTimestamp
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    private  LocalDateTime updateDateTime;

    //constructor, getter and setter
    public Comment() {
    }

    public Comment(Long id, String name, String email, String body, Post post, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
        this.post = post;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                ", post=" + post +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }
}
