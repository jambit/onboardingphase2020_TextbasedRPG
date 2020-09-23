package domain.player;

import com.jambit.onboarding2020.tbrpg.domain.Player.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class playerTest {
    @Test
    public void increaseBalance() {
    //given
        int oldBalance = Player.getPlayerInstance().getBalance();
        int testAddedMoney = 10;
    //when
        Player.getPlayerInstance().increaseBalance(testAddedMoney);
        int newBalance = Player.getPlayerInstance().getBalance();

        //then
        Assertions.assertEquals(oldBalance + testAddedMoney, newBalance);
    }
}