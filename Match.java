package wrestling.simulator;
import java.util.Random;

public class Match {
    public static void startMatch(Wrestler player, Wrestler opponent) {
        System.out.println("\n=== MATCH START ===");
        int playerScore = player.getHealth() + player.getPopularity();
        int opponentScore = opponent.getHealth() + (new Random().nextInt(50));
        
        if (playerScore > opponentScore) {
            System.out.println(player.getName() + " wins the match!");
            player.setMoney(player.getMoney() + 1000);
            player.setPopularity(player.getPopularity() + 10);
        } else {
            System.out.println(opponent.getName() + " wins the match!");
            player.setHealth(player.getHealth() - 15);
        }
    }
}

