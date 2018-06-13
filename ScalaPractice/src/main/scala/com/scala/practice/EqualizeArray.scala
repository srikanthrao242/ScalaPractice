package com.scala.practice

object EqualizeArray {

  def equalizeArray(arr: Array[Int]): Int =  {
    // Complete this function
    arr.length - arr.groupBy(identity).maxBy(_._2.length)._2.length
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var arr = new Array[Int](n);
    for(arr_i <- 0 to n-1) {
      arr(arr_i) = sc.nextInt();
    }
    val result = equalizeArray(arr);
    println(result)
  }
}
