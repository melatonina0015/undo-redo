package command;

import java.util.Objects;
import java.util.Comparator;

public class Square implements Comparable<Square> { //Receiver
    private int i;
    private int x;
    private int y;
    private int l;

    public Square(int i, int l) {
        this.i = i;
        this.x = 0;
        this.y = 0;
        this.l = l;
    }

    public void executeCommand(Command command) {
        command.execute();
    }

    @Override
    public String toString() {
        return i + " " + x + " " + y + " " + l;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return i == square.i && x == square.x && y == square.y && l == square.l;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, x, y, l);
    }

    @Override
    public int compareTo(Square o){
        return Integer.compare(i,o.i);
    }

    public int getI() {
        return i;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }
}
