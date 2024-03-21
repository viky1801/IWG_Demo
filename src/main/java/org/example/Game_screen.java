package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.ScreenImage;
import utils.wager;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static Pages.Game_mainLobby.pause;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Game_screen {
    //public WebDriver driver;


    public static void main(String[] args) throws FindFailed {
//        WebDriver driver=new FirefoxDriver();
//        WebDriverManager.firefoxdriver().setup();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//        driver.get("http://iwg:c4shBusterspin!@test-harness.instantwingaming.com/play-game/?platform=atlanticlottery-3&game=alc-multiprice-christmas-carol&currency=USD&language=en&playerId=1710570054815&playMode=R&device=desktop");
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        Screen s=new Screen();
       // driver.findElement(By.xpath("//*[@id=\"root\"]//div/a[1]")).click();
//        Set<String> window= driver.getWindowHandles();
//        String[] windowID=window.toArray(new String[window.size()]);
//        pause(30);
//        driver.switchTo().window(windowID[1]);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,1000)");
//        String prize="1";
//        pause(5);
//        driver.findElement(By.xpath("//*[@id=\"scenarios\"]/tr/td[4][text()=\"2\"]/..//span")).click();
//        pause(2);
//        //ArrayList<String> windowID=new ArrayList<String>();
//
//        driver.switchTo().window(windowID[0]);
//        JavascriptExecutor Js = (JavascriptExecutor) driver;
//        Js.executeScript("window.scrollBy(0,1000)");
//        pause(5);
       // driver.quit();
//        4344091e-53e0-4325-a8bf-c91525feeac6
//        47543fde-302d-48b0-b403-6d447502be7b

//
//        driver.switchTo().frame(0);
//        s.click(System.getProperty("user.dir")+("\\Images\\"+"no"+".png"));
//        s.wait("C:\\Users\\vtyagi\\IdeaProjects\\IWG_automation\\Images\\click.png",50);
//        s.click(System.getProperty("user.dir")+("\\Images\\click.png"));

       // s.wait(System.getProperty("user.dir")+("\\Images\\click.png"));

        //s.click(System.getProperty("user.dir")+("\\Images\\click.png"));
       // pause(5);
//        pause(20);
//        s.click(System.getProperty("user.dir")+("\\Images\\paytable_button.png"));
//        pause(8);
//        s.click(System.getProperty("user.dir")+("\\Images\\forward_paytable.png"));
//        pause(4);
//        s.click(System.getProperty("user.dir")+("\\Images\\backward_paytable.png"));
//        pause(4);
//        s.click(System.getProperty("user.dir")+("\\Images\\cancel_paytable.png"));
//        pause(2);
//        if(s.exists(System.getProperty("user.dir")+("\\Images\\play.png"))!=null)
//            System.out.println("Image found");
//        else
//            System.out.println("Image not found");
//
        wager w=new wager();
        w.change_wager(3);
        System.out.println("--------------");
        w.change_wager(1);

    }

 //   s.wait("C:\\Users\\vtyagi\\IdeaProjects\\IWG_automation\\Images\\"+pictureName+".png",70);







}