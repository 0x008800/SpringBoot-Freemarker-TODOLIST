package com.oxoo88oo.todolist.entities;

public class Task {
    private static int count = 0;
    private int id;
    private String text;

    public Task(){}

    public Task(String text){
        this.id = ++count;
        this.text = text;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
