package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.core.ItemGenerator;
import com.jambit.onboarding2020.tbrpg.domain.Item.*;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

import javax.naming.InsufficientResourcesException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MerchantRoom extends AbstractRoom {

    private final ItemGenerator itemGenerator;
    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    Player player = Player.getPlayerInstance();
    private final ArrayList<Item> inventory;
    private boolean playerWantsToLeave = false;

    public MerchantRoom() {
        this.itemGenerator = new ItemGenerator();
        this.inventory = new ArrayList<>();
    }

    public void printRoomMessage() {
        System.out.println("Zur abwechslung mal ein kleiner Shoppingtrip... ");
    }



    @Override
    public void enter() {

        System.out.println("Willkommen in Tante Emmas Waffenladen");

        String line = "";
        System.out.println("                       _        ,\n" +
                "                      (_\\______/________\n" +
                "                         \\-|-|/|-|-|-|-|/\n" +
                "                          \\==/-|-|-|-|-/\n" +
                "                           \\/|-|-|-|,-'\n" +
                "                            \\--|-'''\n" +
                "                             \\_j________\n" +
                "                             (_)     (_)");
        this.initializeInventory();

        while (!line.equalsIgnoreCase("verlassen")) {

            //Buy or sell
            playerWantsToLeave = false;

            if (line.equalsIgnoreCase("kaufen")) {
                try {
                    this.buyFromMerchant();
                } catch (Exception playerAbortsAction) {
                    playerWantsToLeave = true;
                }
            } else if (line.equalsIgnoreCase("verkaufen")) {
                try {
                    this.sellToMerchant();
                } catch (Exception playerAbortsAction) {
                    playerWantsToLeave = true;
                }
            }
                if (playerWantsToLeave) {
                    line = "";
                } else {
                    System.out.println("Möchtest du [kaufen] oder [verkaufen] oder den Raum [verlassen]?");
                    try {
                        line = "";
                        line = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    @Override
    public void printWelcomeMessage() {
        System.out.println("Du siest das Schild \" Tante Emmas\" willst du eintreten");
    }

    private void initializeInventory() {
        inventory.add(itemGenerator.newJunk());
        inventory.add(itemGenerator.newJunk());
        inventory.add(itemGenerator.newConsumable("health"));
        inventory.add(itemGenerator.newConsumable("escape"));
        inventory.add(itemGenerator.newWeapon(player.getAttackDamage()));
        inventory.add(itemGenerator.newWeapon(player.getAttackDamage()));
    }

    //includes the complete handling for the buy-action
    private void sellToMerchant() throws Exception {

        while (true) {
            System.out.println("Du hast folgendes im Inventar:");
            player.printInventory();
            System.out.println("Was möchtest du verkaufen? \nWähle die Nummer des Items:");
            int index;
            index = this.takeIntOrAbortFromCLI();
            if (index <= player.getInventory().size() && index > 0) {
                player.sell(player.getInventory().get(index - 1));
            } else {
                System.out.println("Ungültige Eingabe: Wähle ein Item, dass der Händler hat oder abbrechen");
            }
        }
    }


    //includes the complete handling for the buy-action
    private void buyFromMerchant() throws Exception {
        int index;

        while (true) {
            System.out.println("Du hast " + player.getBalance() + " an Geld zur verfügung");
            this.printInventory();
            System.out.println("Was möchtest du kaufen? \nWähle die Nummer des Items:");
            index = this.takeIntOrAbortFromCLI();
            if (index <= this.inventory.size() && index > 0) {
                try {
                    player.buy(this.inventory.get(index - 1));
                    this.inventory.remove(index - 1);
                } catch (InsufficientResourcesException insufficientResourcesException) {
                    System.out.println("Du hast nicht genügend Geld um dir das zu kaufen");
                }
            } else {
                System.out.println("Ungültige Eingabe: Wähle ein Item, dass der Händler hat oder [abbrechen]");
            }
        }
    }

    //Prints the current Inventory of the Merchant
    public void printInventory() {

        if (this.inventory.size() == 0) {
            System.out.println("--AUSVERKAUFT--");
        } else {
            System.out.println("Der Händler hat folgendes Angebot:");
            int counter = 1;
            for (Item item : inventory) {
                System.out.println(counter + ":\t" + item.toString());
                counter++;
            }
        }
    }

    private int takeIntOrAbortFromCLI() throws Exception {
        String line = "";
        try {
            line = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (line.equalsIgnoreCase("abbrechen")) {
            throw new Exception();
        }
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException nfe) {
            System.out.print("");
        }
        return -1;
    }

}
