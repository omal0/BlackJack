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
    
    public Card(int Rank, String Suit, String Face) {
        this.rank = Rank;
        this.suit = Suit;
        this.face = Face;
    }
    
    /*
    returns the rank
    */
    public int getRank() {
        return this.rank;
    }
    
    /*
    returns the suit
    */
    public String getSuit() {
        return this.suit;
    }
    
    public String getFace() {
        return this.face;
    }
}
