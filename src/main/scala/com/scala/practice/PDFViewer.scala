package com.scala.practice

object PDFViewer {
  def designerPdfViewer(h: Array[Int], word: String): Int =  {
    // Complete this function
    val map = (('a' to 'z').toList zip h.toList).toMap

    word.toLowerCase().map(ch=>map(ch)).max * word.length
  }

  def main(args: Array[String]) {
    val sc = new java.util.Scanner (System.in);
    var h = new Array[Int](26);
    for(h_i <- 0 to 26-1) {
      h(h_i) = sc.nextInt();
    }
    var word = sc.next();
    val result = designerPdfViewer(h, word);
    println(result)
  }

}
