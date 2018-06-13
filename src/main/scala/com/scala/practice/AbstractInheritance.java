package com.scala.practice;

import java.util.Arrays;

public class AbstractInheritance {

    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();*/

        Book book = new MyBook("","", 2);
        book.display();
    }
}

class MyBook extends Book{

    int Price ;

    MyBook(String title, String author,int price) {
        super(title, author);
        this.Price = price;
    }



    @Override
    void display() {

        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Price: "+Price);
    }
    void computeDifference(){
        int[] tab = {12, 1, 21, 8};
        Arrays.sort(tab);
        int min =tab[0];
        System.out.println(min);
        int max= tab[tab.length-1];
        System.out.println(max);
        System.out.println(max-min);
    }

}
abstract class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    abstract void display();
}
