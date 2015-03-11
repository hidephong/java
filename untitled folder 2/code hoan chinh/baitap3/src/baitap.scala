/**
 * Created by tuanna on 5/19/14.
 */
import scala.io.Source
import java.io._
import scala.collection.mutable
import collection.mutable.ListMap


object baitap {
  val words  = mutable.Set.empty[String]
  val counts = mutable.Map.empty[String, Int]
  ListMap map
  def main(args: Array[String]) {
   time{ readFileByScala(args(0)) }
   time{ writeToFile(args(1)) }
  }


def readFileByScala(filename:String) {
  val fileName = filename
  val bufferSource = Source.fromFile(fileName)
  for (line <- bufferSource.getLines) {
      countWords(line)
     //map.keys.foreach{ i =>
     // print( "Key = " + i )
     // println(" Value = " + i )}
//   val wordsArray = line.split("[!,.()‘\"\'\\]\\[\\s+]+")
//
//   for (word <- wordsArray)  {
//     // countWords(word)
//     // map(word)
//      words += word.toLowerCase
//     println(word)
//    }
  }
 map = counts.toSeq.sortWith(_._1 < _._1)

  bufferSource.close
}

def writeToFile(filename:String) {
  val fileName = filename
  val pw = new BufferedWriter(new FileWriter(fileName))

  map.keys.foreach{ i =>
    pw.write("Word =" + i )
    pw.write(":")
    pw.write(" count = " + counts(i))
    pw.write("\n")
  }
//  for (word <- words)  {
//    if(word.length>=3)
//    pw.write(word+"\n")
//  }
  pw.close()
}
//  def timeMethod(method: () => Unit) {
//    val start = System.nanoTime
//    method()
//    val end = System.nanoTime
//    println("Method took " + (end - start)/1000000000.0 + " seconds.")
//  }
  def time[A](a: => A) = {
    val now = System.nanoTime
    val result = a
    val micros = (System.nanoTime - now)/1000
    println("%d milisecond".format(micros))
    result

  }

  def countWords(text: String) = {
      for (rawWord <- text.split("[!,.()‘\"\'\\]\\[\\s+]+")) {
         val word = rawWord.toLowerCase
          val oldCount =
             if (counts.contains(word)) counts(word)
           else 0
         counts += (word -> (oldCount + 1))
        }
      counts
      }
}