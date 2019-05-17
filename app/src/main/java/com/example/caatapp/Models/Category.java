package com.example.caatapp.Models;

public class Category {
    int catId;
    String name;
    String icon;
    String peopleAmount;

    public Category(int catId, String name, String icon, String peopleAmount) {
        this.catId = catId;
        this.name = name;
        this.icon = icon;
        this.peopleAmount = peopleAmount;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPeopleAmount() {
        return peopleAmount;
    }

    public void setPeopleAmount(String peopleAmount) {
        this.peopleAmount = peopleAmount;
    }
}
