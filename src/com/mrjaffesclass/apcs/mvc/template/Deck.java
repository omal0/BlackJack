/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mrjaffesclass.apcs.mvc.template;

import java.util.ArrayList;

/**
 *
 * @author student
 */
public class Deck {
    private ArrayList<Card> deck;
    
    public Deck() {
        deck = new ArrayList<Card>();
    }
    
    public void InitNewDeck() {
        String[] suits = {"Hearts","Clubs","Spades","Diamonds"};
        int[] ranks = {2,3,4,5,6,7,8,9,10,11,12,13,14};
        String[] faces = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        for (String suit : suits) {
            for (int i=0; i<ranks.length; i++) {
                Card c = new Card(ranks[i], suit, faces[i]);
                this.deck.add(c);
            }
        }
    }
    
    public void shuffle() {
        ArrayList secondDeck = (ArrayList)deck.clone();
        
        for(int i = 0; i < this.deck.size(); i++) {
            deck.remove(0);
        }
        
        for(int i = 0; i < secondDeck.size(); i++) {
            int random = (int) (Math.random() * secondDeck.size());
            
        }
    }
    
    public int getDeckSize() {
        return this.deck.size();
    }
    
    public void dealCard(ArrayList<Card> player) {
        player.add(this.deck.get(0));
        this.deck.remove(0);
    }
}
