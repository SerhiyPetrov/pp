package Command;

public class ShowTours implements Command {
    @Override
    public void execute() {
        System.out.println("\nShowList\n" + "Sort\n" + "Back\n" + "Exit");
    }

    @Override
    public String getName() {
        return "ShowTours";
    }
}