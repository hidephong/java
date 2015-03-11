/**
 * Created by tuanna on 5/19/14.
 */
import java.io._
import scala.collection.immutable.ListMap
import scala.io.Source
import scala.collection._
import scala.util.matching.Regex

object baitap{

  val mapWordsCounts = mutable.Map.empty[String, Int]
  var map  =  immutable.ListMap.empty[String, Int]
  val ignore = mutable.Set.empty[String]
  val currentDir = new java.io.File("luu/src")
  val absolutePath = currentDir.getAbsolutePath

  def main(args: Array[String]) {

    time{
      val bufferSource = Source.fromFile(absolutePath+"/ignore.conf")
      val pw = new BufferedWriter(new FileWriter(absolutePath+"/out.txt"))
      val bufferSource1 = Source.fromFile(absolutePath+"/putin.txt")
      for (line <- bufferSource.getLines) {
        ignore += line.toString
      }
      for (line <- bufferSource1.getLines) {
        for (rawWord <- line.split("[!,.()“\"\\[\\]\\s+]+")) {
         val word=rawWord.toLowerCase
          if(word.length>=2){
            val oldCount =
              if (mapWordsCounts.contains(word)) mapWordsCounts(word) else 0
                mapWordsCounts += (word -> (oldCount + 1))
          }
        }
      }

      mapWordsCounts--=ignore
      map = ListMap.empty ++ mapWordsCounts.toIndexedSeq.sortBy(kv => (-kv._2, kv._1))
      map.keys.foreach{ i =>
        pw.write(i+":"+mapWordsCounts(i)+"\n")
      }
      bufferSource.close
      pw.close
    }
  }

  def time[A](a: => A) = {
    val now = System.nanoTime
    val result = a
    val micros = (System.nanoTime - now)/1000
    println("%d microsecond".format(micros))
    result
  }
}