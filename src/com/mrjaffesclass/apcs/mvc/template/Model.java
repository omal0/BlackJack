package com.mrjaffesclass.apcs.mvc.template;

import com.mrjaffesclass.apcs.messenger.*;
import java.util.ArrayList;

/**
 * The model represents the data that the app uses.
 * @author Roger Jaffe
 * @version 1.0
 */
public class Model implements MessageHandler {

  // Messaging system for the MVC
  private final Messenger mvcMessaging;

  // Model's data variables
  ArrayList<Card> player;
  ArrayList<Card> dealer;
  boolean gameOver;
  Deck deck;
  /**
   * Model constructor: Create the data representation of the program
   * @param messages Messaging class instantiated by the Controller for 
   *   local messages between Model, View, and controller
   */
  public Model(Messenger messages) {
    mvcMessaging = messages;
  }
  
  /**
   * Initialize the model here and subscribe to any required messages
   */
  public void init() {
      player = new ArrayList<Card>();
      dealer = new ArrayList<Card>();
      gameOver = false;
      
      this.newGame();
      
      this.mvcMessaging.subscribe("quit", this);
      this.mvcMessaging.subscribe("stay", this);
      this.mvcMessaging.subscribe("hit", this);
  }
  
  private void newGame() {
      player.clear();
      dealer.clear();
      
      deck = new Deck();
      deck.shuffle();
      
      deck.dealCard(player);
      deck.dealCard(dealer);
      deck.dealCard(player);
      deck.dealCard(dealer);
      
      mvcMessaging.notify("boardChangePlayer", this.player);
      mvcMessaging.notify("boardChangeDealer", this.dealer);
  }
  
  public int playerValue(ArrayList<Card> player) {
      for (int i = 0; i < player.length(); i++) {
          
      }
  }
  
  public void dealerAI() {
      
  }
  
  @Override
  public void messageHandler(String messageName, Object messagePayload) {
    if (messagePayload != null) {
      System.out.println("MSG: received by model: "+messageName+" | "+messagePayload.toString());
    } else {
      System.out.println("MSG: received by model: "+messageName+" | No data sent");
    }
    
    if (messageName.equals("hit")) {
        deck.dealCard(player);
        mvcMessaging.notify("boardChangePlayer", this.player);
    }
    
    if (messageName.equals("stay")) {
        
    }
    
    if (messageName.equals("quit")) {
        
    }
  }
}
