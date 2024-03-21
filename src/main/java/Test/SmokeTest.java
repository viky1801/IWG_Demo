package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class SmokeTest {
    public WebDriver driver;
    public Properties properties=new Properties();
    public Emulation emu;

    @BeforeClass
    void tearUp()
    {
        driver= DriverFactory.launchDriver("firefox");
        try {
            FileInputStream input= new FileInputStream("IWG.properties");
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        emu=new Emulation(driver);
    }

    @Test
    void clear_cache()
    {
        driver.manage().deleteAllCookies();
    }

    @Test(dependsOnMethods = "clear_cache")
    void game_URL()
    {
        driver.get("http://iwg:c4shBusterspin!@test-harness.instantwingaming.com/play-game/?platform=atlanticlottery-3&game=alc-multiprice-christmas-carol&currency=USD&language=en&playerId=1710669789218&playMode=R&device=desktop");
        Assert.assertEquals(driver.getCurrentUrl(),properties.getProperty("URL"));
        String windowID=driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id=\"root\"]//div/a[1]")).click();
        driver.switchTo().window(windowID);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        driver.switchTo().frame(0);

    }
    @Test(dependsOnMethods = "game_URL")
    void sound() throws FindFailed {
        Sikuli.click("no");
        Sikuli.click("click");
    }

    @Test(dependsOnMethods = "sound")
    void losing_game() throws FindFailed {
        emu.Smoke_emulation("0");
        Sikuli.click("play");
        Assert.assertTrue(Sikuli.verify("Better_luck_next_time"));
    }

    @Test(dependsOnMethods = "losing_game")
    void Single_win_game() throws FindFailed {
        pause(15);
        emu.Smoke_emulation("2");
        Sikuli.click("play");
    }

    @AfterClass
    void tearDown()
    {
        pause(20);
        //driver.quit();
    }
}
