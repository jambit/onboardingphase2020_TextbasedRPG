package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Player.PlayerDeadException;
import com.jambit.onboarding2020.tbrpg.domain.Room.BossRoom;
import com.jambit.onboarding2020.tbrpg.domain.Room.NPCRoom_PublicOfficial;
import com.jambit.onboarding2020.tbrpg.domain.Room.StoryRoom;

public class Test_Room {
    // TODO: 16.09.2020 Delete this class if not further needed
    public static void main(String[] args) throws PlayerDeadException {

       BossRoom bossRoom= new BossRoom();
        bossRoom.printWelcomeMessage();
        bossRoom.enter();
/*



        for (int i = 0; i < 100; i++) {
            MarkovChain.printRandomSentence();
            System.out.println();
        }
*/


    }
}