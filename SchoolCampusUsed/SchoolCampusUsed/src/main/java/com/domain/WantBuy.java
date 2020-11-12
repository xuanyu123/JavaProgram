package com.domain;

import java.io.Serializable;

public class WantBuy implements Serializable {
    private Integer id;
    private String username;
    private String message;

    public WantBuy() {
    }

    public WantBuy(Integer id, String username, String message) {
        this.id = id;
        this.username = username;
        this.message = message;
    }

    @Override
    public String toString() {
        return "WantBuy{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
