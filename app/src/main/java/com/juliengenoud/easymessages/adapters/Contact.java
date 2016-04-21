package com.juliengenoud.easymessages.adapters;

/**
 * Author : juliengenoud
 * 21/04/16
 **/
public class Contact {
    private String mName;
    private String mDescription;

    public Contact(String name, String description) {
        mName = name;
        mDescription = description;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }
}
