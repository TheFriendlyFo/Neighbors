import java.lang.reflect.Array;
import java.util.ArrayList;

public class Neighbors {
    private final ArrayList<Player> players;
    private final int boardSize;

    public Neighbors(int numPlayers, int boardSize) {
        this.boardSize = boardSize;
        players = new ArrayList<>();

        for (int i = 0; i < numPlayers; i++) {
            players.add(new Player(boardSize));
        }
    }

    public void playTurn() {
        int diceValue = rollDice();

        for (Player player : players) {
            player.takeTurn(diceValue);
        }
    }

    public static int rollDice() {
        return (int) (Math.random() * 10) + 1;
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
