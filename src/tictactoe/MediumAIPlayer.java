package tictactoe;

public class MediumAIPlayer extends AIPlayer {

    public MediumAIPlayer(Board board, char playerChar) {
        super(board, playerChar);
    }

    @Override
    protected void takeTurn() {
        printMoveMessage();
        String winningMove = findWinningMove();
        String blockingMove = findBlockingMove();
        if(!findWinningMove().equals("")) {
            board.setCellWithAIInput(playerChar, winningMove);
        } else if (!findBlockingMove().equals("")) {
            board.setCellWithAIInput(playerChar, blockingMove);
        } else {
            makeRandomMove();
        }
    }

    @Override
    protected void printMoveMessage() {
        System.out.println("Making move level \"medium\"");
    }

    protected String findWinningMove() {
        Board nextBoard = new Board(board.getBoardStateAsString());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (nextBoard.getCellAtPos(i, j).isEmpty()) {
                    nextBoard.setCellWithAIInput(playerChar, i + " " + j);
                    if (nextBoard.checkWon(playerChar)) {
                        return i + " " + j;
                    } else {
                        nextBoard = new Board(board.getBoardStateAsString());
                    }
                }
            }
        }
        return "";
    }


    protected String findBlockingMove() {
        Board nextBoard = new Board(board.getBoardStateAsString());
        char enemyChar = playerChar == 'X' ? 'O' : 'X';

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (nextBoard.getCellAtPos(i, j).isEmpty()) {
                    nextBoard.setCellWithAIInput(enemyChar, i + " " + j);
                    if (nextBoard.checkWon(enemyChar)) {
                        return i + " " + j;
                    } else {
                        nextBoard = new Board(board.getBoardStateAsString());
                    }
                }
            }
        }
        return "";
    }
}
