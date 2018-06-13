package com.scala.practice

object WeightUniformString {


  /*
   * Complete the weightedUniformStrings function below.
   */
  def weightedUniformStrings(s: String, queries: Array[Int]): Array[String] = {
    /*
     * Write your code here.
     */
    //val m :Map[Char,Int] = (('a' to 'z') zip (1 to 26)) toMap
    var chara = ' '
    var list = collection.mutable.ListBuffer[Int]()
    s foreach (ch => {
      var vl = ch.toInt % 96
      if (chara.equals(ch)) {
        list += list.last + vl
      } else {
        chara = ' '
        list += vl
      }
      chara = ch
    })
    queries.map(f => if (list.contains(f)) "Yes" else "No")
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    //val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val s = stdin.readLine

    val queriesCount = stdin.readLine.trim.toInt

    val queries = Array.ofDim[Int](queriesCount)

    for (queriesItr <- 0 until queriesCount) {
      val queriesItem = stdin.readLine.trim.toInt
      queries(queriesItr) = queriesItem}

    val result = weightedUniformStrings(s, queries)

    println(result.mkString("\n"))

    //printWriter.close()
  }

}
