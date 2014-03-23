package com.profilactory.model.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ValentinBlokhin on 3/23/2014.
 */
@Entity
public class Personal {
    private int personalId;
    private String post;
    private String workTime;
    private Collection<Cabinet> cabinetsByPersonalId;

    @Id
    @Column(name = "PERSONAL_ID", nullable = false, insertable = true, updatable = true, precision = 0)
    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    @Basic
    @Column(name = "POST", nullable = false, insertable = true, updatable = true, length = 30)
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Basic
    @Column(name = "WORK_TIME", nullable = false, insertable = true, updatable = true, length = 50)
    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personal personal = (Personal) o;

        if (personalId != personal.personalId) return false;
        if (post != null ? !post.equals(personal.post) : personal.post != null) return false;
        if (workTime != null ? !workTime.equals(personal.workTime) : personal.workTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personalId;
        result = 31 * result + (post != null ? post.hashCode() : 0);
        result = 31 * result + (workTime != null ? workTime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "personalByPersonalId")
    public Collection<Cabinet> getCabinetsByPersonalId() {
        return cabinetsByPersonalId;
    }

    public void setCabinetsByPersonalId(Collection<Cabinet> cabinetsByPersonalId) {
        this.cabinetsByPersonalId = cabinetsByPersonalId;
    }
}
