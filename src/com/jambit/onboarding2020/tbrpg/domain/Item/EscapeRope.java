package com.jambit.onboarding2020.tbrpg.domain.Item;

import com.jambit.onboarding2020.tbrpg.core.GameState;

public class EscapeRope implements Consumable {

    @Override
    public void consume() {
        GameState.getGameStateInstance().escapeRopeActive = true;
    }
}
