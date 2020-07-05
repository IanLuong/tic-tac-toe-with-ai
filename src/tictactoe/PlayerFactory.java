package tictactoe;

import java.util.Scanner;

public class PlayerFactory {

    public Player make(String type, Board board, char playerChar, Scanner scanner) {
        switch (type) {
            case "easy":
                return new EasyAIPlayer(board, playerChar);
            case "medium":
                return new MediumAIPlayer(board, playerChar);
            case "user":
                return new HumanPlayer(board, playerChar, scanner);
            default:
                return null;
        }
    }
}
