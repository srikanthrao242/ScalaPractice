package com.scala.practice

import java.math.BigInteger

import scala.collection.immutable

object NonDivisibleSubset {
  /*
      * Complete the nonDivisibleSubset function below.
      */
  def nonDivisibleSubset(k: Int, S: Array[BigInteger]): Int = {
    /*
     * Write your code here.
     */


    val list = S.combinations(2).filter(a=>{
      var sum : BigInteger = new BigInteger("0")
      a.foreach(v=>{
        sum = sum.add(v)
      })
      var s: Array[BigInteger] = sum.divideAndRemainder(new BigInteger(k+""))
      sum.mod(new BigInteger(k+"")) != new BigInteger("0")
    }).flatten.toList
    list.groupBy(identity).foreach(v=>println(v._2.mkString(" ")))
    //list.groupBy(identity).filter(v => list.length % v._2.length == 0).foreach(v=>println(v._2.mkString(" ")))

    list.distinct.size
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

   // val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val S = stdin.readLine.split(" ").map(v=> new BigInteger(v.trim))
    val result = nonDivisibleSubset(k, S)

    println(result)

   /* printWriter.println(result)

    printWriter.close()*/
  }
}
