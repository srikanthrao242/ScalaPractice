package com.scala.practice

object SaveThePrisoner {
  def saveThePrisoner(n: Int, m: Int, s: Int): Int = { // Complete this function
    val a = s + m - 1
    if (a > n) {
      if (a % n == 0) return n
      return a % n
    }
    a
  }
  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var t = sc.nextInt();
    var a0 = 0;
    while(a0 < t){
      var n = sc.nextInt();
      var m = sc.nextInt();
      var s = sc.nextInt();
      println(saveThePrisoner(n,m,s))
      a0+=1;
    }
  }
}
