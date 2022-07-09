package com.example.workproject2;

public class Post {
    private Integer status;
    private String email;
    private String password;
    private String user_api_hash;


    public Post(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public String getUser_api_hash() {
        return user_api_hash;
    }

}
