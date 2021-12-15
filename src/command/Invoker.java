package command;

import java.util.ArrayList;
import java.util.Stack;

public class Invoker { //Invoker, Client
    private Stack<Command> history = new Stack<>();
    private Stack<Command> historyRedo = new Stack<>();

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

