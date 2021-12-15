package command;

import java.util.ArrayList;

public class ScaleCommand implements Command{
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
