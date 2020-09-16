package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.domain.Item.Item;
import com.jambit.onboarding2020.tbrpg.domain.Item.ItemGenerator;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

import javax.naming.InsufficientResourcesException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MerchantRoom extends AbstractRoom {

    private ArrayList<Item> inventory;
    ItemGenerator itemGenerator;
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int exitcode = 0;

    public MerchantRoom() {
        this.itemGenerator = new ItemGenerator();
        this.inventory = new ArrayList<>();
    }

    @Override
    public void enter(Player player) {

        String line = "";
        System.out.println("Willkommen in Tante Emmas Waffenladen");
        System.out.println("                       _        ,\n" +
                "                      (_\\______/________\n" +
                "                         \\-|-|/|-|-|-|-|/\n" +
                "                          \\==/-|-|-|-|-/\n" +
                "                           \\/|-|-|-|,-'\n" +
                "                            \\--|-'''\n" +
                "                             \\_j________\n" +
                "                             (_)     (_)");
        this.initializeInventory(player);

        while (line.equalsIgnoreCase("quit") == false) {

            System.out.println("Möchtest du kaufen oder verkaufen?");
            exitcode = 0;
            //Buy or sell
            if (line.equalsIgnoreCase("kaufen")) {
                this.buyFromMerchant(player);
                line = "";
            } else if (line.equalsIgnoreCase("verkaufen")) {
                this.sellToMerchant(player);
                line = "";
            } else {
                System.out.println("Du hast folgende Möglichkeiten: \"kaufen\" , \"verkaufen\" oder quit");
            }

            if (exitcode != 99) {
                try {
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

    private void initializeInventory(Player player) {
        inventory.add(itemGenerator.newJunk());
        inventory.add(itemGenerator.newJunk());
        inventory.add(itemGenerator.newConsumable("health"));
        inventory.add(itemGenerator.newConsumable("escape"));
        inventory.add(itemGenerator.newWeapon(player.getAttackDamage()));
        inventory.add(itemGenerator.newWeapon(player.getAttackDamage()));
    }

    //includes the complete handling for the buy-action
    private void sellToMerchant(Player player) {

        exitcode = 0;
        while (exitcode != 99) {
            System.out.println("Du hast folgendes im Inventar:");
            player.printInventory();
            System.out.println("Was möchtest du verkaufen? \nWähle die Nummer des Items:");
            int index = this.takeIntFromCLI();
            if (index <= player.getInventory().size()) {
                player.sell(player.getInventory().get(index - 1));
            } else if (exitcode == 99) break;
            else {
                System.out.println("Ungültige Eingabe: Wähle ein Item, dass der Händler hat oder quit");
            }
        }
    }

    //includes the complete handling for the buy-action
    private void buyFromMerchant(Player player) {
        int index;
        exitcode = 0;

        while (exitcode != 99) {
            System.out.println("Du hast " + player.getBalance() + " an Geld zur verfügung");
            this.printInventory();
            System.out.println("Was möchtest du kaufen? \nWähle die Nummer des Items:");
            index = this.takeIntFromCLI();
            if (index <= this.inventory.size()) {
                try {
                    player.buy(this.inventory.get(index - 1));
                    this.inventory.remove(index - 1);
                } catch (InsufficientResourcesException insufficientResourcesException) {
                    System.out.println("Du hast nicht genügend Geld um dir das zu kaufen");
                }
            } else if (index == 99) break;
            else {
                System.out.println("Ungültige Eingabe: Wähle ein Item, dass der Händler hat oder quit");
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

    //gets a new Int from the CLI and catches all possible exceptions
    //if the Read-In String ist quit it returns 99
    private int takeIntFromCLI() {
        String line = "";

        try {
            line = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (line.equalsIgnoreCase("quit") == false) {
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException nfe) {
                System.out.println("Die Eingabe war ungültig, bitte gib nur eine Zahl ein!");
            }

            try {
                line = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.exitcode = 99;
        return 99;
    }

/*//Searches the inventory for an Item with name
       public boolean isItemInInventory(String name) {
        for (Item item : this.inventory) {
            if (item.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }*/

/*    public String takeStringFromCLI() {
        String line = "";
        try {
            line = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }*/

}
