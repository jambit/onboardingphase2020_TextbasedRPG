package com.jambit.onboarding2020.tbrpg.domain.Player;

import com.jambit.onboarding2020.tbrpg.domain.Item.Consumable;
import com.jambit.onboarding2020.tbrpg.domain.Item.Item;
import com.jambit.onboarding2020.tbrpg.domain.Item.Weapon;
import com.jambit.onboarding2020.tbrpg.utils.GameConstants;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;


public class Player extends Person {

    private static final Player playerInstance = new Player();
    private int balance = 0;
    private final ArrayList<Item> inventory;
    private Weapon equippedWeapon;

    private Player() {
        inventory = new ArrayList<>();
        attackDamage = GameConstants.PLAYER_ATTACK_DAMAGE;
    }

    public static Player getPlayerInstance() {
        return playerInstance;
    }
    public int getBalance() {
        return balance;
    }

    public int increaseBalance(int addedMoney){
        this.balance = balance + addedMoney;
        return balance;
    }

    public void sell(Item item) {
        this.inventory.remove(item);
        this.balance += item.getSellValue();
    }

    public void attack (Enemy damagedPerson, Weapon equippedWeapon) throws EnemyDeadException {
        if (equippedWeapon == null){
            System.out.println("Du hast keine Waffe angelegt... viel Glück mit deinen Fäusten!" +
                    "\n_____________________________________________________");
            if(Math.random() <= 0.8){
            damagedPerson.decreaseHealthState(this.attackDamage);
            System.out.println("            __ __\n" +
                    "    /´¯`/'   '/´ /¯`•\n" +
                    "   /'/  /    /    /¨  /¯\\\n" +
                    "  ('(    ´    ´   ¯´/'   ')\n" +
                    "   \\                 '   /\n" +
                    "    '\\'   \\            •´\n" +
                    "      \\              (\n" +
                    "       \\             )  " +
                    "\nDeine Fäuste treffen das Pokemon! Aber es scheint nicht so viel davon zu halten..." +
                    "\n_____________________________________________________");
            }
            else {
                System.out.println("Komm schon, das war ja meilenweit daneben geschlagen!");
            }
            return;
        }
        if (Math.random() <= equippedWeapon.getHitChance()){
            if (Math.random()<= equippedWeapon.getCritChance()){
                damagedPerson.decreaseHealthState((int) (this.attackDamage
                        + (this.attackDamage*equippedWeapon.getCritChance())));
                System.out.println("   .\n" +
                        "  / \\\n" +
                        "  | |\n" +
                        "  | |\n" +
                        "  |.|\n" +
                        "  |.|\n" +
                        "  |:|\n" +
                        "  |:|\n" +
                        "`--8--'\n" +
                        "   8\n" +
                        "   O\n" +
                        "\n" +
                        "\n Du greifst das arme Pokemon mit einer WAFFE AN?!... Das ist sehr effektiv!");
            }
            else{
                damagedPerson.decreaseHealthState(this.attackDamage);
                System.out.println("   .\n" +
                        "  / \\\n" +
                        "  | |\n" +
                        "  | |\n" +
                        "  |.|\n" +
                        "  |.|\n" +
                        "  |:|\n" +
                        "  |:|\n" +
                        "`--8--'\n" +
                        "   8\n" +
                        "   O\n" +
                        "\n" +
                        "\nDas war ja nicht gerade ein harter Schlag... ");
            }
    }
        else
            System.out.println("Was ist denn mit deinem Aim los?! Das war daneben!");
    }

    public void attackBoss (Boss boss, Weapon equippedWeapon) throws EnemyDeadException {
        if (equippedWeapon == null){
            System.out.println("Du hast bei nem Endgegner keine Waffe angelegt? Hast du nicht mehr alle Tassen im Schrank?!" +
                    "\n_____________________________________________________");
            if(Math.random() <= 0.9){
                boss.decreaseHealthState(this.attackDamage);
                System.out.println("            __ __\n" +
                        "    /´¯`/'   '/´ /¯`•\n" +
                        "   /'/  /    /    /¨  /¯\\\n" +
                        "  ('(    ´    ´   ¯´/'   ')\n" +
                        "   \\                 '   /\n" +
                        "    '\\'   \\            •´\n" +
                        "      \\              (\n" +
                        "       \\             )  " +
                        "\nDeine Fäuste treffen Ash ! Damit kitzelst du ihn ja nur..." +
                        "\n_____________________________________________________");
            }
            else {
                System.out.println("Das war zwar ein Treffer aber... Streng dich doch mal an! Das ist ein BOSSKAMPF!");
            }
            return;
        }
        if (Math.random() <= equippedWeapon.getHitChance()){
            if (Math.random()<= equippedWeapon.getCritChance()){
                boss.decreaseHealthState((int) (this.attackDamage
                        + (this.attackDamage*equippedWeapon.getCritChance())));
                System.out.println("   .\n" +
                        "  / \\\n" +
                        "  | |\n" +
                        "  | |\n" +
                        "  |.|\n" +
                        "  |.|\n" +
                        "  |:|\n" +
                        "  |:|\n" +
                        "`--8--'\n" +
                        "   8\n" +
                        "   O\n" +
                        "\n" +
                        "\n Geht doch! Ein kritischer Treffer!");
            }
            else{
                boss.decreaseHealthState(this.attackDamage);
                System.out.println("   .\n" +
                        "  / \\\n" +
                        "  | |\n" +
                        "  | |\n" +
                        "  |.|\n" +
                        "  |.|\n" +
                        "  |:|\n" +
                        "  |:|\n" +
                        "`--8--'\n" +
                        "   8\n" +
                        "   O\n" +
                        "\n" +
                        "\nWenn du den Boss besiegen willst, musst du schon härter zuschlagen...");
            }
        }
        else
            System.out.println("Sag mal, hast du Tomaten auf den Augen? Das war DANEBEN!");
    }

    @Override
    public void decreaseHealthState(int lostHP) throws PlayerDeadException {
        this.healthState -= lostHP;

        if (this.healthState <= 0) {
            this.healthState = 0;
            throw new PlayerDeadException("             ___          \n" +
                    "            /   \\\\        \n" +
                    "       /\\\\ | . . \\\\       \n" +
                    "     ////\\\\|     ||       \n" +
                    "   ////   \\\\ ___//\\       U DED\n" +
                    "  ///      \\\\      \\      \n" +
                    " ///       |\\\\      |     \n" +
                    "//         | \\\\  \\   \\    \n" +
                    "/          |  \\\\  \\   \\   \n" +
                    "           |   \\\\ /   /   \n" +
                    "           |    \\/   /    \n" +
                    "           |     \\\\/|     \n" +
                    "           |      \\\\|     \n" +
                    "           |       \\\\     \n" +
                    "           |        |     \n" +
                    "           |_________\\    ");
        }
    }

    public void buy(Item item) throws InsufficientResourcesException {
        // if balance nicht ausreichend oder inventory voll, dann exception werfen
        if (this.getBalance() > item.getSellValue()) {
            this.inventory.add(item);
            this.balance -= item.getSellValue();
        } else throw new InsufficientResourcesException();
    }

    public void printInventory() {
        if (this.inventory.size() == 0) {
            System.out.println("--LEER--");
        } else {
            System.out.println("Dein Inventar:");
            System.out.println("------------------------------------");
            int counter = 1;
            for (Item i : inventory) {
                System.out.println(counter + ": " + i);
                counter++;

            }
            System.out.println("------------------------------------");

        }
    }

    public ArrayList<Item> getInventory() {
        return this.inventory;
    }

    public Weapon getEquippedWeapon() {
               return equippedWeapon;
    }
    public String printEquippedWeapon() {
        if (equippedWeapon == null){
            return "Keine";
        }
        return getEquippedWeapon().toString();
    }

    public void equipWeapon(Weapon weapon) {
        if (equippedWeapon == null) {
            this.attackDamage = this.attackDamage + weapon.getAtkDamage();
            System.out.println("Dein Angriffsschaden liegt nun bei " + this.attackDamage);
            this.equippedWeapon = weapon;
        } else {
            System.out.println("Du hast bereits" + equippedWeapon + " ausgerüstet.");
            System.out.println("Du musst die Waffe erst ablegen.");
        }
    }

    public void unequipWeapon() {
        if (equippedWeapon == null) {
            System.out.println("Du hast aktuell keine Waffe ausgerüstet.");
        } else {
            System.out.println("Du hast " + equippedWeapon + " abgelegt.");
            this.attackDamage = this.attackDamage - equippedWeapon.getAtkDamage();
            equippedWeapon = null;
        }
    }

    public Item getItemFromInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }

    public Consumable getConsumableFromInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                try {
                    return (Consumable) item;
                } catch (Exception e) {
                    break;
                }
            }
        }
        return null;
    }

    public void putInInventory(Item item) {
        this.inventory.add(item);
    }

    public ArrayList<Weapon> getWeaponsFromInventory() {
        ArrayList<Weapon> weaponList = new ArrayList<>();
        for (Item item : this.inventory) {
            try {
                weaponList.add((Weapon) item);
            } catch (Exception e) {
                System.out.print("");
            }
        }
        return weaponList;
    }

    public boolean printWeaponsFromInventory() {
        ArrayList<Weapon> weaponsFromInventory = this.getWeaponsFromInventory();
        int counter = 1;
        for (Weapon weapon : weaponsFromInventory) {
            System.out.println(counter + ": " + weapon);
            counter++;
        }
        return counter != 1;
    }

    public boolean isWeaponInventoryEmpty() {
        ArrayList<Weapon> weaponsFromInventory = this.getWeaponsFromInventory();
        int counter = 1;
        for (Weapon weapon : weaponsFromInventory) {
            counter++;
        }
        return counter != 1;
    }

    public Item takeItemFromInventory(String itemName) {
        Item item = this.getItemFromInventory(itemName);
        this.inventory.remove(item);
        return item;
    }

}
