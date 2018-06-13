package com.scala.practice

object LibraryFine {
  def libraryFine(d1: Int, m1: Int, y1: Int, d2: Int, m2: Int, y2: Int): Int =  {
    // Complete this function
    val yd = math.abs(y2-y1)
    val md = math.abs(m2-m1)
    val dd = math.abs(d2-d1)
    if(yd > 0)  10000
    else if(yd == 0 && md > 0) 500 * md
    else if(yd == 0 && md == 0 && dd > 0) 15 * dd
    else 0
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var d1 = sc.nextInt();
    var m1 = sc.nextInt();
    var y1 = sc.nextInt();
    var d2 = sc.nextInt();
    var m2 = sc.nextInt();
    var y2 = sc.nextInt();
    val result = libraryFine(d1, m1, y1, d2, m2, y2);
    println(result)
  }
}
