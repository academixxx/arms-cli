package com.academixxx.models;

public record Animal(int id, String type, String condition, String status) {

    @Override
    public String toString() {
        return "Animal #" + id + " (" + type + ") - " + condition + " [" + status + "]";
    }
}
