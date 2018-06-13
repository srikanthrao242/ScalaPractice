package com.scala.practice

import scala.collection.immutable

object NonDivisibleSubset {
  /*
      * Complete the nonDivisibleSubset function below.
      */
  def nonDivisibleSubset(k: Int, S: Array[Int]): Int = {
    /*
     * Write your code here.
     */
    val list = S.combinations(2).filter(a=> BigInt(a.sum) % k != 0).flatten.toList
    list.foreach(println)
    println("============================")
    list.groupBy(identity).foreach(v=>println(v._2.mkString(" ")))
    //list.groupBy(identity).filter(v => list.length % v._2.length == 0).foreach(v=>println(v._2.mkString(" ")))
    1
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

   // val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val S = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = nonDivisibleSubset(k, S)

    println(result)

   /* printWriter.println(result)

    printWriter.close()*/
  }
}
