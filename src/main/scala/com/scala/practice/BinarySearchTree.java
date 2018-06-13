package com.scala.practice;


import java.util.Scanner;

public class BinarySearchTree {
    public static Nodes insert(Nodes root,int data){
        if(root==null){
            return new Nodes(data);
        }
        else{
            Nodes cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        Nodes root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
    private static int getHeight(Nodes root){
        if (null == root)
            return 0;
        int hLeftSub = getHeight(root.left);
        int hRightSub = getHeight(root.right);
        return Math.max(hLeftSub, hRightSub) + 1;
    }
}
class Nodes{
    Nodes left,right;
    int data;
    Nodes(int data){
        this.data=data;
        left=right=null;
    }
}
