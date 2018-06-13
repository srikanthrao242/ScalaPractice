package com.scala.practice;

import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}
public class LinkedNode {
    public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static  Node insert(Node head, int data){
        Node node = new Node(data);

        if(head == null){
            return node;
        }else{
            Node start = head;
            while(start != null) {
                if(start.next == null){
                    start.next = node;
                    break;
                }else{
                    start = start.next;
                }
            }
            return head;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}
