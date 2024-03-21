package Test;

import Pages.GameLobby;
import Pages.Game_mainLobby;
import Pages.Platform;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.*;

import java.io.FileInputStream;
import java.util.Properties;

public class TestScript {

    WebDriver driver;
   public Platform p_launch;
   public GameLobby g_lobby;
   public Game_mainLobby gm_lobby;
   public Emulation emu;
   public Selenium selenium;
   public Properties config=new Properties();


    @BeforeClass
    public void tearUp()
    {
        try {
            FileInputStream input= new FileInputStream("IWG.properties");
            config.load(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver=DriverFactory.launchDriver(config.getProperty("Browser_name"));
        p_launch=new Platform(driver);
        g_lobby=new GameLobby(driver);
        gm_lobby=new Game_mainLobby(driver);
        selenium=new Selenium(driver);
        emu=new Emulation(driver);
    }


    @Test
    public void verify_player_able_to_Launch_platform() {
        p_launch.launch();
        Assert.assertEquals(p_launch.text(),config.getProperty("Platform"));
    }


    @Test(dependsOnMethods = "verify_player_able_to_Launch_platform")
    public void verify_player_is_able_to_launch_Game_lobby()
    {
        p_launch.SelectGame();
        Assert.assertEquals(g_lobby.LobbyTitle(),config.getProperty("LobbyTitle"));
    }


    @Test(dependsOnMethods = "verify_player_is_able_to_launch_Game_lobby")
    public void verify_player_is_able_to_launchGAME() throws FindFailed {
        g_lobby.click_Launch();
        Assert.assertTrue(Sikuli.verify("lobby_name"));
    }

    @Test(dependsOnMethods ="verify_player_is_able_to_launchGAME")
    public void verify_the_game_url()
    {
        Assert.assertEquals(selenium.get_url(),config.getProperty("URL1"));
    }


    @Test(dependsOnMethods = "verify_player_is_able_to_launchGAME")
    public void verify_the_game_sound() throws FindFailed {
       gm_lobby.emulationWindow();
       gm_lobby.gameSound(config.getProperty("sound"));
    }


    @Test(dependsOnMethods = "verify_the_game_sound")
    public void verify_splash_screen_to_base_game() throws FindFailed {
        Sikuli.click("click");
        Assert.assertTrue(Sikuli.verify("play"));
    }

    @Test(dependsOnMethods ="verify_splash_screen_to_base_game" )
    public void verify_game_logo() throws FindFailed {
        Assert.assertTrue(Sikuli.verify("game_title"));
    }

    @Test(dependsOnMethods = "verify_splash_screen_to_base_game")
    public void verify_paytable_is_opening() throws FindFailed {
        Sikuli.click("paytable_button");
        Assert.assertTrue(Sikuli.verify("paytable_1"));
    }

    @Test(dependsOnMethods = "verify_paytable_is_opening")
    public void verify_the_paytable_formatting() throws FindFailed {
        Assert.assertTrue(Sikuli.verify("paytable_format"));
    }

    @Test(dependsOnMethods = "verify_the_paytable_formatting")
    public void press_next_button_on_paytable() throws FindFailed {
        Sikuli.click("forward_paytable");
        Assert.assertTrue(Sikuli.verify("paytable_2"));
    }


    @Test(dependsOnMethods = "press_next_button_on_paytable")
    public void verify_after_cancel_paytable_game_goes_to_base_GAME() throws FindFailed {
        Sikuli.click("cancel_paytable");
        Assert.assertTrue(Sikuli.verify("game_title"));
    }


    @Test(dependsOnMethods = "verify_after_cancel_paytable_game_goes_to_base_GAME",testName = "Open the info game")
    public void verify_setting_page_is_opening() throws FindFailed {
        Sikuli.click("open_info");
        Assert.assertTrue(Sikuli.verify("close_info"));
    }

    @Test(dependsOnMethods = "verify_setting_page_is_opening")
    public void verify_game_rtp() throws FindFailed {
        Sikuli.rtp();
        Assert.assertTrue(Sikuli.verify("game_rtp"));
    }

    @Test(dependsOnMethods = "verify_game_rtp")
    public void verify_the_paytable_in_setting_page() throws FindFailed {
        Sikuli.click("info_paytable_btn");
        Assert.assertTrue(Sikuli.verify("info_pay"));
    }


    @Test(dependsOnMethods = "verify_the_paytable_in_setting_page")
    public void verify_setting_is_closed() throws FindFailed {
        Sikuli.click("close_info");
        Assert.assertTrue(Sikuli.verify("game_title"));
    }


    @Test(dependsOnMethods = "verify_setting_is_closed")
    public void verify_player_is_having_losing_game() throws FindFailed {
        Sikuli.playAgain("0");
        Assert.assertTrue(Sikuli.image_verfy("play_disable"));
    }


    @Test(dependsOnMethods = "verify_player_is_having_losing_game")
    public void verify_player_is_having_wining_game() throws FindFailed {
        Sikuli.playAgain("5");
        Assert.assertTrue(Sikuli.image_verfy("play_disable"));
    }


    @Test(dependsOnMethods = "verify_player_is_having_wining_game")
    public void verify_player_is_having_BIG_WIN_game() throws FindFailed {
        Sikuli.playAgain("30");
        Assert.assertTrue(Sikuli.image_verfy("play_disable"));
    }


    @Test(dependsOnMethods = "verify_player_is_having_BIG_WIN_game")
    public void verify_player_is_having_HUGE_WIN_game() throws FindFailed {
        Sikuli.playAgain("50");
        Assert.assertTrue(Sikuli.image_verfy("play_disable"));
    }


    @Test(dependsOnMethods = "verify_player_is_having_HUGE_WIN_game")
    public void verify_max_amount_on_max_stack() throws FindFailed {
        wager.change_wager(6);
        Sikuli.playAgain("5000");
        Assert.assertTrue(Sikuli.image_verfy("play_disable"));
        Sikuli.waiting("play_enable");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
