package wrss.donotgetlost;

/**
 * Created by ktr on 03.05.2018.
 */

public class Globals {
    private static Globals instance;
    private static String czas_gry;

    private static long mili;

    private static int skips;
    private static String teamName;

    private static int currId;
    private static int currZagadka;

    private Globals() {
    }

    public void setCzas_gry(String s) {
        Globals.czas_gry = s;
    }

    public String getCzas_gry() {
        return Globals.czas_gry;
    }

    public void setMili(long l) {
        Globals.mili = l;
    }

    public long getMili() {
        return Globals.mili;
    }

    public void setSkips(int s) {
        Globals.skips = s;
    }

    public void setSkips() {
        Globals.skips++;
    }

    public int getSkips() {
        return Globals.skips;
    }

    public static synchronized Globals getInstance() {
        if (instance == null) {
            instance = new Globals();
        }
        return instance;
    }

    public void setTeamName(String s) {
        Globals.teamName = s;
    }

    public String getTeamName() {return Globals.teamName;}
    public void setCurrId(int i){Globals.currId = i;}
    public int getCurrId(){return Globals.currId;}
    public void setCurrZagadka(int i){Globals.currZagadka = i;}
    public int getCurrZagadka(){return Globals.currZagadka;}
}
