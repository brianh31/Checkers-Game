package com.minicheckers;

public class Piece {
    private final String owner;

    public Piece(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public char getSymbol() {
        return owner.equals("Player") ? 'P' : 'A';
    }
}
