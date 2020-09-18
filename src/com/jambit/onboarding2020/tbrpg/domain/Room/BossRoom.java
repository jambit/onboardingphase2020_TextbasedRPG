package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.core.GameInput;
import com.jambit.onboarding2020.tbrpg.domain.Player.Enemy;
import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import com.jambit.onboarding2020.tbrpg.games.quizGame.QuizMaster;

import java.io.InputStreamReader;
import java.util.Random;

public class BossRoom extends AbstractRoom {
    @Override
    public void printWelcomeMessage() {
        System.out.println("Du entscheidest dich, dem Boss gegenüberzutreten..." +
                "\nund trittst ein.");
    }
//todo: make real boss

    public void enter() {
        Player player = Player.getPlayerInstance();

        GameInput in = new GameInput(new InputStreamReader(System.in));
        Enemy enemy = new Enemy(); // Name übergeben von Enemy
        Random random = new Random();

        System.out.println("Du bist gefangen und kommst nur raus, wenn du den Gegner tötest, oder 'quit' drückst");
        System.out.println("Attack Damage Player: " + Player.getPlayerInstance().getHealthState());
        System.out.println("Attack Damage Enemy: " + enemy.getHealthState());

        while (in.gameState()) {
            System.out.println("Drücke 1) um anzugreifen oder 2) um zu verteidigen.");

            try {
                fight(in, enemy, random);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            evaluateFight(in, enemy);
        }
    }

    private void fight(GameInput in, Enemy enemy, Random random) throws Exception {
        int input = in.inputInteger();

        if (input == 1) {
            if (random.nextBoolean()) {
                Player.getPlayerInstance().attack(enemy);
                System.out.println("Treffer!");
            } else {
                System.out.println("Der Boss hat den Angriff abgewehrt");
            }
        }

        if (random.nextBoolean()) {
            if (input == 2) {
                System.out.println("Du hast den Angriff des Boss abgewehrt!");
            } else {
                enemy.attack(Player.getPlayerInstance());
                System.out.println("Du wurdest getroffen!");
            }
        }
    }

    private void evaluateFight(GameInput in, Enemy enemy) {
        System.out.println("Lebenspunkte des Players: " + Player.getPlayerInstance().getHealthState());
        System.out.println("Lebenspunkte des Boss: " + enemy.getHealthState());

        if (Player.getPlayerInstance().getHealthState() == 0) {
            in.looseGame();
        }

        if (enemy.getHealthState() == 0) {
            in.winGame();
        }

        System.out.println("Du besiegst den Boss." +
                "\nPlötzlich bist du von Ehrfurcht für die Spieleentwickler erfüllt." +
                "\nDas ist wahrhaftig das beste Spiel, das du je gesehen hast.");
        return;
    }

    }
    //DAS SPIEL ENDET HIER: WIE?

}


