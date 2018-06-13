package com.scala.practice

object HalloweenSale {
  // Complete the howManyGames function below.
  def howManyGames(p: Int, d: Int, m: Int, s: Int): Int = {
    // Return the number of games you can buy
    var a =0
    var count = 0
    while(a<s && count*d <= p){
      if(a==0) a += p
       else {
        count += 1
        if(p-(count*d) <= m) a += m
        else a += p-(count*d)
      }
    }
    count
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    //val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val pdms = stdin.readLine.split(" ")

    val p = pdms(0).trim.toInt

    val d = pdms(1).trim.toInt

    val m = pdms(2).trim.toInt

    val s = pdms(3).trim.toInt

    val answer = howManyGames(p, d, m, s)

    println(answer)
  }
}
