package ru.edabudet.model;

import javax.persistence.*;

@Entity(name = "productList_table")
@SequenceGenerator(name = "productList_seq", sequenceName = "productList_seq")
public class ProductList {

    @Id
    @GeneratedValue(generator = "productList_seq")
    private Long id;

    @Column(name = "productName")
    private String productName;

    @Column(name = "room")
    private Room room;

    @Column(name = "bought")
    private boolean bought;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }
}
