package com.example.caatapp.Models;

public class User {
    String id;
    String username;
    int loginStatus;
    boolean isVip;
    String photo;
    int chatAmount;
    int gender;
    int greatFeedback;
    int badFeedback;
    int selectedCategory;

    public User(){

    }

    public User(String id, String username, int loginStatus, boolean isVip, String photo, int chatAmount, int gender, int greatFeedback, int badFeedback, int selectedCategory) {
        this.id = id;
        this.username = username;
        this.loginStatus = loginStatus;
        this.isVip = isVip;
        this.photo = photo;
        this.chatAmount = chatAmount;
        this.gender = gender;
        this.greatFeedback = greatFeedback;
        this.badFeedback = badFeedback;
        this.selectedCategory = selectedCategory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getChatAmount() {
        return chatAmount;
    }

    public void setChatAmount(int chatAmount) {
        this.chatAmount = chatAmount;
    }

    public int getGreatFeedback() {
        return greatFeedback;
    }

    public void setGreatFeedback(int greatFeedback) {
        this.greatFeedback = greatFeedback;
    }

    public int getBadFeedback() {
        return badFeedback;
    }

    public void setBadFeedback(int badFeedback) {
        this.badFeedback = badFeedback;
    }

    public int getSelectedCategory() {
        return selectedCategory;
    }

    public void setSelectedCategory(int selectedCategory) {
        this.selectedCategory = selectedCategory;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}
