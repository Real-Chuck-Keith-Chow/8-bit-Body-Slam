import java.util.Random;

public class Match {
	
	public static void fight(Wrestler player, Wrestler opponent) {
        Random rand = new Random();
        int playerScore = player.getHealth() + player.getPopularity();
        int opponentScore = opponent.getHealth() + rand.nextInt(50);

        if (playerScore > opponentScore) {
            System.out.println(player.getName() + " wins!");
            player.setMoney(player.getMoney() + 1000);
        } else {
            System.out.println(opponent.getName() + " wins!");
            player.setHealth(player.getHealth() - 20);
        }
    }

}


