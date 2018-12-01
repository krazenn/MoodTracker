package com.example.kraken.moodtracker;

public class TicketComment {

    public TicketComment(){


    }
    private int smileyBackgroundTicket;
    private int idTicket;
    String commentTicket;

    public int getSmileyBackgroundTicket() {
        return smileyBackgroundTicket;
    }

    public void setSmileyBackgroundTicket(int smileyBackgroundTicket) {
        this.smileyBackgroundTicket = smileyBackgroundTicket;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getCommentTicket() {
        return commentTicket;
    }

    public void setCommentTicket(String commentTicket) {
        this.commentTicket = commentTicket;
    }

    public TicketComment(int smileyBackgroundTicket, int idTicket, String commentTicket) {

        this.smileyBackgroundTicket = smileyBackgroundTicket;
        this.idTicket = idTicket;
        this.commentTicket = commentTicket;
    }
}

