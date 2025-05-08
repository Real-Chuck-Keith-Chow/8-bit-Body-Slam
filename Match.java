package wrestling.simulator;

import java.util.Random;
import java.util.Scanner;

public class Match {
    private static final Random rand = new Random();
    private static final Scanner scanner = new Scanner(System.in);

    public static void startMatch(Wrestler player, Wrestler opponent) {
        System.out.println("\n=== " + opponent.getName().toUpperCase() + " CHALLENGE ===");
        
        while (player.getHealth() > 0 && opponent.getHealth() > 0) {
            displayRing(player, opponent);
            int move = getPlayerMove(player);
            resolveMove(move, player, opponent);
            
            if (opponent.getHealth() > 0) {
                aiTurn(opponent, player);
            }
        }
        
        endMatch(player, opponent);
    }

    private static void displayRing(Wrestler player, Wrestler opponent) {
        System.out.println(
            "╭─────┰─────╮\n" +
            "│  ROPES  ┃\n" +
            "┝━━━━━━━━━┫\n" +
            String.format("│ %-5s vs %5s │\n", player.getName(), opponent.getName()) +
            String.format("│ HP:%-3d ┃ HP:%-3d │\n", player.getHealth(), opponent.getHealth()) +
            "╰─────┸─────╯"
        );
    }

    private static int getPlayerMove(Wrestler player) {
        System.out.println(
            "1. Punch (-5HP)\n" +
            "2. Grapple (-10HP, -5 Stamina)\n" +
            "3. Taunt (+Heat)\n" +
            "4. Dirty Trick (" + (player.isOnSteroids() ? "☠️" : "❌") + ")"
        );
        return scanner.nextInt();
    }

    private static void resolveMove(int move, Wrestler player, Wrestler opponent) {
        switch (move) {
            case 1 -> {
                int damage = 5 + (player.isOnSteroids() ? 10 : 0);
                opponent.takeDamage(damage);
                System.out.println("💥 " + player.getName() + " punches! (-" + damage + "HP)");
            }
            case 2 -> {
                if (player.getStamina() >= 5) {
                    opponent.takeDamage(10);
                    player.useStamina(5);
                    System.out.println("🤼 " + player.getName() + " suplexes! (-10HP)");
                } else {
                    System.out.println("😫 Too exhausted to grapple!");
                }
            }
            case 3 -> {
                player.addHeat(15);
                System.out.println("🎤 Crowd goes wild! (+15 heat)");
            }
            case 4 -> {
                if (player.isOnSteroids()) {
                    opponent.takeDamage(25);
                    System.out.println("🪑 CHAIR SHOT!! (-25HP)");
                } else {
                    System.out.println("🚔 Referee stops your cheating attempt!");
                }
            }
        }
    }

    private static void aiTurn(Wrestler ai, Wrestler player) {
        int move = rand.nextInt(4) + 1;
        
        switch (move) {
            case 1 -> {
                player.takeDamage(5);
                System.out.println(ai.getName() + " punches you! (-5HP)");
            }
            case 2 -> {
                player.takeDamage(8);
                System.out.println(ai.getName() + " dropkicks you! (-8HP)");
            }
            case 3 -> {
                System.out.println(ai.getName() + " poses for the crowd...");
            }
            case 4 -> {
                if (rand.nextBoolean()) {
                    player.takeDamage(20);
                    System.out.println("😱 " + ai.getName() + " hits their FINISHER! (-20HP)");
                }
            }
        }
    }

    private static void endMatch(Wrestler player, Wrestler opponent) {
        if (player.getHealth() <= 0) {
            System.out.println("💀 YOU LOST! Hospital bill: $2000");
            player.setMoney(player.getMoney() - 2000);
        } else {
            int prize = 500 + (opponent.getHeat() * 10);
            System.out.println("🏆 YOU WIN! Prize: $" + prize);
            player.setMoney(player.getMoney() + prize);
        }
    }
}

