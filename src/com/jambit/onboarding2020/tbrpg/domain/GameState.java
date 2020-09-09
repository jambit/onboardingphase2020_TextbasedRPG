package com.jambit.onboarding2020.tbrpg.domain;

import java.util.ArrayList;

/**
 * This class contains all states of the game e.g. health, level ups, items etc...
 */
public class GameState {

   private int healtState;
   private String gamerName;
   private ArrayList<Item> itemList;

   public GameState(){
      itemList = new ArrayList<>(); //maybe add here typical starting items

   }

   public int getHealtState() {
      return healtState;
   }

   public void setHealtState(int healtState) {
      this.healtState = healtState;
   }

   public String getGamerName() {
      return gamerName;
   }

   public void setGamerName(String gamerName) {
      this.gamerName = gamerName;
   }
}
