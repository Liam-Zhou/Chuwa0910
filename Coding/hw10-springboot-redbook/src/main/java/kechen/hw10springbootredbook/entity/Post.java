package kechen.hw10springbootredbook.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

// 是一个 JPA 实体类， 用于映射到数据库中的表
@Entity
// 指定了与该实体类相关联的数据库表的名称以及表级别的约束。在这里，表的名称为 "posts"。
@Table(
        name = "posts",
        uniqueConstraints = {
                // title 字段被设置为表级别的唯一约束，确保其中的值是唯一的。
                @UniqueConstraint(columnNames = {"title"})
        }
)

// 在实体类 Post 上定义一个名为 "Post.getAll" 的查询。
// 从数据库中选择所有的 Post 对象并返回。在这个查询中，p 是 Post 类的别名，
@NamedQuery(name="Post.getAll", query="select p from Post p")
public class Post {

        @Id
        // 该字段的值是自动生成的，并且使用数据库的自增策略来生成唯一标识符。
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "title", nullable = false)
        private String title;

        @Column(name = "description", nullable = false)
        private String description;

        @Column(name = "content", nullable = false)
        private String content;

        @CreationTimestamp
        private LocalDateTime createDateTime;
        
        @UpdateTimestamp
        private LocalDateTime updateDateTime;

        public Post() {
        }

        public Post(Long id, String title, String description, String content, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
                this.id = id;
                this.title = title;
                this.description = description;
                this.content = content;
                this.createDateTime = createDateTime;
                this.updateDateTime = updateDateTime;
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
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
                return "Post{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", description='" + description + '\'' +
                        ", content='" + content + '\'' +
                        ", createDateTime=" + createDateTime +
                        ", updateDateTime=" + updateDateTime +
                        '}';
        }
}
