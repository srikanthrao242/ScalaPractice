package com.scala.practice

import scala.collection.mutable.ListBuffer

object ClimbingTheLeaderBoard {
  def climbingLeaderboard(scores: Array[Int], alice: Array[Int]): Array[Int] = {
    /*
     * Write your code here.
     */

    /*
    *
    *
    * 7
    100 100 50 40 40 20 10
    4
    5 25 50 120
    * */

    val list = scores.distinct.clone()

    alice.map(p=>{
      val z = ListBuffer(list: _ *)
      z += p
      z.sortWith(_>_).indexOf(p)+1
    })

  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    //val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val scoresCount = stdin.readLine.trim.toInt

    val scores = stdin.readLine.split(" ").map(_.trim.toInt)
    val aliceCount = stdin.readLine.trim.toInt

    val alice = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = climbingLeaderboard(scores, alice)

    println(result.mkString("\n"))

    //printWriter.close()
  }
}
