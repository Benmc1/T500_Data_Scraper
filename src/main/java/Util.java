import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Util {
    static private final String[] Regions={"NA","EU","ASIA"};

    static public void SaveScreen(BufferedImage screenCap) {

        int count = 0;
        try {
            File outputFile = new File("screenshot"+count+".png"); // Change the file format if needed
            ImageIO.write(screenCap, "png", outputFile);
            System.out.println("Screenshot saved as " + outputFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public ArrayList<Hero> addArrays(ArrayList<Hero> primary , Hero[] secondary){
        for(Hero h : secondary){
            if(!primary.contains(h))primary.add(h);
            else{
                int n = primary.indexOf(h);
                primary.get(n).addFreq(h);
            }
        }
        return primary;
    }

    static public String stringOutput(int season, int region, Role.Roles role, Hero[] h){
        StringBuilder s = new StringBuilder();
        s.append("Region: "+ Regions[region] + "  ");
        s.append("SEASON: "+season + "  ");
        s.append(role + "  ");
        for(Hero hero: h)s.append(hero.toString());
        return s.toString();
    }

    static public void saveToFile(int season , int region,Role.Roles role, Hero[] heroes){
        String filePath = "output.txt";
        try {
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            if (file.exists()) bufferedWriter.newLine();

            bufferedWriter.write(stringOutput(season,region,role,heroes));
            bufferedWriter.close();

            System.out.println("Data appended to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
