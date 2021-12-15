package command;

import java.util.ArrayList;
import java.util.Collections;

public class CreateCommand implements Command {
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
