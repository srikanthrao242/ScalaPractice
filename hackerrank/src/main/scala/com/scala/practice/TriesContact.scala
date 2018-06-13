package com.scala.practice

import scala.collection.mutable.ListBuffer

object TriesContact {

  def find(list: ListBuffer[String],find:String) :Int={
    list.count(p=>p.startsWith(find))
  }
  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var a0 = 0;
    val list = ListBuffer[String]()
    while(a0 < n){
      var op = sc.next();
      var contact = sc.next();
      if(op.equals("add")){
        list += contact
      }else{
        println(find(list,contact))
      }
      a0+=1;
    }


  }
}
