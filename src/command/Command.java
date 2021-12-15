package command;
public interface Command {
    void execute();
    void undo();

    default boolean isReversible(){
        return true;
    }
}