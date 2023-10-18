import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lc.kra.system.keyboard.event.GlobalKeyEvent;
public class OWDataScraper {
    private  ArrayList<Hero> heroesFreq;

    public static void main(String[] args) throws InterruptedException {

        M_KB controller = new M_KB();
        controller.keyboardListen(GlobalKeyEvent.VK_F3);
        OWDataScraper scraper = new OWDataScraper();
//        for (int region = 1; region < 5; region++) {
//            for (int season = 1; season < 6; season++) {
//                controller.selectRole(Role.Roles.SUPPORT);
//                scraper.scrape(season,region,Role.Roles.SUPPORT);
//            }
//        }
        scraper.collect();
    }
    public void collect() {
        heroesFreq.addAll(List.of(new Role().getHeroes(Role.Roles.All)));
        System.out.println(heroesFreq.size());
        M_KB controller = new M_KB();

        Hero[] heroes = new Role().getHeroes(Role.Roles.Tank);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                Color colour = controller.getColour(i, j);
                Hero temp = new Hero("??",colour,i+j);
//                if (!heroes.contains(temp)) {
//                    heroes.add(temp);
//                    System.out.println(i+"  "+j + "\n"+colour);
//                }
            }
        }
    }
    public void scrape (int season,int region,Role.Roles role) throws InterruptedException {
        M_KB controller = new M_KB();
        controller.moveToRegion(region);
        controller.moveToSeason(season);
        Hero[] heroes = new Role().getHeroes(role);
        int page = 0;
        //there might not be 50 pages this stops the last page from being added repeatedly
        BufferedImage prev = null;
        BufferedImage curr = controller.getPageNum();
        while (page < 50 && prev != curr) {
            Thread.sleep(700);
            countHeroes(heroes);
            prev = curr;
            curr = controller.getPageNum();
            page++;

        }
        Util.stringOutput(season ,region,role,heroes);
        Util.saveToFile(season ,region,role,heroes);
    }


    static public Hero[] countHeroes(Hero[] heroes)  {
        M_KB cont = new M_KB();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                Color colour = cont.getColour(i,j);

                Hero target = Arrays.stream(heroes).sequential().filter(hero -> hero.getColour() == colour).findFirst().orElse(null);
                if(target == null) {
                    System.out.println( j + "  " +  i);
                    System.out.println(colour);
                }else{
                    target.freq[j]++;
                }
            }
        }
        return heroes;
    }

}
