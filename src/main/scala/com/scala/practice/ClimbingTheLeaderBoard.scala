package com.scala.practice

import scala.annotation.tailrec

object ClimbingTheLeaderBoard {


  @tailrec
  def findRankRec(list: Seq[Int], score:Int, index: Int):Int ={
    val span: (Seq[Int], Seq[Int]) = list.span(_ == list.head)
    span match {
      case (head::_, _) if head == score =>
        index
      case (_, left) => findRankRec(left, score, index + 1)
      case (Nil, Nil) => index
    }
  }

  def findRank(scores:List[Int], i:Int): Int ={
    val list = ( i:: scores ).sorted(Ordering.Int.reverse)
    findRankRec(list, i,1)
  }

  // Complete the climbingLeaderboard function below.
  def climbingLeaderboard(scores: Array[Int], alice: Array[Int]): Array[Int] = {
    val list = scores.toList
    alice.map(score => findRank(list, score))
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
