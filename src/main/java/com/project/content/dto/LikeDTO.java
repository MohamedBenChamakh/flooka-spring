package com.project.content.dto;

public class LikeDTO {

    private String id;

    private UserShortDTO user;

    public LikeDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserShortDTO getUser() {
        return user;
    }

    public void setUser(UserShortDTO user) {
        this.user = user;
    }
}
