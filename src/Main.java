import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("What size board would you like to play?");
        int boardSize = scan.nextInt();
        Neighbors.playGame(boardSize, 2);
    }
}