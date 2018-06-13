package com.scala.practice

object PickingNumbers {
  def pickingNumbers(a: Array[Int]): Int =  {
    // Complete this function
    val sizes = a.groupBy(identity).mapValues(_.length)
    if(a.distinct.length > 1)
      a.sorted.sliding(2).filter(p=>p(1)-p(0) <= 1).map(p=>{
        if(p(0) == p(1))
          sizes(p(0))
        else
          sizes(p(0))+sizes(p(1))
      }).max
    else a.length
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var a = new Array[Int](n);
    for(a_i <- 0 to n-1) {
      a(a_i) = sc.nextInt();
    }
    val result = pickingNumbers(a);
    println(result)
  }
}
