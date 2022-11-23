package com.example.planeticket.model;

public class users {
private String firstname;
private String lastname;
private String username;
private String password;

    public users(String firstname, String lastname, String username, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public users() { //need this empty user constructor so that we can use this for logging in with only the user.getUsername and user.getPassword needed. We cannot use the other user constructor above, because it also requires the first name and last name.

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
