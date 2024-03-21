package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.util.Properties;

import static Pages.Game_mainLobby.pause;

public class Platform {
   static WebDriver driver=null;
   Properties propertFile=new Properties();

   public Platform(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

   @FindBy(xpath = "//*[@id=\"root\"]//p")
   public WebElement header;

    public void launch()
    {
        try {
            FileInputStream input= new FileInputStream("IWG.properties");
            propertFile.load(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        driver.get(propertFile.getProperty("url"));
    }

    public String text()
    {
       return header.getText();
    }

    public void SelectGame()
    {
       pause(3);
       driver.get(propertFile.getProperty("GAME_URL"));
    }
}
