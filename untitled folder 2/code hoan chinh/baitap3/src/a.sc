/**
 * Created by tuanna on 5/19/14.
 */
import scala.io.Source








def time[T](f: => T): T = {
  val start = System.nanoTime
  val r = f
  val end = System.nanoTime
  val time = (end - start)/1e6
  println("time = " + time +"ms")
  r
}

val domain = "http://en.wikipedia.org"
val startPage = "/wiki/Main_Page"
val linkRegex = """\"/wiki/[a-zA-Z\-_]+\"""".r


def getLinks(html: String): Set[String] =
  linkRegex.findAllMatchIn(html).map(_.toString.replace("\"", "")).toSet

def getHttp(url: String) = {
  val in = Source.fromURL(domain + url, "utf8")
  val response = in.getLines.mkString
  in.close()
  response
}

val links = getLinks(getHttp(startPage))
links.foreach(println)



































object FileMatcher extends App {
  val currentDir = new java.io.File("./src")
  val absolutePath = currentDir.getAbsolutePath
  println(s"We find file in here: $absolutePath")
  private def filesHere = (currentDir).listFiles
  val foundFiles = filesContaining("scala").foreach(println)
  //Tham số của filesMatching là một first class function nhận vào một String trả về Boolean
  private def filesMatching (matcher: String => Boolean) =
    for(file <- filesHere; if matcher(file.getName))
    yield file
  // filesEnding sẽ gọi filesMatching. scope
  // Nhớ có closure, mà filesMatch dùng sẽ sử dụng tham số query trong cùng
  def filesEnding(query: String) =
    filesMatching(_.endsWith(query))
  //file.getName sẽ điền vào dấu underscore
  //matcher(file.getName))  --> file.getName.endsWith(query)
  def filesContaining(query: String) =
    filesMatching(_.contains(query))
  def filesRegex(query: String) =
    filesMatching(_.matches(query))
}






















println(links.size)



val allLinks = time(links.par.flatMap(link => getLinks(getHttp(link))))
println(allLinks.size)

