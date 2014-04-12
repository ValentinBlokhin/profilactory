package com.profilactory.model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ValentinBlokhin on 4/16/2014.
 */
@Entity
public class Post {
    private int postId;
    private String name;
    private Collection<Personal> personalsByPostId;

    @Id
    @Column(name = "POST_ID")
    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (postId != post.postId) return false;
        if (name != null ? !name.equals(post.name) : post.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "postByPostId")
    public Collection<Personal> getPersonalsByPostId() {
        return personalsByPostId;
    }

    public void setPersonalsByPostId(Collection<Personal> personalsByPostId) {
        this.personalsByPostId = personalsByPostId;
    }
}
