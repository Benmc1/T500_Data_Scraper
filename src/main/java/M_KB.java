import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

public class M_KB {
    static public Boolean run = true;
    public void keyboardListen(int k) {
        GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);

        System.out.println("Global keyboard hook successfully started, press [escape] key to shutdown. Connected keyboards:");

        keyboardHook.addKeyListener(new GlobalKeyAdapter() {

            @Override
            public void keyPressed(GlobalKeyEvent event) {
                System.out.println(event);
                if (event.getVirtualKeyCode() == k) {
                    run = false;
                }
            }
        });

        try {
            while (run) {
                Thread.sleep(128);
            }
        } catch (InterruptedException e) {
            //Do nothing
        } finally {
            keyboardHook.shutdownHook();
        }
        System.out.println("escaped");
    }
    public void leftClick() {
        try {
            Robot dog = new Robot();
            dog.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            dog.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(200);
        } catch (Exception e ){
            System.out.println("Left click failed");
        }
    }

    public void moveToSeason(int s){
        int xSeason = 976,ySeason = 284 ,sOffset=36 ;
        try {
            Robot dog = new Robot();
            dog.mouseMove(xSeason, ySeason);
            leftClick();
            dog.mouseMove(xSeason, ySeason + (sOffset * s));
            leftClick();
        } catch (Exception e){
            System.out.println("Moving to season didn't work");
        }
    }
    public void moveToRegion(int region){
        int xRegion =1212 ,yRegion =284,rOffset = 36 ;

        try {
            Robot dog = new Robot();
            dog.mouseMove(xRegion, yRegion);

            leftClick();
            dog.mouseMove(xRegion, yRegion + (rOffset * region));
            leftClick();
        } catch (Exception e){
            System.out.println("Moving to region didn't work");
        }
    }

    public void selectRole(Role.Roles role){
        int x =780 ,y =284,yOffset = 36 ;

        try{
            Robot dog = new Robot();
            dog.mouseMove(x, y);
            leftClick();
            int n = 0;
            switch (role){
                case Tank -> n =2;
                case DAMAGE -> n = 3;
                case SUPPORT ->  n =4;
            }
            dog.mouseMove(x, y + (yOffset * n));
            leftClick();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Color getColour(int i , int j){
        Color c;
        try{
            Robot dog = new Robot();
            int x = 1331, y =329;
            int xOffset = 52 , yOffset = 55;

            c = dog.getPixelColor(x + (xOffset*i), y + (yOffset *j));
        }catch (Exception e) {
            System.out.println("Couldn't get Colour");
            c = new Color(0);
        }
        return c;
    }
    public BufferedImage getPageNum(){

        try{
            Robot dog = new Robot();
            Rectangle pageNumBox = new Rectangle(930,869,36,24);
            return dog.createScreenCapture(pageNumBox);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void highlightNextBtn(){
        try{
            Robot dog = new Robot();
            dog.mouseMove(1030,880);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
