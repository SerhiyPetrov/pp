package com.company;

public class Invoker {
    public static HashMap<String, Command> commands = new HashMap<>();
    public static List<String> history = new ArrayList<>();

    public Invoker() {
        Command cmd = new Main.Menu();
        commands.put(cmd.getName(), cmd);
        cmd = new Main.Filter();
        commands.put(cmd.getName(), cmd);
        cmd = new Main.Exit();
        commands.put(cmd.getName(), cmd);
        cmd = new Main.ShowList();
        commands.put(cmd.getName(), cmd);
        cmd = new Main.ShowTours();
        commands.put(cmd.getName(), cmd);
        cmd = new Main.Sort();
        commands.put(cmd.getName(), cmd);
        cmd = new Main.Back();
        commands.put(cmd.getName(), cmd);
        cmd = new Main.ByPrice();
        commands.put(cmd.getName(), cmd);
        cmd = new Main.ByTime();
        commands.put(cmd.getName(), cmd);
    }

    static public void execute(String commandName) {
        Command command = commands.get(commandName);
        command.execute();
        history.add(commandName);
        if ((history.size() > 2) && history.get(history.size() - 1).equals(history.get(history.size() - 2)))
            history.remove(Invoker.history.size() - 1);
        if ((!history.isEmpty()) && (history.get(history.size() - 1).equals("Back")))
            history.remove(Invoker.history.size() - 1);
    }
}