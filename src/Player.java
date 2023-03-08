import java.util.Scanner;

public class Player {
    private final int[][] board;
    private final Scanner scanner;

    public Player(int boardSize) {
        board = new int[boardSize][boardSize];
        scanner = new Scanner(System.in);
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

        if (validSpace(row + 1, col + 1)) {
            board[row + 1][col + 1] = diceValue;
        } else {
            takeTurn(diceValue);
        }
    }

    private boolean validSpace(int row, int col) {
        return (0 <= row && row < board.length) && (0 <= col && col < board.length) && board[row][col] == 0;
    }

    private void displayBoard() {
        for (int[] row : board) {
            System.out.println("+---+ ".repeat(board.length));
            for (int col : row) {
                System.out.printf("|%2s | ", col == 0 ? " " : col);
            }
            System.out.println("\n" + "+---+ ".repeat(board.length));
        }
    }
}
