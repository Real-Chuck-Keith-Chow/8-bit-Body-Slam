package wrestling.simulator;

import java.util.Scanner;
import java.util.Random;

public class WrestlingCareer {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        Wrestler player = createWrestler();
        
        while(player.getHealth() > 0) {
            System.out.println("\n=== WEEK " + player.getWeek() + " ===");
            System.out.println("$" + player.getMoney() + " | ❤️ " + player.getHealth());

            // Monthly choices
            System.out.println("1. Wrestle Match\n2. Backstage Politics\n3. Buy Steroids\n4. Seduce Rival");
            int choice = scanner.nextInt();
            
            handleChoice(choice, player);
            advanceWeek(player);
        }
        System.out.println("CAREER OVER: You died of CTE");
    }

    private static Wrestler createWrestler() {
        return new Wrestler("The Java Destroyer", 100, 5000, 0, false);
    }

    private static void handleChoice(int choice, Wrestler player) {
        switch(choice) {
            case 1 -> wrestleMatch(player);
            case 2 -> backstagePolitics(player);
            case 3 -> buySteroids(player);
            case 4 -> seduceRival(player);
            default -> System.out.println("Invalid choice!");
        }
    }

    private static void wrestleMatch(Wrestler player) {
        System.out.println("You wrestled a match! +$500");
        player.setMoney(player.getMoney() + 500);
        player.setHealth(player.getHealth() - 10);
    }

    private static void buySteroids(Wrestler player) {
        player.setHealth(player.getHealth() - 15);
        player.setOnSteroids(true);
        player.setMoney(player.getMoney() - 5000);
        System.out.println("💉 You bought steroids (-15 health, -$5000)");
    }

    private static void advanceWeek(Wrestler player) {
        player.setWeek(player.getWeek() + 1);
    }
}
