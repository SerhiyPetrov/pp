package Command;

public class Filter implements Command {
    @Override
    public void execute() {
        System.out.println("\nBy destination\n" + "by time\n" + "by price\n" + "by dates\n" + "Back\n" + "Exit");
    }

    @Override
    public String getName() {
        return "Filter";
    }
}