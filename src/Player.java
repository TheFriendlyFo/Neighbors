import java.util.Scanner;

public class Player {
    private final int[][] board;
    private final Scanner scanner;
    private final int id;

    public Player(int boardSize, int id) {
        board = new int[boardSize][boardSize];
        scanner = new Scanner(System.in);
        this.id = id;
    }

    public int[][] getBoard() {
        return board;
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
            scanner.nextLine();
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
}
