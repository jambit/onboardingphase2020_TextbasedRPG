package com.jambit.onboarding2020.tbrpg.games;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

public class Magic8Ball implements Playable{


   @Override
   public void play(Player player) {
      System.out.println("Magic 8 ball says: http://www.ask8ball.net/");
   }
}
