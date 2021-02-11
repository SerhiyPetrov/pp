package com.company;
import java.util.Scanner;
public class Main {
    private static int a;
    private static char b;
    public static void main(String[] args) {
        System.out.println("Hello world");
        System.out.println(a);
        System.out.println(b);
        for(int i = 0; i < args.length; i++)
            System.out.println("args[" + i + "]: " + args[i]);
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num1 = in.nextInt();
        System.out.print("Input a number: ");
        int num2 = in.nextInt();
        long sumeven = 0, sumodd = 0;
        int maxodd = 0, maxeven = 0;
        for (int i = num1; i < num2; i++) {
            if (i % 2 == 1) {
                System.out.printf("%d ", i);
                sumodd += i;
                if (i>maxodd) maxodd=i;
            }
        }
        System.out.print("\n");
        for (int i = num2; i > num1; i--) {
            if (i % 2 == 0) {
                System.out.printf("%d ", i);
                sumeven += i;
                if (i > maxeven) maxeven=i;
            }
        }
        System.out.printf("\nSum of odd: %d\nSum of even: %d\n", sumodd, sumeven);
        System.out.print("Input size of set: ");
        int n = in.nextInt();
        int z = 0;
        System.out.printf("%d %d ", maxodd, maxeven);
        int numeven = 1, numodd = 1;
        for (int i = 0, x = maxodd, y = maxeven; i < n - 2; i++){
            z = x + y;
            if (z % 2 == 0) numeven++;
            else numodd++;
            System.out.printf("%d ", z);
            x = y;
            y = z;
        }
        double odd = ((double)numodd / (n)) * 100.0;
        double even = ((double)numeven / (n)) * 100.0;
        System.out.printf("\nPercent of odd: %.1f%%\nPercent of even: %.1f%%",odd ,even);
    }
}
