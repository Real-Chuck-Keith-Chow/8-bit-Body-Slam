package wrestling.simulator;
import java.io.Serializable;

public class Title implements Serializable {
    private String name;
    private Wrestler champion;
    private int prestige;

    public Title(String name, int prestige) {
        this.name = name;
        this.prestige = prestige;
    }

    public String getName() { return name; }
    public Wrestler getChampion() { return champion; }
    public int getPrestige() { return prestige; }
    public void setChampion(Wrestler champion) { this.champion = champion; }
}
