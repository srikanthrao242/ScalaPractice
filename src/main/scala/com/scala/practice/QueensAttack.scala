package com.scala.practice

import scala.collection.mutable.ListBuffer

object QueensAttack {
  def queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array[Array[Int]]): Int =  {
    // Complete this function
    //val (c,q) = (n-r_q,c_q-1)
    val (r,c) = (n-r_q,c_q-1)

    println((r,c),n)

    var east: Seq[(Int, Int)] = (r until 0 by -1).map(v=>(v-1,c))
    var west: Seq[(Int, Int)] = (r until n-1).map(v=>(v+1,c))
    var north: Seq[(Int, Int)] = (c until 0 by -1).map(v=>(r,v-1))
    var south : Seq[(Int, Int)]= (c until n-1).map(v=>(r,v+1))
    var southEast: Seq[(Int, Int)] = (r-1 to 0 by -1).zip(c + 1 until n)
    var southWest: Seq[(Int, Int)] = (r+1 until n).zip(c + 1 until n)
    var northWest : Seq[(Int, Int)]= (r+1 until n).zip(c - 1 to 0 by -1)
    var northEast: Seq[(Int, Int)] = (r-1 to 0 by -1).zip(c - 1 to 0 by -1)

    println("east")
    east.foreach(v=>println(v))
    println()
    println("west")
    west.foreach(v=>println(v))
    println()
    println("north")
    north.foreach(v=>println(v))
    println()
    println("south")
    south.foreach(v=>println(v))
    println()
    println("southEast")
    southEast.foreach(v=>println(v))
    println()
    println("southWest")
    southWest.foreach(v=>println(v))
    println()
    println("northWest")
    northWest.foreach(v=>println(v))
    println()
    println("northEast")
    northEast.foreach(v=>println(v))
    println()

    if(obstacles.length > 0){
      obstacles.foreach(v=>{
        if(east.contains((n-v(0),v(1)-1))) east = Seq.empty[(Int,Int)]
        if(west.contains((n-v(0),v(1)-1))) west= Seq.empty[(Int,Int)]
        if(south.contains((n-v(0),v(1)-1))) south= Seq.empty[(Int,Int)]
        if(north.contains((n-v(0),v(1)-1))) north = Seq.empty[(Int,Int)]
        if(southEast.contains((n-v(0),v(1)-1))) southEast = Seq.empty[(Int,Int)]
        if(southWest.contains((n-v(0),v(1)-1))) southWest = Seq.empty[(Int,Int)]
        if(northEast.contains((n-v(0),v(1)-1))) northEast = Seq.empty[(Int,Int)]
        if(northWest.contains((n-v(0),v(1)-1))) northWest = Seq.empty[(Int,Int)]
      })
    }
    east.size+west.size+north.size+south.size+southEast.size+southWest.size+northEast.size+northWest.size
   /* val arr = (0 until n).flatMap(i=>(0 until n).map(j=> Array(i,j) ))

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

    listBuffer.count(p=>obstacles.forall(v => v.deep != p.deep))*/
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
