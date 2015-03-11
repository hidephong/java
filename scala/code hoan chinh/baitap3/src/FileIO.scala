import java.io._
import scala.io.Source
import sys.process._
object FileIO
{
  def main(args: Array[String]) {
    readFileByScala
    listFilesInFolder("/usr/local").foreach(println)

    getListOfSubDirectories(new File("/usr/local")).foreach(println)
    executeExternalCommand
    playSoundFile("./src/bird.mp3")
  }

  def readFileByScala {
    val fileName = "/etc/passwd"
    val bufferSource = Source.fromFile(fileName)
    for (line <- bufferSource.getLines) {
      println(line)
    }
    bufferSource.close //Hãy đóng file sau khi dùng xong, tránh
  }

  def writeToFile {
    val fileName = "/Users/techmaster/test.txt"
    val pw = new BufferedWriter(new FileWriter(fileName))
    pw.write("Hello World")
    pw.close()
  }

  def listFilesInFolder(dir: String): List[File] = {
    val d = new File(dir)
    if (d.exists() && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]() //tra ve List rong
    }
  }

  def getListOfSubDirectories(dir: File): List[String] = {
    dir.listFiles.filter(_.isDirectory).map(_.getName).toList
  }

  def executeExternalCommand
  {
    //import sys.process._
    //import o day cung ok, local scope
    "ls -al".!
  }

  def playSoundFile(fileName: String):Int = {
    val cmd = "afplay " + fileName
    val exitCode = cmd.!
    exitCode
  }
}