package tictactoe;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Cells: ");
        Board board = new Board(scanner.nextLine());
        boolean moveMade = false;
        board.printBoard();

        while (!moveMade) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine();
            moveMade = board.setCellWithUserInput(board.isxTurn() ? 'X' : 'O', input);
        }
        board.printBoard();
        board.printState();
    }
}


