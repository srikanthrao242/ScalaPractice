package com.scala.practice

object Pangrams {
  /*
   * Complete the pangrams function below.
   */
  def pangrams(s: String): String = {
    /*
     * Write your code here.
     */
    val alphabets = ('a' to 'z').toSet
    val str = s.trim.toLowerCase.replaceAll(" +", "").toCharArray.distinct
    if(alphabets.subsetOf(str.toSet)) "pangram" else "not pangram"
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

   // val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val s = stdin.readLine

    val result = pangrams(s)

    println(result)

    //printWriter.close()
  }
}
