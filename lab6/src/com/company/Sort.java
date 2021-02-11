package Command;

public class Sort implements Command {
    @Override
    public void execute() {
        System.out.println("\nByTime\n" + "ByPrice\n" + "Back\n" + "Exit");
    }

    @Override
    public String getName() {
        return "Sort";
    }
}