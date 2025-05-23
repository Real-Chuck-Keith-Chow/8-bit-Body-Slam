package wrestling.simulator;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Promotion implements Serializable {
    private String name;
    private int prestige; // 0-100
    private int money;
    private boolean isShady;
    private List<Wrestler> roster;
    private Random rand = new Random();

    public Promotion(String name, int prestige, boolean isShady) {
        this.name = name;
        this.prestige = prestige;
        this.isShady = isShady;
        this.roster = new ArrayList<>();
        this.money = prestige * 1000;
    }

    public Contract offerContract(Wrestler wrestler) {
        int basePay = 500 + (prestige * 10);
        if (isShady) {
            basePay *= 1.5;
            if (rand.nextInt(100) > 80) {
                basePay -= 200; // "Accounting error"
            }
        }
        return new Contract(this, basePay, rand.nextInt(12)+1);
    }

    public void bribeReferee(Wrestler wrestler) {
        if (!isShady) return;
        int cost = 2000 + (prestige * 50);
        System.out.println(
            "💰 " + name + " whispers: \"For $" + cost + 
            ", the ref won't see that chair shot...\""
        );
    }

    public String runShadyEvent() {
        if (!isShady) return "Generic wrestling show";
        String[] events = {
            "Cops raid the locker room",
            "Mysterious black vans deliver 'talent'",
            "The ring collapses mid-match",
            "Someone finds a body (not a wrestler)"
        };
        return events[rand.nextInt(events.length)];
    }
}
