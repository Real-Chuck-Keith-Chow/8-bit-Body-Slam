package wrestling.simulator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Wrestler implements Serializable {
    private String name;
    private int health;
    private int money;
    private int popularity;
    private int week;
    private Title currentTitle;
    private List<Relationship> relationships = new ArrayList<>();
    private boolean isOnSteroids;

    public Wrestler(String name, int health, int money, int popularity) {
        this.name = name;
        this.health = health;
        this.money = money;
        this.popularity = popularity;
        this.week = 0;
    }

    public void takeSteroid() {
        this.health -= 15;
        this.isOnSteroids = true;
        this.money -= 5000;
    }

    // Getters and Setters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMoney() { return money; }
    public int getPopularity() { return popularity; }
    public int getWeek() { return week; }
    public boolean isOnSteroids() { return isOnSteroids; }
    public Title getCurrentTitle() { return currentTitle; }
    public List<Relationship> getRelationships() { return relationships; }

    public void setHealth(int health) { this.health = health; }
    public void setMoney(int money) { this.money = money; }
    public void setPopularity(int popularity) { this.popularity = popularity; }
    public void setWeek(int week) { this.week = week; }
    public void setOnSteroids(boolean onSteroids) { isOnSteroids = onSteroids; }
    public void setCurrentTitle(Title title) { currentTitle = title; }
    public void addRelationship(Relationship relationship) {
        relationships.add(relationship);
    }
}
