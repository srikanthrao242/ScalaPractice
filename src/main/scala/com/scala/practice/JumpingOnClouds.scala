package com.scala.practice

object JumpingOnClouds {
  def jumpingOnClouds(c: Array[Int]): Int =  {
    // Complete this function

    val pivot = if(c.length % 2 == 0) c.length/2 else (c.length + 1)/2

    pivot
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var c = new Array[Int](n);
    for(c_i <- 0 to n-1) {
      c(c_i) = sc.nextInt();
    }
    val result = jumpingOnClouds(c);
    println(result)
  }
}
