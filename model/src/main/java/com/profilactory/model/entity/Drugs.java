package com.profilactory.model.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Валентин
 * Date: 16.03.14
 * Time: 19:25
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "drugs")
public class Drugs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
