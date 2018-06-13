package com.scala.practice

import java.math.BigInteger

object RepeatedString {
  def repeatedString(s: String, n: Long): Long =  {
    // Complete this function
    val bigN = new BigInteger(n.toString)
    val repeatStr = new BigInteger((n/s.length).toString)
    println(n)
    if(s.length ==1 && s.charAt(0) == 'a') n
    else if(s.length ==1 && s.charAt(0) != 'a') 0.toLong
    else{
      var acount = repeatStr.multiply(new BigInteger(s.count(p=>p=='a').toString))

     // acount += s.substring(0, (n % repeatStr.intValue()).toInt).count(p=>p=='a')
      acount.intValueExact()
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var s = sc.next();
    var n = sc.nextLong();
    val result = repeatedString(s, n);
    println(result)
  }
}
