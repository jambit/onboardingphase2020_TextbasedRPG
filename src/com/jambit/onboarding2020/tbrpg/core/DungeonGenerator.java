package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Room.*;
import com.jambit.onboarding2020.tbrpg.utils.GameConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DungeonGenerator {

    int roomCountPreset = GameConstants.ROOM_COUNT_PRESET;
    Random random = new Random();
    ArrayList<AbstractRoom> possibleRooms = new ArrayList<>();

    public DungeonGenerator() {
        possibleRooms.add(new MobRoom());
        possibleRooms.add(new MobRoom());
        possibleRooms.add(new MobRoom());
        possibleRooms.add(new MerchantRoom());
        possibleRooms.add(new MerchantRoom());
        possibleRooms.add(new QuizRoom());
        possibleRooms.add(new QuizRoom());
        possibleRooms.add(new QuizRoom());
        possibleRooms.add(new TicTacToeRoom());
        possibleRooms.add(new NPCRoom_PublicOfficial());

    }

    public ArrayList<AbstractRoom> generateRooms() {
        Collections.shuffle(possibleRooms);

        possibleRooms.add(new BossRoom());
        return possibleRooms;
    }

    //returns a number between minCount and minCount+3
    // with different probabilities
    private int getRandomCount(int minCount) {
        return random.nextInt(3) + minCount;
    }

}
