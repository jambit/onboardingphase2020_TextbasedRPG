package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

import java.util.Scanner;

public class Hallway extends AbstractRoom {

    Scanner in = new Scanner(System.in);

    @Override
    public void enter(Player player) {
        System.out.println("Nicht schlecht, du hast den Raum geschafft\n Du ruhst dich im Gang zwischen den Räumen kurz aus");
        if (in.nextLine().equalsIgnoreCase("verwende Heiltrank")) {
            if (false) {
            } // TODO: 16.09.2020 überprüfung ob Heiltrank im Inventar
        } else if (in.nextLine().equalsIgnoreCase("verwende Fluchttrick")) {
            if (false) {
            } // TODO: 16.09.2020 überprüfung ob Fluchttrick im Inventar
        } else if (in.nextLine().equalsIgnoreCase("statte Waffe aus")) {
            // TODO: 17.09.2020 Ausgaben möglicher Waffen
            if (false) {
            } // TODO: 17.09.2020 Ausstattung der Waffe und abfrage welche Waffe
        } else if (in.nextLine().equalsIgnoreCase("lege Waffe ab")) {
        }
    }
}
