package wrestling.simulator;
import java.io.Serializable;

public class Relationship implements Serializable {
    private Wrestler otherWrestler;
    private int heatLevel;
    private boolean isRomantic;

    public Relationship(Wrestler otherWrestler, int heatLevel, boolean isRomantic) {
        this.otherWrestler = otherWrestler;
        this.heatLevel = heatLevel;
        this.isRomantic = isRomantic;
    }

    public Wrestler getOtherWrestler() { return otherWrestler; }
    public int getHeatLevel() { return heatLevel; }
    public boolean isRomantic() { return isRomantic; }
}
