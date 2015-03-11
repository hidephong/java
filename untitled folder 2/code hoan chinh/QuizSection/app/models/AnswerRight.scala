package models

import play.api.libs.json._

/**
 * Created by tuanna on 5/22/14.
 */
case class AnswerRight(quest:String)

object AnswerRight{
   implicit val implicitAnsWrites = new Writes[AnswerRight] {
    def writes(ans: AnswerRight): JsValue = {
      Json.obj(
        "quest" -> ans.quest
      )
    }
  }
}