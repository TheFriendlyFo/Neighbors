import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter board size:");
        System.out.print("> ");
        int boardSize = scan.nextInt();
        System.out.println("Enter number of players:");
        System.out.print("> ");
        int numPlayers = scan.nextInt();
        Neighbors.playGame(boardSize, numPlayers);
    }
}