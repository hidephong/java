/**
 * Created by tuanna on 5/13/14.
 */
class demo {

  def speakImplicitly (implicit greeting : String) = println(greeting)
  //speakImplicitly: (implicit greeting: String)Unit

  speakImplicitly("Goodbye world") // Goodbye world

  speakImplicitly //<console>:9: error: could not find implicit value for parameter greeting: String


  implicit val hello = "Hello world" // hello: String = Hello world

  speakImplicitly //Hello world


}
