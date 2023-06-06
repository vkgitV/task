package com.example.recyclerusingvolley;

public class PostModel {

    int userId;
    String Title, PostDesc;

    public PostModel(int userId, String title, String postDesc) {
        this.userId = userId;
        Title = title;
        PostDesc = postDesc;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPostDesc() {
        return PostDesc;
    }

    public void setPostDesc(String postDesc) {
        PostDesc = postDesc;
    }
}