import java.util.Scanner;

public class Player implements Comparable{
    private final int[][] board;
    private final Scanner scanner;
    private final int id;
    private int score;

    public Player(int boardSize, int id) {
        board = new int[boardSize][boardSize];
        scanner = new Scanner(System.in);
        this.id = id;
    }

    public void calcScore() {
        score = calculateCol() + calculateRow();
    }

    public void takeTurn(int diceValue) {
        displayBoard();

        System.out.println("Select row to place value in");
        System.out.print("> ");
        int row = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Select column to place value in");
        System.out.print("> ");
        int col = scanner.nextInt();
        scanner.nextLine();

        if (validSpace(row - 1, col - 1)) {
            board[row - 1][col - 1] = diceValue;
            displayBoard();

            System.out.println("\nPress enter to finish turn and queue next player.");

        } else {
            takeTurn(diceValue);
        }
    }

    private boolean validSpace(int row, int col) {
        return (0 <= row && row < board.length) && (0 <= col && col < board.length) && board[row][col] == 0;
    }

    public void displayBoard() {
        for (int row = 0; row < board.length; row++) {
            System.out.println("" + "+---+ ".repeat(board.length));

            for (int col : board[row]) {
                System.out.printf("|%2s | ", col == 0 ? " " : col);
            }
            System.out.printf("(%s)", row + 1);
            System.out.println("\n" + "+---+ ".repeat(board.length));
        }

        for (int col = 0; col < board.length; col++) {
            System.out.printf(" (%s)  ", col + 1);
        }
        System.out.println();
    }

    public int getID() {
        return id;
    }

    @Override
    public int compareTo(Comparable compare, int sortType) {
        Player comp = (Player) compare;
        if (score != comp.score) return -Integer.compare(score, comp.score);
        return Integer.compare(id, comp.id);
    }

    private int calculateRow() {
        int current;
        int sum = 0;

        for (int row = 0, streak = 0; row < board.length; row++, streak = 0) {
            current = board[row][0];
            for (int col : board[row]) {
                if (col == current) {
                    streak++;
                    if (streak >= 2) sum += current * (streak == 2 ? 2 : 1);
                } else {
                    current = col;
                    streak = 1;
                }
            }
        }

        return sum;
    }

    private int calculateCol() {
        int current;
        int sum = 0;

        for (int col = 0, streak = 0; col < board.length; col++, streak = 0) {
            current = board[0][col];
            for (int row = 0; row < board[0].length; row++) {
                if (board[row][col] == current) {
                    streak++;
                    if (streak >= 2) sum += current * (streak == 2 ? 2 : 1);
                } else {
                    current = board[row][col];
                    streak = 1;
                }
            }
        }

        return sum;
    }

    @Override
    public String toString() {
        return String.format("Player %s - %s points\n", id + 1, score);
    }
}
