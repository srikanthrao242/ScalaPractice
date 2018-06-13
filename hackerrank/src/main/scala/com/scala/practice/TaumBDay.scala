package com.scala.practice

object TaumBDay {

  /*
   * Complete the taumBday function below.
   */
  def taumBday(b: Int, w: Int, bc: Int, wc: Int, z: Int): Long = {
    /*
     * Write your code here.
     */
    var (x,y) = (bc,wc)
    /*10
71805 9169
905480 255669 334440
56399 55940
594189 471473 231368
15994 44048
874583 375348 332432
10269 66173
512771 387924 613661
31470 73137
999563 625186 287011
33416 87228
357232 567986 517178
34394 39790
142699 939873 995458
77138 96271
851397 71326 484096
99116 87319
228143 473698 879018
76926 319
945190 589696 288242*/

   /* x = if(x>y) if (x - y > z) y + z else x else x

    y = if(y>x) if (y - x > z) x + z else y else y
*/

    x = if(y+z < x)  y+z else x
    y = if(x+z < y)  x+z else y
    (b*x).toLong+(w*y).toLong
  }

  def main(args: Array[String]) {
 /*   val stdin = scala.io.StdIn

   // val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val t = stdin.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val bw = stdin.readLine.split(" ")

      val b = bw(0).trim.toInt

      val w = bw(1).trim.toInt

      val bcWcz = stdin.readLine.split(" ")

      val bc = bcWcz(0).trim.toInt

      val wc = bcWcz(1).trim.toInt

      val z = bcWcz(2).trim.toInt

      //val result = taumBday(b, w, bc, wc, z)

      //println(result)


    }*/
    var a = (3 to 9).filter(f=>{
      f%2 != 0
    }).toArray

    var d = 4

    while(d>0){



    }

    var (before, after) = a.splitAt(a.length-1)

    (after++before).mkString(" ")
    //printWriter.close()
  }
}
