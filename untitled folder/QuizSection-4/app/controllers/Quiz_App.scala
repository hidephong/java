package controllers

import play.api.mvc._
import play.api.libs.json._
import play.api.libs.json.JsObject
import play.api.libs.json.JsString
import models._



object Quiz_App extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }
  def ansJson = Action {
    val oj =
      JsObject(
        "quest"->JsString("1")::
          "quest"->JsString("1")::
          "quest"->JsString("1")::
          "quest"->JsString("1")::
          "quest"->JsString("1")::
          Nil)
    Ok(oj)
  }


  def getJson = Action {
    val data =Array(AnswerRight("1"),AnswerRight("2"),AnswerRight("3"),AnswerRight("4"),AnswerRight("1"))
    Ok(Json.toJson(data))
  }


  def getAns= Action {
    val data =Array(Answer("1","2","3",null,null),Answer("2","3","4","5","6"),Answer("2","3","4","5","6"),Answer("3","4","3","2","1"),Answer("3","4","5","6","3"))
    Ok(Json.toJson(data))
  }

  def getQuest = Action(parse.json) { request =>
    (request.body \ "p").asOpt[String].map { p =>
      SlickDb.db.withSession {
        implicit session => {
          Ok(Json.toJson(Quiz.findById(p.toInt)))
        }
      }
    }.getOrElse {
      BadRequest("Missing parameter [p]")
    }
  }

}