package tictactoe;

public class Cell {

    private char value;

    public Cell(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public boolean isEmpty() {
        return value == ' ';
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
