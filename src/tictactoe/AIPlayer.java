package tictactoe;

import java.util.Random;

public abstract class AIPlayer extends Player{

    protected Random randomizer;

    public AIPlayer(Board board, char playerChar) {
        super(board, playerChar);
        randomizer = new Random();
    }

    protected abstract void printMoveMessage();

    /*protected void makeRandomMove() {
        String move = (randomizer.nextInt(3) + 1) + " " + (randomizer.nextInt(3) + 1);
        validMoveMade = board.setCellWithAIInput(playerChar, move);
    }*/

    protected void makeRandomMove() {
        while (!validMoveMade) {
            String move = randomizer.nextInt(3) + " " + randomizer.nextInt(3);
            validMoveMade = board.setCellWithAIInput(playerChar, move);
        }
        validMoveMade = false;
    }
}
