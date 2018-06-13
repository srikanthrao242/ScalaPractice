package com.scala.practice

object BetweenTwoSets {
  /*
     * Complete the getTotalX function below.
     */
  def getTotalX(a: Array[Int], b: Array[Int]): Int = {
    /*
     * Write your code here.
     */

    (a.last to  b(0)).filter(p=> a.forall( v=>p%v == 0)).filter(p=>b.forall( v1=>v1%p == 0)).foreach(println)

    (a.last to  b(0)).filter(p=> a.forall( v=>p%v == 0)).count(p=>b.forall( v1=>v1%p == 0))
  }

  def main(args: Array[String]) {
    val scan = scala.io.StdIn

   // val fw = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nm = scan.readLine.split(" ")

    val n = nm(0).trim.toInt

    val m = nm(1).trim.toInt

    val a = scan.readLine.split(" ").map(_.trim.toInt)

    val b = scan.readLine.split(" ").map(_.trim.toInt)
    val total = getTotalX(a, b)

    println(total)

    //fw.close()
  }
}
