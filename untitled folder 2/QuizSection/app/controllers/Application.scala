package controllers

import play.api._
import play.api.mvc._
import models._
import play.api.libs.json._
import java.util


object Application extends Controller {

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
  def quiz = Action {
        Ok(views.html.quiz("hocngay"))
  }

  def getJson = Action {
   val data = List("1","2","3","4","1")
    Ok(Json.toJson(data))
  }


  def getQuest = Action {
    val data =  List("Câu hỏi số 1","Câu  2","Số 3 là ?","Số 4 thì sao ?","Số \"5\" chứ nhỉ?")
    Ok(Json.toJson(data))
  }
  def getAns= Action {
    val data =List(Answer("1","2","3",null,null),Answer("2","3","4","5","6"),Answer("2","3","4","5","6"),Answer("3","4","3","2","1"),Answer("3","4","5","6","3"))
       Ok(Json.toJson(data))
  }
}