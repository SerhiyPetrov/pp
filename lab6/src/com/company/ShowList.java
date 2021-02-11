package Command;import static Main.Main.PrintList;import static Main.Main.vouchers;

public class ShowList implements Command {
    @Override
    public void execute() {
        PrintList();
        System.out.println("Back\n" + "Exit");
    }

    @Override
    public String getName() {
        return "ShowList";
    }
}