package Command;

public class Back implements Command {
    @Override
    public void execute() {
        Invoker.history.remove(Invoker.history.size() - 1);
        String command = Invoker.history.get(Invoker.history.size() - 1);
        Invoker.execute(command);
    }

    @Override
    public String getName() {
        return "Back";
    }
}