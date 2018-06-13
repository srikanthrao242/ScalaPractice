package com.scala.practice

import scala.annotation.tailrec

object BinaryGap {
  var count = 0

  def countZeros(n:Int, bin:List[Int],bin1:List[Int]): Unit ={
    val r = n % 2
    val q = n / 2
    println(r,q,n)
    if(r == 1 || n == 1){
      if(count < bin.length && bin1.size == 2) {
        bin.foreach(println(_))
        println()
        count = bin.length
      }
    }
    if(n!= 1){
      if(r == 1) {
        if(bin1.size == 2)
          countZeros(q,List[Int](),List[Int]())
        else
          countZeros(q,List[Int](),r::bin1)
      }
      else countZeros(q,r::bin,bin1)
    }
  }
  def solution(n: Int): Int = {
    // write your code in Scala 2.12
    countZeros(n,List[Int](),List[Int]())
    count
  }

  def main(args: Array[String]): Unit = {
    println(solution(5))
  }
}
