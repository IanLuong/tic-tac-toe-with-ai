package tictactoe;

public class EasyAIPlayer extends AIPlayer {

    public EasyAIPlayer(Board board, char playerChar) {
        super(board, playerChar);
    }

    @Override
    public void takeTurn() {
        printMoveMessage();
        makeRandomMove();
    }

    @Override
    protected void printMoveMessage() {
        System.out.println("Making move level \"easy\"");
    }
}
