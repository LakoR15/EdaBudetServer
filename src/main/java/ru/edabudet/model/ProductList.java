package ru.edabudet.model;

import com.google.gson.annotations.SerializedName;

import javax.persistence.*;

@Entity(name = "productList_table")
@SequenceGenerator(name = "productList_seq", sequenceName = "productList_seq")
public class ProductList {

    @Id
    @GeneratedValue(generator = "productList_seq")
    @SerializedName("id")
    private Long id;


    @Column(name = "productName")
    @SerializedName("productName")
    private String productName;

    @Column(name = "room")
    @SerializedName("room")
    private Long room;


    @Column(name = "bought")
    @SerializedName("bought")
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

    public Long getRoom() {
        return room;
    }

    public void setRoom(Long room) {
        this.room = room;
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }
}
