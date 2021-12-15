package command;

import java.util.ArrayList;

public class PrintCommand implements Command {
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
