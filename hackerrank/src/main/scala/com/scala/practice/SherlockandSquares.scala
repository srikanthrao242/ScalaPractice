package com.scala.practice

object SherlockandSquares {
  def squares(a: Int, b: Int): Int =  {
    // Complete this function
    (math.floor(math.sqrt(b))-math.ceil(math.sqrt(a))+1).toInt
    /*(a to b).count(p=>{
      val sqrt = math.sqrt(p)
      sqrt % 1 == 0

    })*/
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var q = sc.nextInt();
    var a0 = 0;
    while(a0 < q){
      var a = sc.nextInt();
      var b = sc.nextInt();
      val result = squares(a, b);
      println(result)
      a0+=1;
    }
  }
}
