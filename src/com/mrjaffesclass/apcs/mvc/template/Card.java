/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mrjaffesclass.apcs.mvc.template;

/**
 *
 * @author student
 */
public class Card {
    private int rank;
    private String suit;
    private String face;
    private String location;
    
    public Card(int Rank, String Suit, String Face, String Location) {
        this.rank = Rank;
        this.suit = Suit;
        this.face = Face;
        this.location = Location;
    }
    
    /*
    returns the rank
    */
    public int getRank() {
        return rank;
    }
    
    /*
    returns the suit
    */
    public String getSuit() {
        return suit;
    }
    
    /*
    returns the location of the image
    */
    public String getLocation() {
        return location;
    }
}
