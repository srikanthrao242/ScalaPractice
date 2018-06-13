package com.scala.practice

object Grading_System {

  /*
   * Complete the gradingStudents function below.
   */
  def gradingStudents(grades: Array[Int]): Array[Int] = {
    /*
     * Write your code here.
     */
    var list = scala.collection.mutable.ListBuffer[Int]()

    grades.foreach(grade=>{
      val next5 = grade+(5-(grade%5))
      if(grade < 38){
        list += grade
      }else if(next5-grade < 3){
        list += next5
      }else{
        list += grade
      }
    })
    list.toArray
  }

  def main(args: Array[String]) {
    val scan = scala.io.StdIn

   // val fw = new PrintWriter(sys.env("OUTPUT_PATH"))

    val n = scan.readLine.trim.toInt

    val grades = Array.ofDim[Int](n)

    for (gradesItr <- 0 until n) {
      val gradesItem = scan.readLine.trim.toInt
      grades(gradesItr) = gradesItem}

    val result = gradingStudents(grades)

    result.foreach(println(_))

    /*fw.println(result.mkString("\n"))

    fw.close()*/
  }

}
