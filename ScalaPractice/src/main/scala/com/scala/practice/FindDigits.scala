package com.scala.practice

object FindDigits {
  def findDigits(n: Int): BigInt =  {
    // Complete this function
    //n.toString.map(v=>println(v.toString.toInt))
    n.toString.count(c => c!='0' && n % c.toString.toInt == 0)
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var t = sc.nextInt();
    var a0 = 0;
    while(a0 < t){
      var n = sc.nextInt();
      val result = findDigits(n);
      println(result)
      a0+=1;
    }
  }
}
