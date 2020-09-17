package com.scala.practice

import java.math.BigInteger

import scala.collection.immutable
import scala.collection.mutable.ListBuffer

object NonDivisibleSubset {

  def sublistWithNonDiv(k:Int, h:Long, list:List[Long]): List[Long] ={
    for{
      a <- list
      if (h + a) % k != 0
    } yield a
  }

  def listOfSubLists(k:Int, list:List[Long], result:List[List[Long]], size:Int): Int ={
    list match {
      case a :: tail =>
        val re = a :: sublistWithNonDiv(k,a,tail)
        println(re.distinct, re.distinct.size)
        val s = if (re.size > size) {re.size} else {size}
        listOfSubLists(k, tail, re::result, s)
      case Nil => size
    }
  }

  def nonDivisibleSubset(k: Int, s: Array[Long]): Int = {
    // Write your code here
    listOfSubLists(k, s.toList, Nil, 0)
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

   // val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val S = stdin.readLine.split(" ").map(v=> v.trim.toLong)
    val result = nonDivisibleSubset(k, S)

    println(result)

   /* printWriter.println(result)

    printWriter.close()*/
  }
}
