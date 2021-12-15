

import java.util.Objects;
import java.util.Collections;

import java.util.*;

public class Solution {
    public static void main(String[] args) {

        ArrayList<Square> squares = new ArrayList<>();
        Invoker invoker = new Invoker();
        Scanner scan = new Scanner(System.in);

        while (true){
            String string = scan.nextLine();
            String[] options = string.split(" ");
            String option = options[0];

            switch (option) {
                case "C" -> invoker.createCommand(squares, Integer.parseInt(String.valueOf(options[1])), Integer.parseInt(String.valueOf(options[2])));
                case "M" -> invoker.moveCommand(squares, Integer.parseInt(String.valueOf(options[1])), Integer.parseInt(String.valueOf(options[2])), Integer.parseInt(String.valueOf(options[3])));
                case "S" -> invoker.scaleCommand(squares, Integer.parseInt(String.valueOf(options[1])), Integer.parseInt(String.valueOf(options[2])));
                case "U" -> invoker.undo();
                case "R" -> invoker.redo();
                case "P" -> invoker.printCommand(squares);
            }
        }
    }
}

class Square implements Comparable<Square> { //Receiver
    private final int i;
    private int x;
    private int y;
    private int l;

    public Square(int i, int l) {
        this.i = i;
        this.x = 0;
        this.y = 0;
        this.l = l;
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
        return i == square.getI() && x == square.getX() && y == square.getY() && l == square.getL();
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, x, y, l);
    }

    @Override
    public int compareTo(Square o){
        return Integer.compare(i,o.getI());
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

class Invoker { //to.lab.solution.Invoker, Client
    private final Stack<Command> history = new Stack<>();
    private final Stack<Command> historyRedo = new Stack<>();

    public void printCommand(ArrayList<Square> list){
        Command command = new PrintCommand(list);
        command.execute();
    }

    public void scaleCommand(ArrayList<Square> list, int i, int j){
        Command command = new ScaleCommand(list, i, j);
        history.push(command);
        historyRedo.clear();
        command.execute();
    }

    public void moveCommand(ArrayList<Square> list,int i, int j, int k){
        Command command = new MoveCommand(list, i, j, k);
        history.push(command);
        historyRedo.clear();
        command.execute();
    }

    public void createCommand(ArrayList<Square> list, int i, int j){
        Command command = new CreateCommand(list, i, j);
        history.push(command);
        historyRedo.clear();
        command.execute();
    }

    public void undo(){
        if(history.isEmpty()) {return;}
        Command command = history.pop();
        command.undo();
        historyRedo.push(command);
    }

    public void redo(){
        if(historyRedo.isEmpty()) {return;}
        Command command = historyRedo.pop();
        command.execute();
        history.push(command);
    }
}

interface Command {
    void execute();
    void undo();
}

class CreateCommand implements Command {
    ArrayList<Square> list;
    int i;
    int j;

    public CreateCommand(ArrayList<Square> list, int i, int j){
        this.list = list;
        this.i = i;
        this.j = j;
    }

    @Override
    public void execute() {
        if(list.isEmpty()){
            Square squaree = new Square(i, j);
            list.add(squaree);
        }else {
            int index = -1;
            for (Square square : list) {
                if (square.getI() == i) {
                    index = list.indexOf(square);
                }
            }

            if (index == -1) {
                Square squaree = new Square(i, j);
                list.add(squaree);
            } else {
                list.get(index).setX(0);
                list.get(index).setY(0);
                list.get(index).setL(j);
            }
        }
        Collections.sort(list);
    }

    @Override
    public void undo(){

        int index = list.size() - 1;
        list.remove(index);
    }
}

class MoveCommand implements Command {
    ArrayList<Square> list;
    int i;
    int j;
    int k;
    int index = 1;

    public MoveCommand(ArrayList<Square> list, int i, int j, int k){
        this.list = list;
        this.i = i;
        this.j = j;
        this.k = k;
    }

    @Override
    public void execute() {
        for (Square square : list) {
            if (square.getI() == i) {
                index = list.indexOf(square);
            }
        }
        if (index != -1) {
            list.get(index).setX(list.get(index).getX()+j);
            list.get(index).setY(list.get(index).getY()+k);

        }
    }

    @Override
    public void undo(){
        list.get(index).setX(list.get(index).getX()-j);
        list.get(index).setY(list.get(index).getY()-k);
    }
}

class ScaleCommand implements Command {
    ArrayList<Square> list;
    int i;
    int j;
    int index = -1;
    public ScaleCommand(ArrayList<Square> list, int i, int j){
        this.list = list;
        this.i = i;
        this.j = j;
    }

    @Override
    public void execute() {
        for (Square square : list) {
            if (square.getI() == i) {
                index = list.indexOf(square);
            }
        }
        if (index != -1) {
            list.get(index).setL(list.get(index).getL()*j);
        }

    }

    @Override
    public void undo(){
        list.get(index).setL(list.get(index).getL()/j);
    }
}

class PrintCommand implements Command {
    ArrayList<Square> list;

    public PrintCommand(ArrayList<Square> list) {
        this.list = list;
    }

    @Override
    public void execute() {
        for (Square square: list) {
            System.out.println(square);
        }
    }

    @Override
    public void undo(){}
}
