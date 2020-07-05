package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayerFactory playerFactory = new PlayerFactory();
        Board board = new Board("         ");

        String[] inputCommand = checkValidInput(scanner);
        Player playerOne = playerFactory.make(inputCommand[1], board, 'X', scanner);
        Player playerTwo = playerFactory.make(inputCommand[2], board, 'O', scanner);

        board.printBoard();
        boolean playerOneTurn = false;

        while (true) {
            while (board.isRunning()) {
                if (playerOneTurn) {
                    playerOne.takeTurn();
                } else {
                    playerTwo.takeTurn();
                }
                playerOneTurn = !playerOneTurn;
                board.printBoard();
                board.printState();
            }
            inputCommand = checkValidInput(scanner);
            if (inputCommand[0].equals("exit")) {
                break;
            } else {
                playerOne = playerFactory.make(inputCommand[1], board, 'X', scanner);
                playerTwo = playerFactory.make(inputCommand[2], board, 'O', scanner);
                board.clearBoard();
                board.setRunning(true);
            }
        }
    }

    public static String[] checkValidInput(Scanner scanner) {
        System.out.print("Input command: ");
        String input = scanner.nextLine();

        while (true) {
            if (input.matches("(start (user|easy|medium) (user|easy|medium)|exit)")) {
                return input.split(" ");
            } else {
                System.out.println("Bad parameters!");
                System.out.print("Input command: ");
                input = scanner.nextLine();
            }
        }
    }
}


