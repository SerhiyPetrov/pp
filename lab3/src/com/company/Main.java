package Main;
import java.util.Scanner;
import Battleground.Battleground;
public class Main {
    public static void main(String[] args) {
        Battleground battleground = new Battleground();
        Scanner in = new Scanner(System.in);
        System.out.println("\nWelcome to the battle of superheroes.\nThere are 4 heroes
                ready to fight. Do you want to look their stats?(1 - yes, 2 - no)");
        int choice1 = in.nextInt();
        battleground.cards(choice1);
        int choice2 = 1;
        do {
            System.out.println("Enter the number to choose the fighters :\n 1 - Superman\n
                    2 - Batman\n 3 - Hulk\n 4 - Iron man ");
            int fighter1 = in.nextInt();
            System.out.println("vs");
            int fighter2 = in.nextInt();
            battleground.choiceOfFighters(fighter1, fighter2);
            System.out.println("\t\t\t" + battleground.opponent1.getName() + " vs " +
                    battleground.opponent2.getName());
            System.out.println("\n\t\t\t!!! Fight !!! ");
            System.out.println();
            battleground.battle(battleground.opponent1, battleground.opponent2);
            System.out.println("Do you want to repeat ?(1 - yes , 2 - no)");
            choice2 = in.nextInt();
        }while (choice2 == 1);
    }
}