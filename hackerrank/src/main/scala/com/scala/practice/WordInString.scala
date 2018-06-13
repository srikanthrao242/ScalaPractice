package com.scala.practice

object WordInString {

  def hackerrankInString(s: String): String =  {
    // Complete this function


    /*2
hereiamstackerrank
hackerworld*/
    val str  = "hackerrank"
    var i = 0
    if(s.length > str.length)
      s.foreach(ch=>{
        if(i < str.length && ch == str.charAt(i)) i+=1
      })
    if(i == str.length || str == s) "YES" else "NO"
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var q = sc.nextInt();
    var a0 = 0;
    while(a0 < q){
      var s = sc.next();
      val result = hackerrankInString(s);
      println(result)
      a0+=1;
    }
  }

}
