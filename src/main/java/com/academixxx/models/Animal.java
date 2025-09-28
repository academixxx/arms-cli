package com.academixxx.models;

public class Animal {
    private int id;
    private String type;
    private String condition;
    private String status;

    public Animal(int id, String type, String condition, String status) {
        this.id = id;
        this.type = type;
        this.condition = condition;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getCondition() {
        return condition;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Animal #" + id + " (" + type + ") - " + condition + " [" + status + "]";
    }
}
