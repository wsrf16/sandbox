package com.sandbox.springboot.db.Entity;

import javax.persistence.*;

@Entity
@Table
public class BookStore {
    public BookStore(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public BookStore() {
    }

    @Id
    //@Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private int id;
    private String name;
    private String author;
}
