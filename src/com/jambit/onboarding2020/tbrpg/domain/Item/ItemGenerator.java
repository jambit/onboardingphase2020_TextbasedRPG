package com.jambit.onboarding2020.tbrpg.domain.Item;

import java.util.Random;

public class ItemGenerator {

    Random random = new Random();

    public Item newJunk(){
        return new Item();
    }

    public Weapon newWeapon(){
        return new Weapon();
    }

    public Item newConsumable(){
        return new Item();
    }

}
