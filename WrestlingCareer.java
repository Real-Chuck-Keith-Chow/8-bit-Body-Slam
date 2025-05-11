package wrestling.simulator;
import java.util.Scanner;
import java.util.Random;
import java.io.IOException;

public class WrestlingCareer {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        Wrestler player = createWrestler();
        
        while(player.getHealth() > 0) {
            System.out.println("\n=== WEEK " + player.getWeek() + " ===");
            System.out.println("$" + player.getMoney() + " | ❤️ " + player.getHealth() + " | ★ " + player.getPopularity());

            System.out.println("1. Wrestle Match\n2. Backstage Politics\n3. Buy Steroids\n4. Seduce Rival\n5. Save Game\n6. Exit");
            int choice = scanner.nextInt();
            
            if (choice == 6) break;
            handleChoice(choice, player);
            advanceWeek(player);
            
            if (random.nextInt(100) < 20) {
                randomEvent(player);
            }
        }
        System.out.println("CAREER OVER: " + (player.getHealth() <= 0 ? "You died of CTE" : "You retired"));
    }

    private static Wrestler createWrestler() {
        System.out.print("Enter wrestler name: ");
        scanner.nextLine(); // Clear buffer
        String name = scanner.nextLine();
        return new Wrestler(name.isEmpty() ? "The Java Destroyer" : name, 100, 5000, 0);
    }

    private static void handleChoice(int choice, Wrestler player) {
        switch(choice) {
            case 1 -> wrestleMatch(player);
            case 2 -> backstagePolitics(player);
            case 3 -> buySteroids(player);
            case 4 -> seduceRival(player);
            case 5 -> saveGame(player);
            default -> System.out.println("Invalid choice!");
        }
    }

    private static void wrestleMatch(Wrestler player) {
        Wrestler opponent = new Wrestler("Generic Opponent", 80, 0, 30);
        Match.startMatch(player, opponent);
    }

    private static void backstagePolitics(Wrestler player) {
        System.out.println("You schmooze with executives...");
        player.setPopularity(player.getPopularity() + 5);
        player.setMoney(player.getMoney() - 200);
    }

    private static void buySteroids(Wrestler player) {
        player.takeSteroid();
        System.out.println("💉 You bought steroids (-15 health, -$5000)");
    }

    private static void seduceRival(Wrestler player) {
        System.out.println("You attempt to seduce your rival...");
        if (random.nextBoolean()) {
            System.out.println("Success! Rival is now your lover ❤️");
        } else {
            System.out.println("Failed! The rivalry intensifies!");
            player.setHealth(player.getHealth() - 10);
        }
    }

    private static void advanceWeek(Wrestler player) {
        player.setWeek(player.getWeek() + 1);
    }

    private static void randomEvent(Wrestler player) {
        switch(random.nextInt(3)) {
            case 0 -> {
                System.out.println("⭐ Random Event: Bonus!");
                player.setMoney(player.getMoney() + 1000);
            }
            case 1 -> {
                System.out.println("⭐ Random Event: Injury!");
                player.setHealth(player.getHealth() - 20);
            }
            case 2 -> {
                System.out.println("⭐ Random Event: Fan Day!");
                player.setPopularity(player.getPopularity() + 15);
            }
        }
    }

    private static void saveGame(Wrestler player) {
        try {
            SaveManager.saveGame(player);
            System.out.println("Game saved successfully!");
        } catch (IOException e) {
            System.out.println("Failed to save game: " + e.getMessage());
        }
    }
}
