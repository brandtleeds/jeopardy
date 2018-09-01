package com.brandt13.run.model;

import java.util.Date;

public class Clue {

    int id;
    String answer;
    String question;
    int value;
    Date airdate;
    Date created_at;
    Date updated_at;
    int category_id;
    int game_id;
    int invalid_count;
    Category category;

    public Clue(int id, String answer, String question, int value, Date airdate, Date created_at, Date updated_at, int category_id, int game_id, int invalid_count, Category category) {
        this.id = id;
        this.answer = answer;
        this.question = question;
        this.value = value;
        this.airdate = airdate;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.category_id = category_id;
        this.game_id = game_id;
        this.invalid_count = invalid_count;
        this.category = category;
    }

    public Clue() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Date getAirdate() {
        return airdate;
    }

    public void setAirdate(Date airdate) {
        this.airdate = airdate;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getInvalid_count() {
        return invalid_count;
    }

    public void setInvalid_count(int invalid_count) {
        this.invalid_count = invalid_count;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
