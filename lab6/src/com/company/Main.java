package Main;

import Command.Command;
import Command.Invoker;
import Passes.Excursion;
import Passes.Holiday;
import Passes.PassBase;
import Passes.Sanitation;

import static Command.Invoker.commands;



public class Main {
    public static ArrayList<PassBase> vouchers = new ArrayList<>();
    public static int n;

    public static void main(String[] args) throws IOException {
        listVouchers();
        System.out.println(vouchers.isEmpty());
        Invoker invoker = new Invoker();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String key;
        Command command;
        Invoker.execute("Menu");
        while (true) {
            key = reader.readLine();
            if (key.equals("Exit")) break;
            command = commands.get(key);
            if (command == null) {
                System.out.println("Command is not found");
                continue;
            }
            Invoker.execute(key);
        }
    }

    public static void listVouchers() {
        PassBase x = new Excursion(1, "London", 3, 1000, "25.10.20");
        vouchers.add(x);
        n++;
        PassBase x1 = new Holiday(2, "Cyprus", 5, 200, "11.12.19");
        vouchers.add(x1);
        n++;
        PassBase x2 = new Sanitation(3, "Barcelona", 14, 1500, "16.08.20");
        vouchers.add(x2);
        n++;
    }

    public static void PrintList() {
        for (int i = 0; i < n; i++) {
            System.out.println(vouchers.get(i));
        }
    }
}

