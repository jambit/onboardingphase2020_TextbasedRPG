package com.jambit.onboarding2020.tbrpg.domain.Room;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;

public class Hallway extends AbstractRoom {

    @Override
    public void enter(Player player) {
        System.out.println("Nicht schlecht, du hast den Raum geschafft\n Du ruhst dich im Gang zwischen den Räumen kurz aus");
        if (false) { // TODO: 16.09.2020 Eingabe "verwende Heiltrank" überprüfen
            if (false) {
            } // TODO: 16.09.2020 überprüfung ob Heiltrank im Inventar
        } else if (false) { // TODO: 16.09.2020 Eingabe "verwende Fluchttrick" überprüfen
            if (false) {
            } // TODO: 16.09.2020 überprüfung ob Fluchttrick im Inventar
        } else if (false) { // TODO: 16.09.2020 Eingabe "statte Waffe aus" überprüfen
            if (false) {
            } // TODO: 16.09.2020 überprüfung ob Waffe im Inventar
        } else if (false) { // TODO: 16.09.2020 Eingabe "lege Waffe ab" überprüfen
        }
    }
}
