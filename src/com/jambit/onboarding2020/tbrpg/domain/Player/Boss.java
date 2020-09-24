package com.jambit.onboarding2020.tbrpg.domain.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Boss extends Enemy{


        Random random = new Random();
        private int critChance ;
        private int hitChance;
        private String name = "Ash";


        public Boss () {
            this.attackDamage = 30;
            this.healthState = 175;
        }
         public int getAttackDamage(){
            return this.attackDamage;
         }

        public void attack (Player damagedPerson) throws PlayerDeadException{
            this.critChance = (int)(Math.random() + 0.4);
            this.hitChance = (int)(Math.random() + 0.5);
            if (Math.random() <= hitChance){
                if (Math.random()<= critChance) {
                    damagedPerson.decreaseHealthState((int) (this.attackDamage
                            + (this.attackDamage * critChance)));
                    System.out.println(" ██░ ██  ▄▄▄          ██░ ██  ▄▄▄          ██░ ██  ▄▄▄      \n" +
                                    "▓██░ ██▒▒████▄       ▓██░ ██▒▒████▄       ▓██░ ██▒▒████▄    \n" +
                                    "▒██▀▀██░▒██  ▀█▄     ▒██▀▀██░▒██  ▀█▄     ▒██▀▀██░▒██  ▀█▄  \n" +
                                    "░▓█ ░██ ░██▄▄▄▄██    ░▓█ ░██ ░██▄▄▄▄██    ░▓█ ░██ ░██▄▄▄▄██ \n" +
                                    "░▓█▒░██▓ ▓█   ▓██▒   ░▓█▒░██▓ ▓█   ▓██▒   ░▓█▒░██▓ ▓█   ▓██▒\n" +
                                    " ▒ ░░▒░▒ ▒▒   ▓▒█░    ▒ ░░▒░▒ ▒▒   ▓▒█░    ▒ ░░▒░▒ ▒▒   ▓▒█░\n" +
                                    " ▒ ░▒░ ░  ▒   ▒▒ ░    ▒ ░▒░ ░  ▒   ▒▒ ░    ▒ ░▒░ ░  ▒   ▒▒ ░\n" +
                                    " ░  ░░ ░  ░   ▒       ░  ░░ ░  ░   ▒       ░  ░░ ░  ░   ▒   \n" +
                                    " ░  ░  ░      ░  ░    ░  ░  ░      ░  ░    ░  ░  ░      ░  ░"+
                            "\n<<Nimm das du Mörder!>> Ash hat einen kritischen Treffer erzielt!");
                }
                else {
                    damagedPerson.decreaseHealthState(this.attackDamage);
                    System.out.println(" ▄▀▀▀▀▄  ▄▀▀▀█▀▀▄  ▄▀▀█▀▄    ▄▀▀▄▀▀▀▄  ▄▀▀█▄▄       \n" +
                                    "█ █   ▐ █    █  ▐ █   █  █  █   █   █ ▐ ▄▀   █      \n" +
                                    "   ▀▄   ▐   █     ▐   █  ▐  ▐  █▀▀█▀    █▄▄▄▀       \n" +
                                    "▀▄   █     █          █      ▄▀    █    █   █       \n" +
                                    " █▀▀▀    ▄▀        ▄▀▀▀▀▀▄  █     █    ▄▀▄▄▄▀ ▄ ▄ ▄ \n" +
                                    " ▐      █         █       █ ▐     ▐   █    ▐        \n" +
                                    "        ▐         ▐       ▐           ▐             " +
                            "\nDer Gegner hat dich getroffen... das war nicht sehr effektiv");
                }
            }
            else
                System.out.println("┌─┐┬ ┬┬ ┬   \n" +
                                "├─┘│ │├─┤   \n" +
                                "┴  └─┘┴ ┴ooo" +
                        "\nDas war knapp ausgewichen...");
        }


        public void decreaseHealthState(int lostHP) throws EnemyDeadException{
            this.healthState -= lostHP;

            if (this.healthState <= 0) {
                this.healthState = 0;
                throw new EnemyDeadException("Du hast deinen Gegner besiegt!");
            }
        }



        public String getName() {
            return name;
        }
    }


