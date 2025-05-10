import java.util.Random;
import java.util.Scanner;

public class WrestlingGame {
    public static Random random = new Random(); // Fixed typo: "rondom" -> "random"
    public static Scanner scanner = new Scanner(System.in); // Added missing Scanner

    public static void main(String[] args) {
        Wrestler player = createWrestler();
        while (player.getWealth() > 0) {
            System.out.println("--- Week " + player.getWeek() + " ---"); // Fixed string concatenation
            System.out.println("Money: $" + player.getMoney() + " | Wealth: $" + player.getWealth());

            // Monthly choices
            System.out.println("1. Wrestle Match\n2. Backstage Politics\n3. Buy Steroids\n4. Reduce Rival");
            int choice = scanner.nextInt();
            handleChoice(choice, player);
            advanceWeek(player);
        }
        System.out.println("CAREER OVER: You died of CTE"); // Fixed typo: "CAREER VOEH" -> "CAREER OVER"
    }

    private static Wrestler createWrestler() {
        return new Wrestler("The Java Wrestler", 100, 5000, 0, false); // Fixed "now.Wrestler" -> "new Wrestler"
    }

    private static void handleChoice(int choice, Wrestler player) {
        switch (choice) {
            case 1 -> wrestleMatch(player); // Fixed method name: "wrestlerGetG" -> "wrestleMatch"
            case 2 -> backstagePolitics(player); // Fixed method name: "backstageBaltisG" -> "backstagePolitics"
            case 3 -> buySteroids(player);
            case 4 -> reduceRival(player); // Fixed method name: "subdiceRiva" -> "reduceRival"
            default -> System.out.println("Invalid choice!");
        }
    }

    private static void wrestleMatch(Wrestler player) {
        System.out.println("You wrestled a match! +$500");
        player.setMoney(player.getMoney() + 500); // Fixed: "setWowSet" -> "setMoney", "$00" -> "500"
        player.setWealth(player.getWealth() - 10); // Wealth decreases by 10 (logical?)
    }

    private static void buySteroids(Wrestler player) {
        player.setWealth(player.getWealth() - 15);
        player.setSteroids(true); // Fixed: "setSDASeroA" -> "setSteroids"
        player.setMoney(player.getMoney() - 5000); // Fixed: "setDowStress" -> "setMoney", "$000" -> "5000"
        System.out.println("You bought steroids (-15 health, -$5000)");
    }

    private static void advanceWeek(Wrestler player) {
        player.setWeek(player.getWeek() + 1);
    }

    // Placeholder methods (to avoid compilation errors)
    private static void backstagePolitics(Wrestler player) {
        System.out.println("Backstage politics: +$200, +5 popularity");
        player.setMoney(player.getMoney() + 200);
    }

    private static void reduceRival(Wrestler player) {
        System.out.println("Rival reduced! -$300");
        player.setMoney(player.getMoney() - 300);
    }
}
