package command;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Square> squares = new ArrayList<Square>();
        Invoker invoker = new Invoker();
        Scanner scan = new Scanner(System.in);

        while (true){
            String string = scan.nextLine();
            String[] options = string.split(" ");
            String option = options[0];

            switch (option){
                case "C":
                    invoker.createCommand(squares, Integer.parseInt(String.valueOf(options[1])), Integer.parseInt(String.valueOf(options[2])));
                    break;

                case "M":
                    invoker.moveCommand(squares,Integer.parseInt(String.valueOf(options[1])), Integer.parseInt(String.valueOf(options[2])), Integer.parseInt(String.valueOf(options[3])));
                    break;

                case "S":
                    invoker.scaleCommand(squares,Integer.parseInt(String.valueOf(options[1])),  Integer.parseInt(String.valueOf(options[2])));
                    break;

                case "U":
                    invoker.undo();
                    break;

                case "R":
                    invoker.redo();
                    break;

                case "P":
                    invoker.printCommand(squares);
                    break;
            }
        }
    }
}