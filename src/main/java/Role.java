import java.awt.*;


public class Role {
    public enum Roles{
        DAMAGE,
        Tank,
        SUPPORT,
    }

    public Hero[] getHeroes(Roles r){
        return switch (r) {
            case DAMAGE -> getDamage();
            case SUPPORT -> getSupports();
            case Tank -> getTanks();
        };
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
        Hero[] heroes = new Hero[17];
        heroes[0] = new Hero("Ashe",        new Color(169,151,139),   0);
        heroes[1] = new Hero("Bastion",     new Color(246,254,254),   1);
        heroes[2] = new Hero("Cassidy",     new Color(140,111,100),   2);
        heroes[3] = new Hero("Echo",        new Color(130,185,226),  3);
        heroes[4] = new Hero("Genji",       new Color(178,193,186),   4);
        heroes[5] = new Hero("Hanzo",       new Color(233,194,150),   5);
        heroes[6] = new Hero("Junkrat",     new Color(179,119,47),   6);
        heroes[7] = new Hero("Mei",         new Color(114,67,59),   7);
        heroes[8] = new Hero("Phara",       new Color(143,96,60),   8);
        heroes[9] = new Hero("Reaper",      new Color(237,241,243),   9);
        heroes[10] = new Hero("Sojourn",    new Color(0,0,0),   10);
        heroes[11] = new Hero("Soldier",    new Color(142,147,154),   11);
        heroes[12] = new Hero("Sombra",     new Color(178,126,109),   12);
        heroes[13] = new Hero("Symetra",    new Color(40,27,25),   13);
        heroes[14] = new Hero("Torbjorn",   new Color(238,182,131),   14);
        heroes[15] = new Hero("Tracer",     new Color(239,90,11),   15);
        heroes[16] = new Hero("WidowMaker", new Color(202,199,231),   16);


        return heroes;
    }
    private Hero[] getTanks(){
        Hero[] heroes = new Hero[11];
        heroes[0] = new Hero("D.Va",       new Color(22,17,17),   17);
        heroes[1] = new Hero("Doomfist",   new Color(106,89,90),  18);
        heroes[2] = new Hero("JunkerQ",    new Color(139,108,97),19);
        heroes[3] = new Hero("Orisa",      new Color(188,121,0), 20);
        heroes[4] = new Hero("Ramattra",   new Color(64,55,52),21);
        heroes[5] = new Hero("Reinhart",   new Color(152,99,89), 22);
        heroes[6] = new Hero("Roadhog",    new Color(97,109,110), 23);
        heroes[7] = new Hero("Sigma",      new Color(242,199,190),  24);
        heroes[8] = new Hero("Winston",    new Color(71,79,95),25);
        heroes[9] = new Hero("Hammond",    new Color(234,213,185),   26);
        heroes[10] = new Hero("Zarya",      new Color(241,204,188),   27);
        return heroes;
    }

}
