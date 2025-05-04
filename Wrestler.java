package wrestling.simulator;

//Wrestler.java
public class Wrestler {
 private String name;
 private int health;          // 0-100 (steroids damage this)
 private int money;           // $$$
 private int popularity;      // Fan love
 private Title currentTitle;  // Null if no title
 private List<Relationship> relationships;
 private boolean isOnSteroids;
 
 public void takeSteroid() {
     this.health -= 15;
     this.isOnSteroids = true;
     this.money -= 5000; // Dealer ain't free
 }
 
 public Wrestler(String name, int health, int money, int popularity) {
     this.name = name;
     this.health = health;
     this.money = money;
     this.popularity = popularity;
 }
 
 public String getName() { return name; }
 public int getHealth() { return health; }
 public int getMoney() { return money; }
 public boolean isOnSteroids() { return isOnSteroids; }
 
 
}

