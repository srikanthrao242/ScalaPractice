package com.scala.practice

object CakeWalk {

  def marcsCakewalk(calorie: Array[Int]): Unit =  {
    // Complete this function

  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var calorie = new Array[Int](n);
    for(calorie_i <- 0 to n-1) {
      calorie(calorie_i) = sc.nextInt();
    }
    val result = marcsCakewalk(calorie);
    println(result)
  }

}
