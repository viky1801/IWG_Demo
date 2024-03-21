package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Selenium {
   public WebDriver driver;
   public Selenium(WebDriver driver)
   {
       this.driver=driver;
       PageFactory.initElements(driver, this);
   }

   public void click(WebElement e)
   {
       e.click();
   }

   public String get_text(WebElement e)
   {
       return e.getText();
   }

   public String get_url()
   {
       return driver.getCurrentUrl();
   }

}
