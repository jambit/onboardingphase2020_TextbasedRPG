package com.jambit.onboarding2020.tbrpg.domain;

import java.util.ArrayList;

public class Player extends Person {

    private ArrayList<Item> itemList;
    private double money;

    public Player() {
        this.attackDamage = 10;
    }


}
