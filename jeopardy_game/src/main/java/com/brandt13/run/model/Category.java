package com.brandt13.run.model;

public class Category {

    int id;
    String title;
    String created_at;
    String updated_at;
    int clues_count;

    public Category(int id, String title, String created_at, String updated_at, int clues_count) {
        this.id = id;
        this.title = title;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.clues_count = clues_count;
    }

    public Category() {
    }

    public int getId() { return id; } 

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getClues_count() {
        return clues_count;
    }

    public void setClues_count(int clues_count) {
        this.clues_count = clues_count;
    }
}
