package Command;import Passes.PassBase;import java.util.Comparator;import static Main.Main.PrintList;import static Main.Main.vouchers;

public class ByTime implements Command {
    @Override
    public void execute() {
        vouchers.sort(new Comparator<Main.PassBase>() {
            @Override
            public int compare(Main.PassBase o1, Main.PassBase o2) {
                return o1.PassDuration.compareTo(o2.PassDuration);
            }
        });
        PrintList();
        System.out.println("Back\n" + "Exit");
    }

    @Override
    public String getName() {
        return "ByTime";
    }
}