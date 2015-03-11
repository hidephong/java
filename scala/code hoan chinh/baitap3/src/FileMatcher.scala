//Ví dụ trang 209 Programming in Scala 2
object FileMatcher extends App {
  val currentDir = new java.io.File("./src")
  val absolutePath = currentDir.getAbsolutePath
  println(s"We find file in here: $absolutePath")
  private def filesHere = (currentDir).listFiles
  val foundFiles = filesContaining("txt").foreach(println)


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
