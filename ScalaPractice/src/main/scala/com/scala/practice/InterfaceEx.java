package com.scala.practice;

import java.io.*;
import java.util.*;

interface AdvancedArithmetic{
    int divisorSum(int n);
}
public class InterfaceEx {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

       // AdvancedArithmetic myCalculator = new Calculator();
       // int sum = myCalculator.divisorSum(n);
       /* System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);*/
    }
}
class printer<T>{
    public void printArray(T[] arr){
        for (T item : arr) {
            System.out.println(item);
        }
    }
}
class myCalculator/* extends*/ /*AdvancedArithmetic*/ {

   // @Override
    public int divisorSum(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n+1; ++i) {
            a[i] = i;
        }
        return 0;
    }
}