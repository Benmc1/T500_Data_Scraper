import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import lc.kra.system.keyboard.event.GlobalKeyEvent;
public class OWDataScraper {
    private  ArrayList<Hero> heroesFreq = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        M_KB controller = new M_KB();
        controller.keyboardListen(GlobalKeyEvent.VK_F3);
        OWDataScraper scraper = new OWDataScraper();
//        for (int region = 1; region < 5; region++) {
//            for (int season = 1; season < 6; season++) {
//                controller.selectRole(Role.Roles.SUPPORT);
//                scraper.scrape(season,region,Role.Roles.SUPPORT);
//                scraper.collect(season,region);
//            }
//        }
        scraper.collect(1,1);
    }
    public void collect(int season,int region) throws InterruptedException {
        M_KB controller = new M_KB();
        controller.moveToRegion(region);
        controller.moveToSeason(season);
        ArrayList<Hero> heroes = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                Color colour = controller.getColour(i, j);
                Hero temp = new Hero("??",colour,i+j);
                if (!heroes.contains(temp)) {
                    heroes.add(temp);
                    System.out.println(i+"  "+j + "\n"+colour);
                }
            }
        }
    }
    public void scrape (int season,int region,Role.Roles r) throws InterruptedException {
        M_KB controller = new M_KB();
        controller.moveToRegion(region);
        controller.moveToSeason(season);
        Hero[] heroes = new Role().getHeroes(r);
        int page = 0;
        Hero[] prev = new Role().getHeroes(r);

        while (page < 50) {
            Thread.sleep(700);
            Hero[] temp = countHeroes(heroes);
            if(!Arrays.deepEquals(temp, prev)) heroesFreq = Util.addArrays(heroesFreq,temp);
            page++;
            prev = temp;
        }
        Util.stringOutput(season ,region,heroesFreq);
        Util.savetoFile(season,region,heroesFreq);
    }


    static public Hero[] countHeroes(Hero[] heroes)  {
        M_KB cont = new M_KB();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                Color colour = cont.getColour(i,j);

//                if(!colourMap.containsKey(pixel)) {
//                    System.out.println((x + (xOffset * j)) + "  " + (y + (yOffset * i)));
//                    System.out.println(pixel);
//                }
               heroes[0].freq[j]++;

            }
        }
        return heroes;
    }

}
