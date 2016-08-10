
/**
  * Created by mpomaran on 2016-07-01.
  */
object Main {
 def main(args: Array[String]):Unit = {
   println("Your pass:")
   val pass = scala.io.StdIn.readLine()
   println("blanks:")
   val blanks: String = scala.io.StdIn.readLine()
   val tuples: Array[(Int, Int)] = blanks.split(" ").map(s => {
     if (!s.contains("-")) (s.toInt, 1)
     else {
       val splitt = s.split("-")
       (splitt(0).toInt, splitt(1).toInt)
     }
   })

   val indexes: List[Int] = tuples.foldLeft(List[Int]())((acc, tuple) => {
     if (tuple._2 > 1) acc ++ (tuple._1 until (tuple._1 + tuple._2))
     else acc :+ tuple._1
   })

   val result = pass.zipWithIndex.map { case (c, i) =>
       if (indexes.contains(i+1)) c
       else "_"
   }.mkString("")
   println(result)
 }
}
