package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.domain.Item.Consumable;
import com.jambit.onboarding2020.tbrpg.domain.Item.Item;
import com.jambit.onboarding2020.tbrpg.domain.Item.ItemGenerator;
import com.jambit.onboarding2020.tbrpg.domain.Player.Inventory;
import com.jambit.onboarding2020.tbrpg.domain.Player.Tradeable;
import javax.naming.InsufficientResourcesException;

public class Merchant extends AbstractRoom {

    private Inventory inventory;

    public Merchant(ItemGenerator itemGenerator, Tradeable player){
        this.inventory = new Inventory();
        this.inventory.putInInventory(itemGenerator.newJunk());
        this.inventory.putInInventory(itemGenerator.newJunk());
        this.inventory.putInInventory(itemGenerator.newConsumable(Consumable.HEALTH));
        this.inventory.putInInventory(itemGenerator.newConsumable(Consumable.ESCAPE));
        this.inventory.putInInventory(itemGenerator.newWeapon(player.getAtkDamage()));
        this.inventory.putInInventory(itemGenerator.newWeapon(player.getAtkDamage()));
    }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Du siest das Schild \" Tante Emmas\" willst du eintreten");
    }

    public void sell(Item item, Tradeable player) throws InsufficientResourcesException {
        if (player.getBalance() < item.getSellValue()) {
            this.inventory.pullFromInventory(item);
            player.putInInventory(item);
            player.setBalance(player.getBalance()-item.getSellValue());
        }else{
            throw new InsufficientResourcesException();
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void printInventory() {
        this.inventory.printInventory();
    }

}
