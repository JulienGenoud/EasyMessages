package com.juliengenoud.easymessages.db;

/**
 * Author : juliengenoud
 * 24/04/16
 **/
public class Message {
    private long id;
    private String message;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String comment) {
        this.message = comment;
    }

    // Will be used by the ArrayAdapter in the ListView
    @Override
    public String toString() {
        return message;
    }
}