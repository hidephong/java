package models

import play.api.libs.json._
import play.api.libs.functional.syntax._
/**
 * Created by tuanna on 5/21/14.
 */

case class Answer(a1:String,a2:String,a3:String,a4:String,a5:String)
object Answer{
  implicit val ansWrites: Writes[Answer]=(
    (JsPath \ "a1").write[String] and
      (JsPath \ "a2").write[String] and
      (JsPath \ "a3").write[String] and
      (JsPath \ "a4").write[String] and
      (JsPath \ "a5").write[String]
    )(unlift(Answer.unapply))
}