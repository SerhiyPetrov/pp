package Command;

public interface Command {
    void execute();

    String getName();
} package Command;

public class Menu implements Command {
    @Override
    public void execute() {
        System.out.println("\nShow the Tours\n" + "See reviews\n" + "Exit");
    }

    @Override
    public String getName() {
        return "Menu";
    }
} package Passes;

public class Sanitation extends PassBase {
    String PassType = "Sanitation";

    @Override
    public String toString() {
        return "Sanitation{" + "PassType='" + PassType + '\'' + ", PassType='" + PassType + '\'' + ", PassLocation='" + PassLocation + '\'' + ", PassDuration='" + PassDuration + '\'' + ", PassPrice='" + PassPrice + '\'' + ", PassDates='" + PassDates + '\'' + '}';
    }
}