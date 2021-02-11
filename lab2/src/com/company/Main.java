package com.company;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number of products : ");
        int count = scanner.nextInt();
        scanner.nextLine();
        ProductOperations product_oper = new ProductOperations();
        ArrayList <Product> products_array = new ArrayList<Product>();
        products_array = product_oper.GenerateProducts(count);
        System.out.println("Input name of product : ");
        String name = scanner.nextLine();
        Product product = new Product();
        product = product_oper.Stringbool(products_array, name);
        System.out.println(product.toString());
        System.out.println("Input cost of product : ");
        double cost = scanner.nextDouble();
        product_oper.CheckCost(product_oper.Stringbool(products_array, name), cost);
        Date date = new Date();
        System.out.println("Input date "+ "\n" + " day : " );
        date.day = scanner.nextInt();
        System.out.println("month : " );
        date.month = scanner.nextInt();
        System.out.println("year : " );
        date.year = scanner.nextInt();
        product_oper.CheckDate(products_array , date, count);
        scanner.close();
    }
}