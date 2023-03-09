import java.util.ArrayList;
import java.util.Scanner;

public class Neighbors {
    private static final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Player> players;
    private final int boardSize;

    public Neighbors(int numPlayers, int boardSize) {
        players = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player(boardSize));
        }
    }

    public void playGame() {
        for (int i = 0; i < boardSize*boardSize; i++) {
            playTurn();
        }
    }

    private void playTurn() {
        int diceValue = rollDice();

        for (int i = 0; i < players.size(); i++) {
            queuePlayer(i + 1);
            displayRoll(diceValue);
            players.get(i).takeTurn(diceValue);
        }
    }

    private static void queuePlayer(int playerNum) {
        System.out.print("\n".repeat(40));
        System.out.println("}------------------------------------------{");
        System.out.printf("|         Game queued for player %s         |\n", playerNum);
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

    public static int calculateRow(Player player) {
        int[][] board = player.getBoard();
        int previous = 0;
        int sum = 0;
        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (ints[j] == previous) {
                    previous += ints[j];
                } else {
                    sum += previous;
                    previous = 0;
                }
            }
            previous = 0;
        }
        return sum;
    }

    public static int calculateColumn(Player player) {
        int[][] board = player.getBoard();
        int previous = 0;
        int sum = 0;
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 0; i < board.length; i++) {
                if (board[j][i] == previous) {
                    previous += board[j][i];
                } else {
                    sum += previous;
                    previous = 0;
                }
            }
            previous = 0;
        }
        return sum;
    }
}
