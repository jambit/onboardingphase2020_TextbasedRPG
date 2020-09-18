package com.jambit.onboarding2020.tbrpg.games;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.domain.Player.PlayerDeadException;

public interface Playable {

   //This method starts a game
   void play() throws PlayerDeadException;
   Player player = Player.getPlayerInstance();
}
