package Command;

public class Menu implements Command {
    @Override
    public void execute() {
        System.out.println("\nShowTours\n" + "Exit");
    }

    @Override
    public String getName() {
        return "Menu";
    }
}