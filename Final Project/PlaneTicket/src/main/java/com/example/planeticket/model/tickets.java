package com.example.planeticket.model;

public class tickets {

//    private int id;
    private int iduser;
    private String ticketname;

    public tickets( int iduser, String ticketname) {
//        this.id = id;
        this.iduser = iduser;
        this.ticketname = ticketname;
    }

    public tickets() {

    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getTicketname() {
        return ticketname;
    }

    public void setTicketname(String ticketname) {
        this.ticketname = ticketname;
    }
}
