/**
 * Created by tuanna on 5/19/14.
 */
import java.io._
import scala.collection.immutable.ListMap
import scala.io.Source
import scala.collection._
import scala.util.matching.Regex

object baitap{

  val counts = mutable.Map.empty[String, Int]
  var map  =  immutable.ListMap.empty[String, Int]
  val ignore = mutable.Set.empty[String]
  val currentDir = new java.io.File("luu/src")
  val absolutePath = currentDir.getAbsolutePath

  def main(args: Array[String]) {


   time{
   init
   readFileByScala()
   writeToFile()
   }
  }

  def init(){
    val fileName = "ignore.conf"
    val bufferSource = Source.fromFile(absolutePath+"/"+fileName)
    for (line <- bufferSource.getLines) {
        ignore += line.toString
    }

  }

  def readFileByScala() {
   // val fileName = filename
    val bufferSource = Source.fromFile(absolutePath+"/putin.txt")
    for (line <- bufferSource.getLines) {
      countWords(line)
    }
    map =ListMap.empty ++ counts.toIndexedSeq.sortBy(kv => (-kv._2, kv._1))
    map--=ignore
    bufferSource.close
  }

  def writeToFile() {
   // val fileName = filename
    val pw = new BufferedWriter(new FileWriter(absolutePath+"/out.txt"))
    map.keys.foreach{ i =>
      pw.write(i)
      pw.write(":")
      pw.write(""+counts(i))
      pw.write("\n")
    }
    pw.close()
  }

   def countWords(text: String) = {
    for (rawWord <- text.split("[!,.()\\“\"\\]\\[\\s+]+")) {
      val pattern = new Regex("[a-z'’]*")
      val word = (pattern findAllIn rawWord.toLowerCase).mkString
        // val word = rawWord.toLowerCase
      if(word.length>=2){
      val oldCount =
        if (counts.contains(word)) counts(word)
        else 0
      counts += (word -> (oldCount + 1))
      }
    }
    counts
  }
  def time[A](a: => A) = {
    val now = System.nanoTime
    val result = a
    val micros = (System.nanoTime - now)/1000
    println("%d milisecond".format(micros))
    result

  }
}