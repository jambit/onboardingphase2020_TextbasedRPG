package com.jambit.onboarding2020.tbrpg.domain.Item;

import com.jambit.onboarding2020.tbrpg.core.GameState;

public class EscapeRope extends Item implements Consumable {

    public EscapeRope() {
        this.setName("Fluchtseil");
        this.setLore("Für was dass wohl gut ist?");
        this.setSellValue(5);
    }

    @Override
    public void consume() {
        GameState.getGameStateInstance().escapeRopeActive = true;
    }
}
