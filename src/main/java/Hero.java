import java.awt.Color;
public class Hero {
    private final Color Colour ;
    private final int Id;
    private final String name;
    int[] freq = new int[3];

    Hero(String name,Color colour,int ID){
        this.name = name;
        this.Colour = colour;
        this.Id = ID;
    }

    public String getName() {
        return name;
    }

    public Color getColour() {
        return Colour;
    }

    public int getId() {
        return Id;
    }
}
