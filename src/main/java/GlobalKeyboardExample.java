
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

    public class T500DataScraper {
    static public Boolean run = true;
    static final String[] HERONAMES = {"Ashe", "Bastion", "Cassidy", "Echo", "Genji", "Hanzo", "Junkrat", "Mei", "Pharah", "Reaper", "Sojourn", "Soldier",
            "Sombra", "Symmetra", "Torbjorn", "Tracer", "Widowmaker", "D.Va", "Doomfist", "JunkerQueen", "Orisa", "Ramattra", "Reinhart", "Roadhog", "Sigma", "Winston",
            "Hammond", "Zarya", "Ana", "Baptiste", "Brigette", "Illari", "Kiriko", "Lifeweaver", "Lucio", "Mercy", "Moira", "Zenyatta"};
    static final String[] Regions = {"Na","EU","ASIA"};
    static final int NUMOFHEROS = 38;
    public static void main(String[] args) throws AWTException, InterruptedException {
        keyboardListen();
        System.out.println("escaped");
        Robot dog = new Robot();
        int xRegion =1212 ,yRegion =284,rOffset = 36 ;
        int xseason = 976,yseason = 284 ,sOffset=36 ;

        for (int i = 3; i < 4; i++) {
            dog.mouseMove(xRegion,yRegion);
            leftClick();
            dog.mouseMove(xRegion,yRegion +(rOffset * i));
            leftClick();

            for (int j = 1; j < 6; j++) {
                dog.mouseMove(xseason,yseason);
                leftClick();
                dog.mouseMove(xseason,yseason+ (sOffset * j));
                leftClick();
                dog.mouseMove(1015,880);
                takeInfo(7-j,0);
            }

        }
    }
    static public void takeInfo(int season,int region) throws AWTException, InterruptedException {
        int[][] heroCount = new int[NUMOFHEROS][3];

        int i = 0;
        int[][] prev = new int[NUMOFHEROS][3];
        while (i < 50) {
            Thread.sleep(700);
            int[][] temp = countHeroes();
            leftClick();
            if(!Arrays.deepEquals(temp, prev)) heroCount = addArrays(temp, heroCount);
            i++;
            prev = temp;
        }
        System.out.println(printOutput(season ,region,heroCount));
        savetoFile(season,region,heroCount);
    }
    static public void keyboardListen() {
        GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook(true);

        System.out.println("Global keyboard hook successfully started, press [escape] key to shutdown. Connected keyboards:");

        keyboardHook.addKeyListener(new GlobalKeyAdapter() {

            @Override
            public void keyPressed(GlobalKeyEvent event) {
                System.out.println(event);
                if (event.getVirtualKeyCode() == GlobalKeyEvent.VK_F3) {
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

    }

    static public int[][] countHeroes() throws AWTException {
        Robot dog = new Robot();
        Map<Color,Integer> colourMap = new HashMap<>();

        colourMap.put(new Color(69,72,79),28);//ana
        colourMap.put(new Color(113,90,90),29);//bap
        colourMap.put(new Color(249,190,180),30);//Brig
        colourMap.put(new Color(142,110,85),31);//Illari
        colourMap.put(new Color(233,176,152),32);//kiri
        colourMap.put(new Color(180,127,92),33);//LW
        colourMap.put(new Color(124,130,59),34);
        colourMap.put(new Color(95,102,81),35);//mercy
        colourMap.put(new Color(124,219,254),36);//moira
        colourMap.put(new Color(81,79,86),37);//zen



        int[][] heroCount = new int[NUMOFHEROS][3];
        int x = 1331, y =329;
        int xOffset = 52 , yOffset = 55;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                Color pixel = dog.getPixelColor(x + (xOffset*j),y + (yOffset *i));

//                if(!colourMap.containsKey(pixel)) {
//                    System.out.println((x + (xOffset * j)) + "  " + (y + (yOffset * i)));
//                    System.out.println(pixel);
//                }
                if(colourMap.containsKey(pixel)) {
                    heroCount[colourMap.get(pixel)][j]++;
                }
            }
        }
        return heroCount;
    }

    static public void SaveScreen(BufferedImage screenCap) throws AWTException {
        Robot dog = new Robot();
        int count = 0;
        try {
            File outputFile = new File("screenshot"+count+".png"); // Change the file format if needed
            ImageIO.write(screenCap, "png", outputFile);
            System.out.println("Screenshot saved as " + outputFile.getAbsolutePath());
            count++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public int[][] addArrays(int[][] primary , int[][]secondary){
        for (int i = 0; i < NUMOFHEROS; i++) {
            primary[i][0] += secondary[i][0];
            primary[i][1] += secondary[i][1];
            primary[i][2] += secondary[i][2];
        }
        return primary;
    }
    static public String printOutput(int seacon,int region,int[][] count){
        StringBuilder out = new StringBuilder();
        out.append("Region: "+ Regions[region] + "  ");
        out.append("SEASON: "+seacon + "  ");
        for (int i = 0; i < NUMOFHEROS; i++) {
            out.append(HERONAMES[i] +":  "+ Arrays.toString(count[i]) +"  ");
        }
        return out.toString();
    }
    static public void savetoFile(int s , int r,int[][] count){
        String filePath = "output.txt";
        try {
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            if (file.exists()) bufferedWriter.newLine();

            bufferedWriter.write(printOutput(s,r,count));
            bufferedWriter.close();

            System.out.println("Data appended to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public void leftClick() throws AWTException, InterruptedException {
        Robot dog = new Robot();
        dog.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        dog.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(200);
    }
}
