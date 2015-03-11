package models
import play.api.libs.json._
/**
 * Created by tuanna on 5/21/14.
 */

case class Answer(ans1:String,ans2:String,ans3:String,ans4:String,ans5:String)
object Answer{


  implicit val locationWrites = new Writes[Answer] {
    def writes(location: Answer) = Json.obj(

    )
  }

}