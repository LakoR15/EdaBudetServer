package ru.edabudet.model;

import javax.persistence.*;

@Entity(name = "room_table")
@SequenceGenerator(name = "room_seq", sequenceName = "room_seq")
public class Room {

    @Id
    @GeneratedValue(generator = "room_seq")
    private Long id;

    @Column (name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
