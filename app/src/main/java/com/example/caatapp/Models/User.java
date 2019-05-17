package com.example.caatapp.Models;

public class User {
    String id;
    String username;
    int age;
    String loginStatus;
    String isVip;
    String profileDescription;
    String photo;
    int chatAmount;
    int greatFeedback;
    int badFeedback;
    int selectedCategory;


    public User(String id, String username, int age, String loginStatus, String isVip, String profileDescription, String photo, int chatAmount, int greatFeedback, int badFeedback, int selectedCategory) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.loginStatus = loginStatus;
        this.isVip = isVip;
        this.profileDescription = profileDescription;
        this.photo = photo;
        this.chatAmount = chatAmount;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public String getIsVip() {
        return isVip;
    }

    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
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
}
