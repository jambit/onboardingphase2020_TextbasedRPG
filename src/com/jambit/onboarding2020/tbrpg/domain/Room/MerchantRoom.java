package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.domain.Item.Item;
import com.jambit.onboarding2020.tbrpg.domain.Item.ItemGenerator;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MerchantRoom extends AbstractRoom {

    private ArrayList<Item> inventory;

    public MerchantRoom() {
        ItemGenerator itemGenerator = new ItemGenerator();
        this.inventory = new ArrayList<Item>();
        this.inventory.add(itemGenerator.newWeapon(10));
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Du siest das Schild \" Tante Emmas\" willst du eintreten");
    }
    @Override
    public void enter(Player player) {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        while (line.equalsIgnoreCase("quit") == false) {
            player.printInventory();
            Item myItem = new Item();
            player.buy(inventory, myItem);
            //Implement your custom room logic here
            try {
                line = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
