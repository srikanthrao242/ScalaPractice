package com.scala.practice

object AppendandDelete {
  def appendAndDelete(s: String, t: String, k: Int): String =  {
    // Complete this function

    val commonLength = s.zip(t).takeWhile(p=> p._1 == p._2).length

    //val commonfirt = s.takeWhile(p=>)
    if((s.length+t.length-2*commonLength)>k){
      "No"
    }else if((s.length+t.length-2*commonLength)%2==k%2){
      "Yes"
    }else if((s.length+t.length-k)<0){
      "Yes"
    }else{
      "No"
    }
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var s = sc.next();
    var t = sc.next();
    var k = sc.nextInt();
    val result = appendAndDelete(s, t, k);
    println(result)
  }
}
