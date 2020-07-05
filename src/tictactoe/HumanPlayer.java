package tictactoe;
import java.util.Scanner;

public class HumanPlayer extends Player {

    private final Scanner scanner;

    public HumanPlayer(Board board, char playerChar, Scanner scanner) {
        super(board, playerChar);
        this.scanner = scanner;
    }

    @Override
    protected void takeTurn() {
        validMoveMade = false;
        while (!validMoveMade) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine();
            validMoveMade = board.setCellWithUserInput(playerChar, input);
        }
    }
}
