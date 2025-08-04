package wrestling.simulator;

import java.io.Serializable;

public class Title {
	
	private String name;
    private Wrestler champion;
    private int prestige;  // 0-100 rating
    private boolean isMainTitle;

    public Title(String name, int prestige, boolean isMainTitle) {
        this.name = name;
        this.prestige = Math.min(100, Math.max(0, prestige));  // Clamped 0-100
        this.isMainTitle = isMainTitle;

}
    
    public boolean defendTitle(Wrestler challenger, Wrestler champion) {
        if (this.champion == null || !this.champion.equals(champion)) {
            return false;  // Not the real champion
        }
        
        int championScore = champion.getHealth() + champion.getPopularity() + (prestige / 2);
        int challengerScore = challenger.getHealth() + challenger.getPopularity() + (new java.util.Random().nextInt(30));

        if (challengerScore > championScore) {
            // Title change!
            this.champion = challenger;
            champion.setPopularity(champion.getPopularity() - 10);
            challenger.setPopularity(challenger.getPopularity() + 20);
            return true;
        }
        return false;
    }

    // Getters
    public String getName() { return name; }
    public Wrestler getChampion() { return champion; }
    public int getPrestige() { return prestige; }
    public boolean isMainTitle() { return isMainTitle; }

    // Setters with validation
    public void setPrestige(int prestige) {
        this.prestige = Math.min(100, Math.max(0, prestige));
    }

    @Override
    public String toString() {
        return name + " Title" + (champion != null ? " (Holder: " + champion.getName() + ")" : " (Vacant)");
    }
}

