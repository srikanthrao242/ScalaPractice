package com.scala.practice

object SmallestPositiveInt {
  def solution(a: Array[Int]): Int = {
    // write your code in Scala 2.12
    val res = (a.min to  a.max).diff(a.distinct)
    if(res.isEmpty) a.max+1
    else if(res.min < 0) 1 else res.min
  }
  def main(args:Array[String]): Unit ={
    var a = Array(1,2,3)
    println(this.solution(a))
  }
}
