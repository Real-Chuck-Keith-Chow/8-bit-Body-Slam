package wrestling.simulator;

// Backstage.java
class Backstage {
    public static void bribeReferee(Wrestler player, int amount) {
        if (player.getMoney() >= amount) {
            player.setMoney(player.getMoney() - amount);
            System.out.println("Referee nods subtly... (-$" + amount + ")");
        } else {
            System.out.println("Not enough money to bribe!");
        }
    }
}
