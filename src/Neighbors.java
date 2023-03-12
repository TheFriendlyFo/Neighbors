import java.util.ArrayList;
import java.util.Scanner;

public class Neighbors {
    private static final Scanner scanner = new Scanner(System.in);

    private Neighbors() {}

    public static void playGame(int boardSize, int numPlayers) {
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player(boardSize, i));
        }

        for (int i = 0; i < boardSize*boardSize; i++) {
            int diceValue = rollDice();

            for (Player player : players) {
                queuePlayer(player);
                displayRoll(diceValue);
                player.takeTurn(diceValue);
                scanner.nextLine();
            }
        }

        for (Player player : players) {
            player.calcScore();
        }
        SearchAndSort.sort(players);

        System.out.println("\n".repeat(30));
        System.out.println("}---------------LEADERBOARD---------------{\n");
        for (Player player : players) {
            System.out.println(player);
        }
        System.out.println("}-----------------------------------------{");
    }

    private static void queuePlayer(Player player) {
        System.out.print("\n".repeat(40));
        System.out.println("}------------------------------------------{");
        System.out.printf("|         Game queued for player %s         |\n", player.getID() + 1);
        System.out.println("|          Press enter to continue         |");
        System.out.println("}------------------------------------------{");
        scanner.nextLine();
        System.out.print("\n".repeat(40));
    }

    private static int rollDice() {
        return (int) (Math.random() * 10) + 1;
    }

    private static void displayRoll(int diceValue) {
        System.out.println("Dice roll: \n");
        System.out.println("[}---{]");
        System.out.printf("| %2s  |\n", diceValue);
        System.out.println("[}---{]\n");
    }
}
