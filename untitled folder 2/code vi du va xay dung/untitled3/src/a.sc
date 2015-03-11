import scala.xml.XML

val a= List(1 to 10)
val b=(1 to 10).toList
val c = 1 to 10 toList
//c.foreach(println())
val fileText = io.Source.fromFile("/usr/local/share/data.txt").mkString.replaceAll("\\s+", "")
println(fileText.length())


(1 to 1000).reduceLeft( _ + _ )
(1 to 1000).sum
val results = XML.load("http://google.com/")
println(results)