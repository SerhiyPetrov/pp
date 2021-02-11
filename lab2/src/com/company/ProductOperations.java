import com.company.Date;
import com.company.Product;

import java.util.ArrayList;
import java.util.Scanner;
package com.company;

public class ProductOperations {
    public ArrayList<Product> GenerateProducts(int count){
        ArrayList <Product> product_array = new ArrayList<>();
        for(int i = 0; i < count ; i++) {
            Product product = new Product();
            product.id = i+1;
            product.amount = (int)(Math.random()* 100);
            product.date.day = (int)(Math.random()* 30);
            product.date.month= (int)(Math.random()* 12);
            product.date.year = (int)(Math.random()* 2019);
            product.cost = (double)Math.random()* 100;
            UserInput(product , i);
            product_array.add(product);
        }
        return product_array;
    }
    static Product UserInput(Product product, int i){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input name of product #" + i+": ");
        product.name = scanner.nextLine();
        System.out.println("Input producer of product #" + i+": ");
        product.producer = scanner.nextLine();
        return product;
    }
    public Product Stringbool(ArrayList <Product> array, String name) {
        boolean check = false;
        for (int i = 0; ; i++){
            Product product1 = null;
            if (array.get(i).name.equals(name)) {
                check = true;
            }
            if(check){
                return array.get(i);
            }
        }
    }
    public void CheckCost(Product product, double cost){
        if(product.cost <= cost) {
            System.out.println(product.toString());
        }
    }
    public void CheckDate(ArrayList <Product> array, Date date, int amount){
        long user_date;
        user_date = date.day + (date.month*30) + (date.year*365);
        for (int i = 0; i < amount ; i++){
            long product_date;
            product_date = array.get(i).date.day + (array.get(i).date.month*30) +
                    (array.get(i).date.year*365);
            if(product_date > user_date){
                System.out.println(array.get(i).toString());
            }
        }
    }
}