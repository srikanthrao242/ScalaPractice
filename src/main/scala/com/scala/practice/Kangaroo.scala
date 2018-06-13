package com.scala.practice

object Kangaroo {


  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var x1 = sc.nextInt();
    var v1 = sc.nextInt();
    var x2 = sc.nextInt();
    var v2 = sc.nextInt();
    var result = "NO"
    import scala.util.control.Breaks._

    breakable{
      (0 to 10000).foreach(f=>{
        if(x1+v1 == x2+v2){
          result = "Yes"
          break
        }
        x1 += v1
        x2 += v2
      })
    }

    println(result)


  }

}
