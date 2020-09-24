package com.jambit.onboarding2020.tbrpg.domain.Players;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends Person {

    Random random = new Random();
    private int critChance ;
    private int hitChance;
    private String pika = "PIKACHU!!!";
    private String bisa = "Bisa...sam?";
    private String glum = "Omg ein Glumanda!";
    private String schig = "ein wildes Schiggy?!";
    private String name;
    List<String> possibleNames = new ArrayList<>();

    public Enemy () {
        this.attackDamage = (int)(Math.random()*20 + 10);
        this.healthState = (int)(Math.random()*100 + 50);
        this.name = getRandomName();
    }

    public void attack (Player damagedPerson) throws PlayerDeadException{
        this.critChance = (int)(Math.random() + 0.3);
        this.hitChance = (int)(Math.random() + 0.5);
        if (Math.random() <= hitChance){
            if (Math.random()<= critChance) {
                damagedPerson.decreaseHealthState((int) (this.attackDamage
                        + (this.attackDamage * critChance)));
                System.out.println(" █████╗ ██╗   ██╗████████╗███████╗ ██████╗██╗  ██╗██╗\n" +
                        "██╔══██╗██║   ██║╚══██╔══╝██╔════╝██╔════╝██║  ██║██║\n" +
                        "███████║██║   ██║   ██║   ███████╗██║     ███████║██║\n" +
                        "██╔══██║██║   ██║   ██║   ╚════██║██║     ██╔══██║╚═╝\n" +
                        "██║  ██║╚██████╔╝   ██║   ███████║╚██████╗██║  ██║██╗\n" +
                        "╚═╝  ╚═╝ ╚═════╝    ╚═╝   ╚══════╝ ╚═════╝╚═╝  ╚═╝╚═╝" +
                        "\nWas soll das! Der Gegner hat einen kritischen Treffer erzielt!");
            }
            else {
                damagedPerson.decreaseHealthState(this.attackDamage);
                System.out.println("  ___  _               _      _ \n" +
                        "  / _ \\| |_    _ _  ___(_)_ _ | |\n" +
                        " | (_) | ' \\  | ' \\/ -_) | ' \\|_|\n" +
                        "  \\___/|_||_| |_||_\\___|_|_||_(_)" +
                        "\nDer Gegner hat dich getroffen... das war nicht sehr effektiv");
            }
        }
        else
            System.out.println("               _    _ \n" +
                    "  _  _ ___ __ _| |_ | |\n" +
                    " | || / -_) _` | ' \\|_|\n" +
                    "  \\_, \\___\\__,_|_||_(_)\n" +
                    "  |__/                 " +
                    "\nDu hast den Angriff abgewehrt!");
    }


    public void decreaseHealthState(int lostHP) throws EnemyDeadException{
        this.healthState -= lostHP;

        if (this.healthState <= 0) {
            this.healthState = 0;
            throw new EnemyDeadException("Du hast deinen Gegner besiegt!");
        }
    }

    public String getRandomName(){
        possibleNames.add(pika);
        possibleNames.add(bisa);
        possibleNames.add(glum);
        possibleNames.add(schig);

        return possibleNames.get(random.nextInt(possibleNames.size()));
    }

    public String getAsciiArt(String enemyName){
        if (enemyName == pika){
            return "`;-.          ___,\n" +
                    "  `.`\\_...._/`.-\"`\n" +
                    "    \\        /      ,\n" +
                    "    /()   () \\    .' `-._\n" +
                    "   |)  .    ()\\  /   _.'\n" +
                    "   \\  -'-     ,; '. <\n" +
                    "    ;.__     ,;|   > \\\n" +
                    "   / ,    / ,  |.-'.-'\n" +
                    "  (_/    (_/ ,;|.<`\n" +
                    "    \\    ,     ;-`\n" +
                    "     >   \\    /\n" +
                    "    (_,-'`> .'\n" +
                    "         (_,'";
        }
        if (enemyName == bisa){
            return"░░░░░███░░░░░░░░░░░░░\n" +
                    "░░░░█░░░ █░░░░░░░░░░░░\n" +
                    "░░░░█▒░▒ ███░░░░░░░░░░\n" +
                    "░░██▒░▒░▒░▒ ██░░░░░░░░\n" +
                    "░█▒▒▒░▒░▒▒░▒▒ █░░█░░░░\n" +
                    "█▒▒▒░▒▒░▒▒▒░▒███░█░░░\n" +
                    "█▒▒░▒▒▒▒░▒▒██▒░░░ █░░░\n" +
                    "█▒▒░▒▒▒▒░▒█▒▒░░░░ █░░░\n" +
                    "░█▒░▒▒▒███▒░▒▒░▒░░ █░░\n" +
                    "█▒██░▒▒█░░░░░░░░░ ▒██░\n" +
                    "█▒▒▒███▒█░░░░▒░░░ ▒██░\n" +
                    "█▒▒█▒▒▒▒▒░░██░▒░░░░ █░\n" +
                    "░███▒█▒█▒░▒▒▓█░░░░ ▒█░\n" +
                    "░░░░█▒▒▒█▒░▒▓█░░░ ▒█░░\n" +
                    "░░░░█▒▒▒▒█▒▒▒▒▒▒██░░░\n" +
                    "░░░░█░▒░████████░░░░░\n" +
                    "░░░░░███░░░░░░░░░░░░░";
        }
        if (enemyName == glum){
            return "░░░░░░░░░░░░░░░░░░░░░░\n" +
                    "░░░█░░░░░░░░░████░░░░░\n" +
                    "░░█░█░░░░░░░█▒░░░ █░░░░\n" +
                    "░█░░█░░░░░░█▒░░░░░ █░░░\n" +
                    "░█░░█░░░░░░█░░░░░░ █░░░\n" +
                    "█░▒░░█░░░░█▒░░░░░░░ █░░\n" +
                    "█░▒▒░█░░░░█▒░░█░░░░░ █░\n" +
                    "█░▒▒░█░░░█▒▒▒░██░░░░ █░\n" +
                    "░██▒█░░░░█▒▒▒░██░░░░ █░\n" +
                    "░░█▒█░░░█▒▒▒▒▒░░░░░ █░░\n" +
                    "░░█▒▒█░█▒▒▒▒▒▒▒▒▒ ██░░░\n" +
                    "░░░█▒▓██▒▒▒█▒▒▒ ██░░░░░\n" +
                    "░░░█▒▓█▒▒▒▒▒█░░ █░░░░░░\n" +
                    "░░░░█▒█▒▒▒██░░░ █░░░░░░\n" +
                    "░░░░░██▒▒▒▒░░░ █░█░░░░░\n" +
                    "░░░░░░██▒▒▒░░ ███░░░░░░\n" +
                    "░░░░░░░██▒ ███░░░░░░░░░\n" +
                    "░░░░░░░█░▒░ █░░░░░░░░░░\n" +
                    "░░░░░░░░███ ░░░░░░░░░░░";
        }
        if (enemyName == schig){
            return "░░███░░░░░░░░░████░░░\n" +
                    "░█░░░█░░░░░░██░░░░ █░░\n" +
                    "█▒▒░░░█░░░██░░░░░░░ █░\n" +
                    "█▒█▒░░█░██▓█░░░░░░░ █░\n" +
                    "█▒▒█▒░▒█▓▓▓▒░░░░░░░▓ █\n" +
                    "░█▒█▒▒█▓▓▓▒▒░░█░░░░░ █\n" +
                    "░░███▒█▓▓▓▒▒▒░▓█░░░▒ █\n" +
                    "░░░░██▓▓▓▒█▒▒▒▓█░▒▒ █░\n" +
                    "░░░░░█▓▓▒░░██▒▒▒▒█ █░░\n" +
                    "░░░░░█▓▓▒░░░░████░ █░░\n" +
                    "░░░░░█▓▓▒█░░░█▒▒█ █░░░\n" +
                    "░░░░░█▓▓▒████▒▒ █░░░░░\n" +
                    "░░░░░░█▒█▒▒▒▒▒█░ █░░░░\n" +
                    "░░░░░░█▒█░▒▒███ █░░░░░\n" +
                    "░░░░░░░██░███░░░░░░░░\n" +
                    "░░░░░░░█░░░█░░░░░░░░░\n" +
                    "░░░░░░░░███░░░░░░░░░░";
        }
        return "";
    }


    public String getName() {
        return name;
    }
}
