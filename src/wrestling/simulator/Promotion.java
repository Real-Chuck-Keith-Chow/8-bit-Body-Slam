package wrestling.simulator;


import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
public class Promotion implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int prestige; // 0-100
    private List<Title> titles = new ArrayList<>();
    private int money;

    public Promotion(String name, int prestige, int startingMoney) {
        this.name = name;
        this.prestige = prestige;
        this.money = startingMoney;
    }

    // Offer a contract to a wrestler
    public Contract offerContract(Wrestler wrestler) {
        int basePay = 1000 + (prestige * 10);
        int duration = 12; // Months
        return new Contract(this, basePay, duration);
    }

    // Add a title to the promotion
    public void addTitle(Title title) {
        titles.add(title);
        title.setPrestige(title.getPrestige() + (prestige / 10)); // Boost title prestige
    }

    // Getters
    public String getName() { return name; }
    public List<Title> getTitles() { return titles; }
    public int getPrestige() { return prestige; }
}
