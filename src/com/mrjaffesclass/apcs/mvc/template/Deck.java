/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mrjaffesclass.apcs.mvc.template;

import java.util.ArrayList;
import java.util.Collections;

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
                if (faces[i] == "Jack" || faces[i] == "Queen" || faces[i] == "King") {
                    Card c = new Card(10, suit, faces[i]);
                    this.deck.add(c);
                } else if (faces[i] == "Ace") {
                    Card c = new Card(11, suit, faces[i]);
                    this.deck.add(c);
                } else {
                    Card c = new Card(ranks[i], suit, faces[i]);
                    this.deck.add(c);
                }
            }
        }
    }
    
    public void shuffle() {
        Collections.shuffle(this.deck);
    }
    
    public int getDeckSize() {
        return this.deck.size();
    }

    public void dealCard(ArrayList<Card> player) {
        player.add(this.deck.get(0));
        this.deck.remove(0);
    }
    
    public void clearDeck() {
        for (int i = 0; i < this.deck.size(); i++) {
            this.deck.remove(0);
        }
    }
}
