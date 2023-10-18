import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



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

    static public String stringOutput(int season, int region, Role.Roles role, Hero[] h){
        StringBuilder s = new StringBuilder();
        s.append("Region: ").append(Regions[region - 1]).append("  ");
        s.append("SEASON: ").append(season).append("  ");
        s.append(role).append("  ");
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
