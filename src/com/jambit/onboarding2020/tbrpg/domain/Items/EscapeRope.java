package com.jambit.onboarding2020.tbrpg.domain.Items;

import com.jambit.onboarding2020.tbrpg.core.GameState;

public class EscapeRope extends Item implements Consumable{

    public EscapeRope() {
        this.setName("Fluchtseil");
        this.setLore("Einfach vor Problemen weglaufen ;)");
        this.setSellValue(5);
    }

    @Override
    public void consume() {
        GameState.getGameStateInstance().escapeRopeActive = true;
    }
}
