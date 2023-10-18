import java.awt.*;


public class Role {
    public enum Roles{
        DAMAGE,
        Tank,
        SUPPORT,
        All
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
        Hero[] heroes = new Hero[10];
        heroes[0] = new Hero("D.Va",       new Color(97,109,110),   17);
        heroes[1] = new Hero("Doomfist",   new Color(113,90,90),  18);
        heroes[2] = new Hero("JunkerQ",    new Color(139,108,97),19);
        heroes[3] = new Hero("Orisa",      new Color(138,153,178), 20);
        heroes[4] = new Hero("Ramattra",   new Color(233,176,152),21);
        heroes[5] = new Hero("Reinhart",   new Color(180,127,92), 22);
        heroes[6] = new Hero("Roadhog",    new Color(124,130,59), 23);
        heroes[7] = new Hero("Sigma",      new Color(241,204,188),  24);
        heroes[8] = new Hero("Winston",    new Color(22,17,17),25);
        heroes[9] = new Hero("Hammond",    new Color(169,175,195),   26);
        heroes[9] = new Hero("Zarya",      new Color(241,204,188),   27);
        return heroes;
    }

}
