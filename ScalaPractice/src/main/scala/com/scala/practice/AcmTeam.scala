package com.scala.practice

object AcmTeam {

  def acmTeam(topic: Array[String]): Array[Int] =  {
    // Complete this function
    val arr: Array[Array[Int]] = topic.map(p=>p.toCharArray.map(v=> v.asDigit))

    val a = (1 to topic.length).combinations(2).map(p=> arr(p(0)-1).zip(arr(p(1)-1)).map { case (x, y) => x + y }.count(v=> v !=0)).toArray.groupBy(identity).map(p=> (p._1,p._2.length)).maxBy(p=>p._1)

    Array(a._1,a._2)

  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var m = sc.nextInt();
    var topic = new Array[String](n);
    for(topic_i <- 0 to n-1) {
      topic(topic_i) = sc.next();
    }
    val result = acmTeam(topic);
    println (result.mkString("\n"))


  }
}
