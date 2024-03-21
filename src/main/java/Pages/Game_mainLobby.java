package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import utils.Selenium;
import utils.Sikuli;

import java.util.ArrayList;
import java.util.Set;

public class Game_mainLobby {
   public WebDriver driver;
   public Selenium selenium;

   @FindBy(xpath = "//button[text()=\"Settle purchased tickets\"]")
    public WebElement newticket;

   @FindBy(xpath = "//*[@id=\"root\"]//div/a[1]")
   public WebElement emulation;

    public Game_mainLobby(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        selenium=new Selenium(driver);
    }

    public String player_name()
    {
        return driver.getCurrentUrl();
    }

    public void gameSound(String voice) throws FindFailed {
        // This will be use to start a new ticket, if there is any pending game then it will abort it
        selenium.click(newticket);
        pause(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        driver.switchTo().frame(0);
        pause(5);
        Sikuli.click(voice);
    }


    public void emulationWindow()
    {
        Set<String> window= driver.getWindowHandles();
        String[] windowID=window.toArray(new String[window.size()]);
        driver.switchTo().window(windowID[1]);
        pause(2);
        selenium.click(emulation);
        pause(2);
        driver.switchTo().window(windowID[1]);

    }


    public static void pause(int t)
    {
        try {
            Thread.sleep(t*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
