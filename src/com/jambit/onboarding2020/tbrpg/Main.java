package com.jambit.onboarding2020.tbrpg;

import com.jambit.onboarding2020.tbrpg.core.DungeonGenerator;
import com.jambit.onboarding2020.tbrpg.core.GameEngine;
import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;
import com.jambit.onboarding2020.tbrpg.utils.Output;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Willkommen zu unserem Spiel:");
        Output.slow("/^(o.o)^\\ /^(o.o)^\\ /^(o.o)^\\ /^(o.o)^\\ /^(o.o)^\\ /^(o.o)^\\");
        System.out.println(" ___                  _       _    _                ___           _                       _           \n" +
                "(  _`\\               ( )_    ( )_ ( )              (  _`\\        ( )      _  _           ( )        \n" +
                "| (_) )   __     _ _ | ,_)   | ,_)| |__     __     | (_) )   __  | |__   ( )( ) _ __    _| |   __  \n" +
                "|  _ <' /'__`\\ /'_` )| |     | |  |  _ `\\ /'__`\\   |  _ <' /'__`\\|  _ `\\ /'_`\\ ( '__) /'_` | /'__`\\\n" +
                "| (_) )(  ___/( (_| || |_    | |_ | | | |(  ___/   | (_) )(  ___/| | | |( (_) )| |   ( (_| |(  ___/\n" +
                "(____/'`\\____)`\\__,_)`\\__)   `\\__)(_) (_)`\\____)   (____/'`\\____)(_) (_)`\\___/'(_)   `\\__,_)`\\____)");

        DungeonGenerator dungeonGenerator = new DungeonGenerator();
        ArrayList<AbstractRoom> rooms = dungeonGenerator.generateRooms();

        GameEngine gameEngine = new GameEngine(rooms);
        gameEngine.run();
    }
}