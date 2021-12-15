package command;

import java.util.ArrayList;

public class MoveCommand implements Command{
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
