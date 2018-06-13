package com.scala.practice

import scala.collection.mutable


sealed trait NodeV[A] {
  def head: A
  def index : (Int,Int)
  var next: mutable.HashMap[(Int,Int),NodeV[A]]
  var isVisit : Boolean
}
case class CreateNode[A] (headv: A, indexV:(Int,Int),
                          override var isVisit:Boolean = false,
                          override var next: mutable.HashMap[(Int,Int),NodeV[A]] = new  mutable.HashMap[(Int,Int),NodeV[A]]()) extends NodeV[A] {
  override def head: A = headv
  override def index : (Int,Int) = indexV
}
class Graph[A](tunnels:Map[(Int,Int),(Int,Int)],arr:Array[Array[A]]){

  var NumberOfPaths : Int = 0
  var listOfNodes:  mutable.HashMap[(Int,Int),NodeV[A]] = new  mutable.HashMap[(Int,Int),NodeV[A]]()
  var source : (Int,Int) = _
  def convertArrToGraph(): Unit ={
    arr.indices.foreach(i=>{
      arr(i).indices.foreach(j=>{
        if(arr(i)(j) == 'A') source = (i,j)
        if(arr(i)(j) != '*' && arr(i)(j) != '#') {
          var node: NodeV[A] = CreateNode(arr(i)(j), (i, j))
          if (!listOfNodes.contains((i, j))) {
            listOfNodes += ((i, j) -> node)
          } else {
            node = listOfNodes((i, j))
          }

          if (i - 1 >= 0)
            if (listOfNodes.contains((i - 1, j))) {
              this.addEdge(node, listOfNodes((i - 1, j)), i - 1, j)
            } else {
              if(arr(i-1)(j) != '*' && arr(i-1)(j) != '#') {
                val c_node = CreateNode(arr(i - 1)(j), (i - 1, j))
                listOfNodes += ((i - 1, j) -> c_node)
                this.addEdge(node, c_node, i - 1, j)
              }
            }

          if (i + 1 < arr.length)
            if (listOfNodes.contains((i + 1, j))) {
              this.addEdge(node, listOfNodes((i + 1, j)), i + 1, j)
            } else {
              if(arr(i+1)(j) != '*' && arr(i+1)(j) != '#') {
                val c_node = CreateNode(arr(i + 1)(j), (i + 1, j))
                listOfNodes += ((i + 1, j) -> c_node)
                this.addEdge(node, c_node, i + 1, j)
              }
            }

          if (j - 1 >= 0)
            if (listOfNodes.contains((i, j - 1))) {
              this.addEdge(node, listOfNodes((i, j - 1)), i, j - 1)
            } else {
              if(arr(i)(j-1) != '*' && arr(i)(j-1) != '#') {
                val c_node = CreateNode(arr(i)(j - 1), (i, j - 1))
                listOfNodes += ((i, j - 1) -> c_node)
                this.addEdge(node, c_node, i, j - 1)
              }
            }

          if (j + 1 < arr(i).length)
            if (listOfNodes.contains((i, j + 1))) {
              this.addEdge(node, listOfNodes((i, j + 1)), i, j + 1)
            } else {
              if(arr(i)(j+1) != '*' && arr(i)(j+1) != '#') {
                val c_node = CreateNode(arr(i)(j + 1), (i, j + 1))
                listOfNodes += ((i, j + 1) -> c_node)
                this.addEdge(node, c_node, i, j + 1)
              }
            }
        }
      })
    })
  }
  def shortestPath(source:NodeV[A]): Unit ={
    if(!source.isVisit)
      for(node<- source.next){
        if(node._2.head == '%'){
          NumberOfPaths += 1
          return
        }else if(tunnels.contains(node._2.index)){
          shortestPath(listOfNodes(tunnels(node._2.index)))
        }else
          shortestPath(node._2)
      }
    source.isVisit = true
  }

  def DFS(start: NodeV[A]): List[NodeV[A]] = {

    def DFS0(v: NodeV[A], visited: List[NodeV[A]]): List[NodeV[A]] = {

      if (visited.contains(v))
        visited
      else {
        val neighbours:List[NodeV[A]] = v.next.values.toList filterNot visited.contains
        neighbours.foldLeft(v :: visited)((b,a) => DFS0(a,b))
      }
    }
    DFS0(start,List()).reverse
  }

  def BFS(start:  NodeV[A]): List[List[NodeV[A]]] = {

    def BFS0(elems: List[NodeV[A]],visited: List[List[NodeV[A]]]): List[List[NodeV[A]]] = {
      val newNeighbors = elems.flatMap(v=>v.next.values).filterNot(visited.flatten.contains).distinct
      if (newNeighbors.isEmpty)
        visited
      else
        BFS0(newNeighbors, newNeighbors :: visited)
    }

    BFS0(List(start),List(List(start))).reverse
  }
  def addEdge(v1:NodeV[A],v2:NodeV[A],i:Int,j:Int): Unit ={
    v1.next +=((i,j) -> v2)
  }

}


object FrogInMage {

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val nmk = stdin.readLine.split(" ")

    val n = nmk(0).trim.toInt

    val m = nmk(1).trim.toInt

    val k = nmk(2).trim.toInt
    var arr = Array.ofDim[Char](n,m)
    for (nItr <- 1 to n) {
      val row = stdin.readLine
      arr(nItr-1) = row.toCharArray
      // Write Your Code Here
    }
    var tunnels = Map[(Int,Int),(Int,Int)]()
    for (kItr <- 1 to k) {
      val i1J1I2J2 = stdin.readLine.split(" ")

      val i1 = i1J1I2J2(0).trim.toInt-1

      val j1 = i1J1I2J2(1).trim.toInt-1

      val i2 = i1J1I2J2(2).trim.toInt-1

      val j2 = i1J1I2J2(3).trim.toInt-1

      tunnels += ((i1,j1)->(i2,j2))

      // Write Your Code Here
    }

    val graph = new Graph[Char](tunnels, arr)

    graph.convertArrToGraph()

    var source = graph.listOfNodes(graph.source)


    graph.listOfNodes.foreach(n=>{
      print(n._1+" ")
      n._2.next.foreach(v=>print(v._1+" "+v._2.head))
      println()
    })

    println()
    graph.BFS(source).foreach(v=>{
      v.foreach(v1=>{
        print(v1.head+" ")
      })
      println()
    })

    //println(graph.NumberOfPaths.toFloat/source.next.keySet.size)



    // Write Your Code Here
  }
}
