package tictactoe;

public class Board {

    private Cell[][] cells = new Cell[3][3];
    final String[] acceptedValues = {"1", "2", "3"};
    private boolean running = true;

    public Board(String input) {
        addCellsToBoard(input);
    }

    private void addCellsToBoard(String input) {
        char[] oldCells = input.toCharArray();
        int cellCounter = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cell(oldCells[cellCounter]);
                cellCounter++;
            }
        }
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j].setValue(' ');
            }
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public String[] getAcceptedValues() {
        return acceptedValues;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isxTurn() {
        int xCount = 0;
        int oCount = 0;

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                if (cells[i][j].getValue() == 'O') {
                    oCount++;
                } else if (cells[i][j].getValue() == 'X') {
                    xCount++;
                }
            }
        }

        return xCount == oCount;
    }

    public Cell getCellAtPos(int row, int col) {
        return cells[row][col];
    }

    /*public void setCellAtPos(char value, int x, int y) {
        cells[x][y].setValue(value);
    }*/

    public boolean setCellWithUserInput(char value, String input) {
        if (!input.matches("[0-9]+\\s[0-9]+")) {
            System.out.println("You should enter numbers!");
            return false;
        } else {
            int intCol = input.charAt(0) - '0';
            int intRow = input.charAt(2) - '0';

            if (intRow > 3 || intCol > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                return false;
            }

            int newRow = processRow(intRow - 1);
            intCol -=  1;

            if (cells[newRow][intCol].isEmpty()) {
                cells[newRow][intCol].setValue(value);
                return true;
            } else {
                System.out.println("This cell is occupied! Choose another one!");
                return false;
            }
        }
    }

    public boolean setCellWithAIInput(char value, String input) {
        int intCol = input.charAt(0) - '0';
        int intRow = input.charAt(2) - '0';
        //int newRow = processRow(intRow - 1);
        //intCol -=  1;

        //if (cells[newRow][intCol].isEmpty()) {
        //    cells[newRow][intCol].setValue(value);
        if (cells[intRow][intCol].isEmpty()) {
            cells[intRow][intCol].setValue(value);
            return true;
        } else {
        return false;
        }
    }

    private int processRow(int input) {
        if(input == 0) {
            return 2;
        } else if (input == 2) {
            return 0;
        } else {
            return 1;
        }
    }

    private boolean isNumeric (String number) {
        boolean isANumber = true;
        if (number == null) isANumber = false;
        try {
            assert number != null;
            int n = Integer.parseInt(number);
        }
        catch (NumberFormatException e) {
            isANumber = false;
        }
        return isANumber;
    }

    public boolean checkWon(char value) {
        for (int i = 0; i < cells.length; i++) {
            //checks the rows
            if (cells[i][0].getValue() == value && cells[i][1].getValue() == value && cells[i][2].getValue() == value) {
                return true;
            }
            //checks the columns
            if (cells[0][i].getValue() == value && cells[1][i].getValue() == value && cells[2][i].getValue() == value) {
                return true;
            }
        }
        //checks diagonals
        if (cells[0][0].getValue() == value && cells[1][1].getValue() == value && cells[2][2].getValue() == value ||
                cells[0][2].getValue() == value && cells[1][1].getValue() == value && cells[2][0].getValue() == value) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkFinished() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(cells[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        System.out.println("---------");
        System.out.println("| " + cells[0][0] + " " + cells[0][1] + " " + cells[0][2] + " |");
        System.out.println("| " + cells[1][0] + " " + cells[1][1] + " " + cells[1][2] + " |");
        System.out.println("| " + cells[2][0] + " " + cells[2][1] + " " + cells[2][2] + " |");
        System.out.println("---------");
    }

    public void printState() {
        if (checkWon('O')) {
            System.out.println("O wins");
            running = false;
        } else if (checkWon('X')) {
            System.out.println("X wins");
            running = false;
        } else if (checkFinished()) {
            System.out.println("Draw");
            running = false;
        } //else {
          //  System.out.println("Game not finished");
        //}
    }

    public String getBoardStateAsString() {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                returnString.append(cells[i][j]);
            }
        }
        return returnString.toString();
    }
}
