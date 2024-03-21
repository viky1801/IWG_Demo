package utils;

import org.sikuli.script.FindFailed;

public class wager {

    public static int previous_bet=1;
    public static void change_wager(int expected_bet) throws FindFailed {
        if(previous_bet<expected_bet)
        {
            for(int i=previous_bet;i<expected_bet;i++)
            {
                Sikuli.click("plus_wager");
            }
        }
        else
        {
            for(int i=previous_bet;i>expected_bet;i--)
            {
              Sikuli.click("minus_wager");
            }
        }
        previous_bet=expected_bet;
    }
}
