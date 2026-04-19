package org.example.wishlist.model;

import java.util.List;

public class Wishlist {

    private int id;
    private String name;
    private int userId;
    private List<Wish> wishes;

    public Wishlist() {
    }

    public Wishlist(int id, String name, int userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

    public Wishlist(int id, String name, int userId, List<Wish> wishes) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.wishes = wishes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Wish> getWishes() {
        return wishes;
    }

    public void setWishes(List<Wish> wishes) {
        this.wishes = wishes;
    }
}
