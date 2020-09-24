package com.jambit.onboarding2020.tbrpg.core;

import com.jambit.onboarding2020.tbrpg.domain.Item.Weapon;
import org.junit.Test;
//import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ItemGeneratorTest {

    ItemGenerator itemGenerator = new ItemGenerator();

    @Test
    void newWeapon() {
        //given
        int atkDamage = 5;

        //when
        Weapon weapon = itemGenerator.newWeapon(atkDamage);
        boolean success = weapon.getAtkDamage() < atkDamage + 15 && weapon.getAtkDamage() > 0;

        //then
        assertTrue(success);
        assertFalse(weapon.getName().isEmpty());
    }

    @Test
    void newConsumable() {
    }

    @Test
    void getRoomLoot() {
    }

    @Test
    void interactWithRoomLoot() {
    }
}