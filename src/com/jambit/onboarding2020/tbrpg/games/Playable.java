package com.jambit.onboarding2020.tbrpg.games;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

public interface Playable {

   //This method starts a game
   void play();
   Player player = Player.getPlayerInstance();
}
