package utils;

import org.sikuli.basics.Settings;
import org.sikuli.script.*;
import org.testng.Assert;

public class Sikuli {
    static Screen s=new Screen();

   public static void click(String pictureName) throws FindFailed {
       waiting(pictureName);
       s.click(System.getProperty("user.dir")+("\\Images\\"+pictureName+".png"));
   }

   public static boolean verify(String pictureName) throws FindFailed {
       waiting(pictureName);
      // Settings.MinSimilarity=0.99;
       return s.exists(System.getProperty("user.dir") + ("\\Images\\" + pictureName + ".png"))!=null ;
   }

   public void disable_button()
   {
    //   if s.getRobot().
   }

   public static void rtp() throws FindFailed {
       s.rightClick(System.getProperty("user.dir")+("\\Images\\"+"info_scroller_bar"+".png"));
       s.dragDrop(System.getProperty("user.dir")+("\\Images\\info_page_last.png"));
       waiting("game_rtp");
   }

    public static void playAgain(String x) throws FindFailed {
       waiting("play_enable");
       Emulation.force_emulation(x);
       click("play_enable");
       waiting("play_disable");
       click("win_meter_pointer");
    }

   public static boolean image_verfy(String pictureName) throws FindFailed {
       Settings.MinSimilarity=0.99;
       waiting(pictureName);
       Match match=s.find(System.getProperty("user.dir")+("\\Images\\"+pictureName+".png"));
       if(match!=null)
           return true;
       else
           return false;

   }

   public static void screenshot()
   {
       ScreenImage scrImgFile = s.userCapture();
       Pattern pattern = null;
       String path = scrImgFile.getFile("C:\\Users\\vtyagi\\IdeaProjects\\IWG_automation\\Images");
   }

   public static void waiting(String pictureName) {

       try {
           s.wait("C:\\Users\\vtyagi\\IdeaProjects\\IWG_automation\\Images\\"+pictureName+".png",90);
       } catch (FindFailed e) {
           System.out.println(e +" : Image does not found on screen");
       }
   }

}
