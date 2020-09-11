package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Room.AbstractRoom;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Test_Room {

    public static void main(String[] args) {

        Random r = new Random();
        int low = 10;
        int high = 100;
        System.out.println(r.nextInt(high-low) +low );

    }
}