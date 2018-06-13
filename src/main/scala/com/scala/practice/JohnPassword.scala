package com.scala.practice

object JohnPassword {
  def solution(s: String): Int = {
    // write your code in Scala 2.12
    val res = s.inits.flatMap(_.tails.toList.init).filter(p=>p.forall(c=>p.count(_==c) % 2 == 0))
      if(res.isEmpty) 0
      else res.maxBy(_.length).length
  }

  def main(args: Array[String]): Unit = {
    println(this.solution("abca"))
  }
}
