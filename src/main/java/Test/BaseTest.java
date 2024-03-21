package Test;


import Pages.GameLobby;
import Pages.Game_mainLobby;
import Pages.Platform;
import org.example.Game_screen;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DriverFactory;
import utils.Emulation;
import utils.Sikuli;

import java.io.FileInputStream;
import java.util.Properties;

import static Pages.Game_mainLobby.pause;

public class BaseTest {

    WebDriver driver;
    public Platform p_launch;
    public GameLobby g_lobby;
    public Game_mainLobby gm_lobby;
    public Emulation emu;
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
        emu=new Emulation(driver);

    }

    @Test
    public void platformLaunch() {
        p_launch.launch();
        Assert.assertEquals(p_launch.text(),"IWG Test Harness");
    }

    @Test(dependsOnMethods = "platformLaunch")
    public void lobbyLaunch()
    {
        p_launch.SelectGame();
        Assert.assertEquals(g_lobby.LobbyTitle(),config.getProperty("LobbyTitle"));
    }

    @Test(dependsOnMethods = "lobbyLaunch")
    public void launch_game() throws FindFailed {
        g_lobby.click_Launch();
        Assert.assertTrue(Sikuli.verify("lobby_name"));
    }

    @Test(dependsOnMethods = "launch_game")
    public void game_SOUND() throws FindFailed {
        gm_lobby.emulationWindow();
        gm_lobby.gameSound(config.getProperty("sound"));

    }

    @Test(dependsOnMethods = "game_SOUND")
    public void Touch_the_scree() throws FindFailed {
        Sikuli.click("click");
        Assert.assertTrue(Sikuli.verify("play"));
    }


    @Test(dependsOnMethods = "Touch_the_scree")
    public void open_paytable() throws FindFailed {
        Sikuli.click("paytable_button");
        Assert.assertTrue(Sikuli.verify("paytable_1"));
    }

    @Test(dependsOnMethods = "open_paytable")
    public void press_next_button_on_paytable() throws FindFailed {
        Sikuli.click("forward_paytable");
        Assert.assertTrue(Sikuli.verify("paytable_2"));
    }

    @Test(dependsOnMethods = "press_next_button_on_paytable")
    public void cancel_paytable() throws FindFailed {
        Sikuli.click("cancel_paytable");
        Assert.assertTrue(Sikuli.verify("game_title"));
    }

    @Test(dependsOnMethods = "cancel_paytable",testName = "Open the info game")
    public void open_info() throws FindFailed {
        Sikuli.click("open_info");
        Assert.assertTrue(Sikuli.verify("close_info"));
    }


    @Test(dependsOnMethods = "open_info")
    public void verify_paytable_in_setting_button() throws FindFailed {
        Sikuli.click("info_paytable_btn");
        Assert.assertTrue(Sikuli.verify("info_paytable"));
    }


    @Test(dependsOnMethods = "verify_paytable_in_setting_button",testName = "Close the Info page and back to base game screen")
    public void verify_setting_btn_is_closed() throws FindFailed {
        Sikuli.click("close_info");
        Assert.assertTrue(Sikuli.verify("game_title"));
    }

    @Test(dependsOnMethods = "close_info")
    public void increase_wager() throws FindFailed {
        Sikuli.click("plus_wager");
        Assert.assertTrue(Sikuli.verify("wager_$2"));
    }

    @Test(dependsOnMethods = "increase_wager")
    public void play() throws FindFailed {
        emu.force_emulation("10");
        Sikuli.click("play");
        Assert.assertTrue(Sikuli.verify("play_disable"));
        // Sikuli.waiting("play");
    }

    @Test(dependsOnMethods = "play")
    public void max_bet_play() throws FindFailed {
        emu.force_emulation("5");
        Sikuli.click("plus_wager");
        Sikuli.click("play");
        Assert.assertTrue(Sikuli.verify("play_disable"));
    }





    @AfterClass
    public void tearDown()
    {
        // driver.quit();
    }

}
