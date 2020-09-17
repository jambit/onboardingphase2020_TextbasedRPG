package com.jambit.onboarding2020.tbrpg.domain.Room;

public class BossRoom extends AbstractRoom{
    @Override
    public void printWelcomeMessage() {
        System.out.println("Du entscheidest dich, dem Boss gegenüberzutreten..." +
                "\nund trittst ein.");
    }

    @Override
    public void enter() {
        //todo: mockup boss
        /* boss.play(player);*/
        System.out.println("Du besiegst den Boss." +
                "\nPlötzlich bist du von Ehrfurcht für die Spieleentwickler erfüllt." +
                "\nDas ist wahrhaftig das beste Spiel, das du je gesehen hast.");
        return;

    }
    //DAS SPIEL ENDET HIER: WIE?
}
