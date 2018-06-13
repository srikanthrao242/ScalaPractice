package com.scala.practice

object MergeSortEx {

  import java.util

  var swapCount = 0
  var compCount = 0

  def mergeSort(a: Array[Int], howMany: Int): Unit = { //Since merge sort begins here you may initiliaze the variables here
    swapCount = 0
    compCount = 0
    if (a.length >= 2) {
      val left = util.Arrays.copyOfRange(a, 0, a.length / 2)
      val right = util.Arrays.copyOfRange(a, a.length / 2, a.length)
      mergeSort(left, howMany)
      mergeSort(right, howMany)
      merge(a, left, right)
    }
  }

  def merge(result: Array[Int], left: Array[Int], right: Array[Int]): Unit = {
    var i1 = 0
    var i2 = 0
    var i = 0
    while ( {
      i < result.length
    }) {
      compCount += 1
      if (i2 >= right.length || (i1 < left.length && left(i1) <= right(i2))) {
        result(i) = left(i1) // take from left

        i1 += 1
        swapCount += 1
      }
      else {
        result(i) = right(i2) // take from right

        i2 += 1
        swapCount += 1
      }

      {
        i += 1; i - 1
      }
    }
  }

}
