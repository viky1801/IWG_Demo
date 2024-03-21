package Pages;

import org.example.Game_screen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Selenium;

import java.io.FileInputStream;
import java.util.Properties;

import static Pages.Game_mainLobby.pause;

public class GameLobby {
   static WebDriver driver;
   public Selenium selenium;
   static Properties propertyfile=new Properties();
    public GameLobby(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        selenium=new Selenium(driver);
        try {
            FileInputStream input= new FileInputStream("IWG.properties");
            propertyfile.load(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FindBy(xpath = "//*[@id=\"root\"]//p")
    public WebElement lobby_title;
    @FindBy(xpath = "//button[text()=\"Launch\"]")
    public WebElement launch;

    public String LobbyTitle()
    {
        return selenium.get_text(lobby_title);
    }

    public void selectGame()
    {
        Select drop=new Select(driver.findElement(By.xpath("//*[@id=\"root\"]//select")));
        drop.selectByVisibleText(propertyfile.getProperty("GameName"));
    }

    public void currency()
    {
        // If need than , we can add it
    }

    public void played_ID()
    {
        Select drop=new Select(driver.findElement(By.xpath("//*[@id=\"root\"]//div[5]//select")));
        drop.selectByVisibleText(propertyfile.getProperty("Player_name"));
    }


    public void click_Launch()
    {
        selectGame();
        played_ID();
        selenium.click(launch);
        pause(3);
    }

}
