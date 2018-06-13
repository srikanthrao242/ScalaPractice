package com.scala.practice

import scala.collection.mutable.ListBuffer

object CutTheSticks {
  def cutTheSticks(arr: Array[Int]): Array[Int] =  {
    // Complete this function
    var temp = arr.clone()
    var result = scala.collection.mutable.ListBuffer[Int]()
    result += temp.length
    while(!temp.isEmpty)
      {
        var f_arr =  temp.filter(v=> v-temp.min != 0)
        if(f_arr.length > 0)
          result += f_arr.length
        temp = f_arr
      }
    result.toArray
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var arr = new Array[Int](n);
    for(arr_i <- 0 to n-1) {
      arr(arr_i) = sc.nextInt();
    }
    val result = cutTheSticks(arr);
    println (result.mkString("\n"))


  }
}
