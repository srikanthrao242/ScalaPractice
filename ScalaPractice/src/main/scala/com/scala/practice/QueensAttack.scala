package com.scala.practice

import scala.collection.mutable.ListBuffer

object QueensAttack {
  def queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array[Array[Int]]): Int =  {
    // Complete this function
    val (c,q) = (n-r_q,c_q-1)

    val arr = (0 until n).flatMap(i=>(0 until n).map(j=> Array(i,j) ))

    var listBuffer = new ListBuffer[Array[Int]]()

    listBuffer ++= arr.filter(v=> v.sum == c+q).toList
    if(c<q){
      listBuffer ++= arr.filter(p => p(0) < p(1) && math.abs(p(0)-p(1)) == math.abs(c-q))
    }else if(c > q){
      listBuffer ++= arr.filter(p => p(0) > p(1) && math.abs(p(0)-p(1)) == math.abs(c-q))
    }else{
      listBuffer ++= arr.filter(p => p(0) == p(1) && math.abs(p(0)-p(1)) == math.abs(c-q))
    }

    listBuffer ++= (0 until n).map(v=>Array(c,v))
    listBuffer ++= (0 until n).map(v=>Array(v,q))

    listBuffer = listBuffer.filter(p=> p.deep != Array(c,q).deep)

    listBuffer.foreach(f=>println(f.mkString("  ")))

    println()

    listBuffer.count(p=>obstacles.forall(v => v.deep != p.deep))
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var k = sc.nextInt();
    var r_q = sc.nextInt();
    var c_q = sc.nextInt();
    var obstacles = Array.ofDim[Int](k,2);
    for(obstacles_i <- 0 to k-1) {
      for(obstacles_j <- 0 to 2-1){
        obstacles(obstacles_i)(obstacles_j) = sc.nextInt();
      }
    }
    val result = queensAttack(n, k, r_q, c_q, obstacles);
    println(result)
  }
}
