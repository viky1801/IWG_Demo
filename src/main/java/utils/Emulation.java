package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;

import java.util.Set;

import static Pages.Game_mainLobby.pause;
import static utils.Sikuli.*;


public class Emulation {
   static public WebDriver driver;
    public  Emulation(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public static void force_emulation(String prize) throws FindFailed
    {
        waiting("play");
        Set<String> window= driver.getWindowHandles();
        String[] windowID=window.toArray(new String[window.size()]);
        driver.switchTo().window(windowID[2]);
        pause(5);
        driver.findElement(By.xpath("//*[@id=\"scenarios\"]/tr/td[4][text()="+prize+"]/..//a")).click();
        pause(5);
        driver.switchTo().window(windowID[1]);
    }

    public void Smoke_emulation(String prize)
    {
        Set<String> window= driver.getWindowHandles();
        String[] windowID=window.toArray(new String[window.size()]);
        driver.switchTo().window(windowID[1]);
        pause(5);
        driver.findElement(By.xpath("//*[@id=\"scenarios\"]/tr/td[4][text()="+prize+"]/..//a")).click();
        pause(5);
        driver.switchTo().window(windowID[0]);
    }
}
