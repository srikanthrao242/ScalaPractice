package com.scala.practice

object TheTimeINWords {
  // Complete the timeInWords function below.
  def timeInWords(h: Int, m: Int): String = {
    var numbers = Array[String](
      "zero",
      "one",
      "two",
      "three",
      "four",
      "five",
      "six",
      "seven",
      "eight",
      "nine",
      "ten",
      "eleven",
      "twelve",
      "thirteen",
      "fourteen",
      "quarter",
      "sixteen",
      "seventeen",
      "eighteen",
      "nineteen",
      "twenty",
      "twenty one",
      "twenty two",
      "twenty three",
      "twenty four",
      "twenty five",
      "twenty six",
      "twenty seven",
      "twenty eight",
      "twenty nine",
      "half"
    )
    var min_str = ""
    if(m>30){
      min_str = numbers(60-m) +" minutes to "+ numbers(h+1)
      if(60-m == 15) min_str = "quarter to "+numbers(h+1)
    }else if(m == 30){
      min_str = "half past "+ numbers(h)
    }else if(m == 0){
      min_str =  numbers(h)+" o' clock"
    }else{
      min_str = numbers(m)+" minutes past "+ numbers(h)
      if(m == 15) min_str = "quarter past "+ numbers(h)
      if(m == 1) min_str = numbers(m)+" minute past "+ numbers(h)
    }
    min_str
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    //val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val h = stdin.readLine.trim.toInt

    val m = stdin.readLine.trim.toInt

    val result = timeInWords(h, m)

    println(result)

    //printWriter.close()
  }
}
