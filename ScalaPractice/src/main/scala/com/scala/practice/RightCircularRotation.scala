package com.scala.practice

import scala.collection.mutable

object RightCircularRotation {

  def circularArrayRotation(a: Array[Int], m: Array[Int]): Array[Int] =  {
    // Complete this function
    var temp = a
    var loop = true
    while(loop){
      val (front, back) = temp.splitAt(temp.length-1)
      val m_a = back ++ front
      if(a.deep == m_a.deep)
        loop = false
      else
        temp = m_a
    }
    m.map(i=>temp(i))
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var k = sc.nextInt();
    var q = sc.nextInt();
    var a = new Array[Int](n);
    for(a_i <- 0 to n-1) {
      a(a_i) = sc.nextInt();
    }
   // var m = new Array[Int](q);
    for(m_i <- 0 to q-1) {
      val m = sc.nextInt();
      println(a((n - (k % n)+ m) % n))
    }
    /*val result = circularArrayRotation(a, m);
    println (result.mkString("\n"))*/

/*

    for(int a0 = 0; a0 < q; a0++){
      int m = in.nextInt();
      System.out.println(a[(n - (k % n)+ m) % n]);
    }
*/


  }
}
