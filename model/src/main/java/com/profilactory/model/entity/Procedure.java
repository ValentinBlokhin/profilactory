package com.profilactory.model.entity;

import org.hibernate.annotations.Tables;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Валентин
 * Date: 17.03.14
 * Time: 21:13
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "procedure")
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "destination")
    private String destination;

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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
