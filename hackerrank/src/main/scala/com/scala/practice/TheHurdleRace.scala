package com.scala.practice

object TheHurdleRace {

  def hurdleRace(k: Int, height: Array[Int]): Int =  {
    // Complete this function
    val diff = height.max-k
    if(diff < 0){
      0
    }else{
      diff
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var k = sc.nextInt();
    var height = new Array[Int](n);
    for(height_i <- 0 to n-1) {
      height(height_i) = sc.nextInt();
    }
    val result = hurdleRace(k, height);
    println(result)
  }

}
