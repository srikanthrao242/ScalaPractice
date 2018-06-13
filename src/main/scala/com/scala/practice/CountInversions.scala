package com.scala.practice

object CountInversions {

  var count = 0

  def countInversions(arr: Array[Int]): Long =  {
    // Complete this function
    mergeSort(arr.toList)
    count
  }

  def mergeSort(xs: List[Int]): List[Int] = {
    val n = xs.length / 2
    println(xs.mkString(" "))

    println()
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]): List[Int] =
        (xs, ys) match {
          case(Nil, ys) => ys
          case(xs, Nil) => xs
          case(x :: xs1, y :: ys1) =>
            if (x!=y && x < y) {
              count += 1
              x::merge(xs1, ys)
            }else {
              count += 1
              y :: merge(xs, ys1)
            }

        }
      val (left, right) = xs splitAt(n)
      merge(mergeSort(left), mergeSort(right))
    }
  }


  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var t = sc.nextInt();
    var a0 = 0;
    while(a0 < t){
      var n = sc.nextInt();
      var arr = new Array[Int](n);
      for(arr_i <- 0 to n-1) {
        arr(arr_i) = sc.nextInt();
      }
      count = 0
      val result = countInversions(arr);
      println(result)
      a0+=1;
    }
  }
}
