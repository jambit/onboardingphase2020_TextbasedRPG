package com.jambit.onboarding2020.tbrpg.domain.Player;

import com.jambit.onboarding2020.tbrpg.domain.Item.Item;

public interface Tradeable {

    int getAtkDamage();
    int getBalance();
    void setBalance(int balance);
    void sell(Item item);
    void putInInventory(Item item);

}
