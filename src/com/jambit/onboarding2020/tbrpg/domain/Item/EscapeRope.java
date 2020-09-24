package com.jambit.onboarding2020.tbrpg.domain.Item;

import com.jambit.onboarding2020.tbrpg.core.GameState;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

public class EscapeRope extends Item implements Consumable {

    Player player = Player.getPlayerInstance();

    public EscapeRope() {
        this.setName("Fluchttrick");
        this.setLore("Für was dass wohl gut ist?");
        this.setSellValue(5);
    }

    @Override
    public void consume() {
        GameState.getGameStateInstance().escapeRopeActive = true;
        player.takeItemFromInventory("Fluchttrick");
    }
}
