package com.jambit.onboarding2020.tbrpg.games;

import com.jambit.onboarding2020.tbrpg.domain.Players.Player;
import com.jambit.onboarding2020.tbrpg.domain.Players.PlayerDeadException;

public interface Playable {

   //This method starts a game
   void play() throws PlayerDeadException;
   Player player = Player.getPlayerInstance();
}
