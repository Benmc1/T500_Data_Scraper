import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Optional;


import lc.kra.system.keyboard.event.GlobalKeyEvent;
public class OWDataScraper {

    public static void main(String[] args) throws InterruptedException {

        M_KB controller = new M_KB();
        controller.keyboardListen(GlobalKeyEvent.VK_F3);
        OWDataScraper scraper = new OWDataScraper();
        for (int region = 3; region < 4; region++) {
            for (int season = 1; season < 6; season++) {
                for (Role.Roles role : Role.Roles.values()) {
                    scraper.scrape(season,region,role);
                }
            }
        }
    }

    public void scrape (int season,int region,Role.Roles role) throws InterruptedException {
        M_KB controller = new M_KB();
        controller.moveToRegion(region);
        controller.moveToSeason(season);
        controller.selectRole(role);
        controller.highlightNextBtn();

        Hero[] heroes = new Role().getHeroes(role);
        //there might not be 50 pages this stops the last page from being added repeatedly
        BufferedImage prev = null;
        BufferedImage curr = controller.getPageNum();
        int page = 0;
        while (page < 50 && prev != curr) {
            Thread.sleep(600);
            countHeroes(heroes);
            controller.leftClick();
            prev = curr;
            curr = controller.getPageNum();
            page++;
        }
        System.out.println(Util.stringOutput(season ,region,role,heroes));
        Util.saveToFile(season ,region,role,heroes);
    }


    static public void countHeroes(Hero[] heroes) {
        M_KB cont = new M_KB();


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 3; j++) {
                Color colour = cont.getColour(j,i);

                Optional<Hero> target = Arrays.stream(heroes).sequential().filter(hero -> hero.getColour().equals(colour)).findFirst();
                if(target.isEmpty()) {
                    //if you want to see what its finding that isn't in the array
//                    System.out.println( i + "  " +  j);
//                    System.out.println(colour.getRed()+","+colour.getGreen()+","+colour.getBlue());
                }else{
                    target.get().freq[j]++;
                }
            }
        }
    }

}
