import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

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
    static public int[][] addArrays(int[][] primary , int[][]secondary){
        for (int i = 0; i < primary.length; i++) {
            primary[i][0] += secondary[i][0];
            primary[i][1] += secondary[i][1];
            primary[i][2] += secondary[i][2];
        }
        return primary;
    }

    static public String stringOutput(int season,int region,int[][] count){
        StringBuilder s = new StringBuilder();
        s.append("Region: "+ Regions[region] + "  ");
        s.append("SEASON: "+season + "  ");
        for (int i = 0; i < count.length; i++) {
            s.append(Role.HERONAMES[i] +":  "+ Arrays.toString(count[i]) +"  ");
        }
        System.out.println(s);
    }

    static public void savetoFile(int s , int r,int[][] count){
        String filePath = "output.txt";
        try {
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            if (file.exists()) bufferedWriter.newLine();

            bufferedWriter.write(stringOutput(s,r,count));
            bufferedWriter.close();

            System.out.println("Data appended to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static public Color getPixelColor(int x, int y){

    }
}
