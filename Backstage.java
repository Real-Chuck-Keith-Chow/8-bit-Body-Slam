package wrestling.simulator;

public class Backstage {
	 public static void bribeReferee(Wrestler player, int amount) {
	        if (player.getMoney() >= amount) {
	            System.out.println("Referee nods subtly... (-$" + amount + ")");
	        }
	    }

}
