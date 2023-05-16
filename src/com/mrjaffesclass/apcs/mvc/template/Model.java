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
      deck = new Deck();
      
      this.newGame();
      
      this.mvcMessaging.subscribe("quit", this);
      this.mvcMessaging.subscribe("stay", this);
      this.mvcMessaging.subscribe("hit", this);
  }
  
  private void newGame() {
      this.player.clear();
      this.dealer.clear();
      this.deck.clearDeck();
      
      this.deck.InitNewDeck();
      this.deck.shuffle();

      for(int i = 0; i < 2; i++) {
        this.deck.dealCard(player);
        this.deck.dealCard(dealer);
      }
  }

  public void DealerAI() {
    while (countCards(dealer) < 17) {
      this.deck.dealCard(dealer);
    }
  }

  public int countCards(ArrayList<Card> player) {
    int count = 0;

    for (int i = 0; i < player.size(); i++) {
      if (player.get(i).getFace().equals("Ace") && count + player.get(i).getRank() > 21) {
        count += 1;
      } else if (player.get(i).getFace().equals("Ace") && count < 10) {
        count += 11;
      } else {
        count += player.get(i).getRank();
      }
    }

    return count;
  }
  
  @Override
  public void messageHandler(String messageName, Object messagePayload) {
    if (messagePayload != null) {
      System.out.println("MSG: received by model: "+messageName+" | "+messagePayload.toString());
    } else {
      System.out.println("MSG: received by model: "+messageName+" | No data sent");
    }
    
    if (messageName.equals("hit")) {
        
    }
    
    if (messageName.equals("stay")) {
        DealerAI();

        if (countCards(dealer) > countCards(player)) {
          mvcMessaging.notify("dealer");
        } else {
          mvcMessaging.notify("player");
        }
    }
    
    if (messageName.equals("quit")) {
        this.newGame();
    }
  }
}
