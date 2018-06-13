package com.scala.practice

object Anagrams {
  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var a = sc.next();
    var b = sc.next();

    val str = a.intersect(b)

    a.length- str.length + b.length- str.length
  }
}
