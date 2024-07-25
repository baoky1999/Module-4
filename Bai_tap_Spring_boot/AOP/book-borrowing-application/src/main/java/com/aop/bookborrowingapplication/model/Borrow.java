package com.aop.bookborrowingapplication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "borrow")
public class Borrow {

    @Id
    private int id;
    private String code;

    public Borrow() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
