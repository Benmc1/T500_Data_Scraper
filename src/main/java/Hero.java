import java.awt.Color;
import java.util.Arrays;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hero hero = (Hero) o;

        return Id == hero.Id;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", freq=" + Arrays.toString(freq) +
                '}';
    }
}
