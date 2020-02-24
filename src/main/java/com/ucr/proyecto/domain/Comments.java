package com.ucr.proyecto.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Comments")
public class Comments {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Description")
    @NotNull
    private String description;
    @Column(name = "CommentTimestamp")
    @NotNull
    private String commentTimestamp;

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", commentTimestamp=" + commentTimestamp +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCommentTimestamp() {
        return commentTimestamp;
    }

    public void setCommentTimestamp(String commentTimestamp) {
        this.commentTimestamp = commentTimestamp;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return Objects.equals(id, comments.id) &&
                Objects.equals(description, comments.description) &&
                Objects.equals(commentTimestamp, comments.commentTimestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, commentTimestamp);
    }
}
