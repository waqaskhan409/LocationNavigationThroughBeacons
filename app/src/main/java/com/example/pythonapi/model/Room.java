package com.example.pythonapi.model;

import java.io.Serializable;

public class Room implements Serializable {

    private String room;

    public Room(String room) {
        this.room = room;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
