/**
 * Created by tuanna on 5/19/14.
 */
import java.io._
import scala.io.Source
import scala.collection._

object baitap extends App{

  val counts = mutable.Map.empty[String, Int]
  var map  =  mutable.ListMap.empty[String, Int]

  val currentDir = new java.io.File("./src")
  val absolutePath = currentDir.getAbsolutePath
  println(s"We find file in here: $absolutePath")
  private def filesHere = (currentDir).listFiles
  val foundFiles = filesContaining("txt").foreach(println)



     // time{readFileByScala(filesContaining("txt").foreach.toString()) }
     // time{ writeToFile("word.out")}




  private def filesMatching (matcher: String => Boolean) =
    for(file <- filesHere; if matcher(file.getName))
    yield file

  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))

  def filesContaining(query: String) =
    filesMatching(_.contains(query))

  def filesRegex(query: String) =
    filesMatching(_.matches(query))


  def readFileByScala(filename:String) {
    val fileName = filename
    val bufferSource = Source.fromFile(fileName)
    for (line <- bufferSource.getLines) {
      countWords(line)
    }

    map = mutable.ListMap(counts.toList.sortBy[Int](_._2): _*)

    bufferSource.close
  }

  def writeToFile(filename:String) {
    val fileName = filename
    val pw = new BufferedWriter(new FileWriter(fileName))
    map.keys.foreach{ i =>
      pw.write(i )
      pw.write(":")
      pw.write(counts(i))
     pw.write("\n")
    }
    pw.close()
  }
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
      if(word.length>=3){
      val oldCount =
        if (counts.contains(word)) counts(word)
        else 0
      counts += (word -> (oldCount + 1))
      }
    }
    counts
  }
}