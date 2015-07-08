package ru.edabudet.model;

import javax.persistence.*;

@Entity(name = "user_table")
@SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
public class User {

    @Id
    @GeneratedValue(generator = "user_seq")
    private Long id;

    @Column(name = "name")
    private String name;

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

}
