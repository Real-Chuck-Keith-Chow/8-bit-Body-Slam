package wrestling.simulator;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.println("=== 8-BIT BODY SLAM ===");
        System.out.println("Wrestling Career Simulator\n");
        
        System.out.print("Enter your wrestler name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = "The Rookie";
        
        Wrestler player = new Wrestler(name);
        Wrestler opponent = generateOpponent(random);
        
        boolean playing = true;
        while (playing && player.getHealth() > 0) {
            System.out.println("\n=== WEEK " + (player.getWeek() + 1) + " ===");
            System.out.println(player);  // Show stats
            System.out.println("\n1. Fight Match");
            System.out.println("2. Backstage Politics");
            System.out.println("3. Buy Steroids");
            System.out.println("4. Save & Quit");
            
            try {
                System.out.print("\nChoose action: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Clear newline
                
                switch (choice) {
                    case 1:
                        Match.fight(player, opponent);
                        opponent = generateOpponent(random); // New opponent
                        player.setWeek(player.getWeek() + 1);
                        break;
                    case 2:
                        backstagePolitics(player);
                        break;
                    case 3:
                        buySteroids(player);
                        break;
                    case 4:
                        playing = false;
                        System.out.println("Saving career...");
                        // SaveManager.save(player); // Uncomment when ready
                        break;
                    default:
                        System.out.println("Invalid choice! (Pick 1-4)");
                }
                
                // Random events
                if (random.nextInt(100) < 30) {
                    triggerRandomEvent(player, random);
                }
                
            } catch (Exception e) {
                System.out.println("Please enter a number!");
                scanner.nextLine();  // Clear invalid input
            }
        }
        
        if (player.getHealth() <= 0) {
            System.out.println("\nGAME OVER! Your wrestler retired due to injuries!");
        } else {
            System.out.println("\nThanks for playing!");
        }
        scanner.close();
    }

    private static Wrestler generateOpponent(Random rand) {
        String[] names = {"The Viper", "Iron Mike", "Luchador", "Giant", "Technician"};
        return new Wrestler(names[rand.nextInt(names.length)]);
    }

    private static void backstagePolitics(Wrestler player) {
        System.out.println("\nYou schmooze with promoters...");
        player.setPopularity(player.getPopularity() + 15);
        player.setMoney(player.getMoney() - 500);
        System.out.println("+15 Popularity | -$500");
    }

    private static void buySteroids(Wrestler player) {
        System.out.println("\nYou acquire... 'performance enhancers'");
        player.setHealth(player.getHealth() - 20);
        player.setPopularity(player.getPopularity() + 30);
        System.out.println("+30 Popularity | -20 Health");
    }

    private static void triggerRandomEvent(Wrestler player, Random rand) {
        String[] events = {
            "\n* Random Event: Bonus Payday! +$2000",
            "\n* Random Event: Food poisoning! -15 Health",
            "\n* Random Event: Merch sales boom! +10 Popularity"
        };
        String event = events[rand.nextInt(events.length)];
        System.out.println(event);
        
        if (event.contains("Bonus")) player.setMoney(player.getMoney() + 2000);
        else if (event.contains("poisoning")) player.setHealth(player.getHealth() - 15);
        else player.setPopularity(player.getPopularity() + 10);
    }
}

