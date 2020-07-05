package tictactoe;

public abstract class Player {

    protected Board board;
    protected boolean validMoveMade;
    protected char playerChar;

    public Player(Board board, char playerChar) {
        this.board = board;
        this.playerChar = playerChar;
        validMoveMade = false;
    }

    protected abstract void takeTurn();
}
