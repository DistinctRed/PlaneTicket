package com.example.planeticket.model;

public class contact {
    private String usercontact;
    private String message;

    public contact(String usercontact, String message) {
        this.usercontact = usercontact;
        this.message = message;
    }

    public String getUsercontact() {
        return usercontact;
    }

    public void setUsercontact(String usercontact) {
        this.usercontact = usercontact;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
