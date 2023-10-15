import java.awt.*;

public class Role {
    public enum Roles{
        DAMAGE,
        Tank,
        SUPPORT
    }

    public static final int NUMOFHEROS = 38;
    static final String[] HERONAMES = {"Ashe", "Bastion", "Cassidy", "Echo", "Genji", "Hanzo", "Junkrat", "Mei", "Pharah", "Reaper", "Sojourn", "Soldier",
            "Sombra", "Symmetra", "Torbjorn", "Tracer", "Widowmaker", "D.Va", "Doomfist", "JunkerQueen", "Orisa", "Ramattra", "Reinhart", "Roadhog", "Sigma", "Winston",
            "Hammond", "Zarya", "Ana", "Baptiste", "Brigette", "Illari", "Kiriko", "Lifeweaver", "Lucio", "Mercy", "Moira", "Zenyatta"};
    static final String[] Regions = {"Na","EU","ASIA"};

    public Hero[] getHeroes(Roles r){
        switch (r){
            case DAMAGE: return getDamage();
            case SUPPORT: return getSupports();
            case Tank: return getTanks();
            default: return new Hero[0];
        }
    }
    static private Hero[] getSupports(){
       Hero[] heroes = new Hero[10];
       heroes[0] = new Hero("Ana",       new Color(69,72,79),   28);
       heroes[1] = new Hero("Baptiste",  new Color(113,90,90),  29);
       heroes[2] = new Hero("Brigette",  new Color(249,190,180),30);
       heroes[3] = new Hero("Illari",    new Color(142,110,85), 31);
       heroes[4] = new Hero("Kiriko",    new Color(233,176,152),32);
       heroes[5] = new Hero("Lifeweaver",new Color(180,127,92), 33);
       heroes[6] = new Hero("Lucio",     new Color(124,130,59), 34);
       heroes[7] = new Hero("Mercy",     new Color(95,102,81),  35);
       heroes[8] = new Hero("Moira",     new Color(124,219,254),36);
       heroes[9] = new Hero("Zenyatta",  new Color(81,79,86),   37);
       return heroes;
    }

    private Hero[] getDamage(){
     return new Hero[0];
    }
    private Hero[] getTanks(){
        return new Hero[0];
    }

}
