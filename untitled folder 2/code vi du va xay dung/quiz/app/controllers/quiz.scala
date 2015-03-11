/**
 * Created by tuanna on 5/17/14.
 */

package controllers
import play.api.mvc._
import models.Quiz
import play.api.libs.json._
import play.api.libs.json.JsObject

object Quizs extends Controller {
  val list1 = List(Quiz("quest","1"),Quiz("quest","1"),Quiz("quest","1"),Quiz("quest","1"),Quiz("quest","1"))
  def quiz = Action {
    //val quiz2 = Quiz.getAll
    val  json=Json.parse("[{\"quest\":\"1\",\"quest\":\"1\",\"quest\":\"1\",\"quest\":\"1\",\"quest\":\"1\"}]")
    Ok(views.html.quiz())
  }
  def getQuiz = Action {

    val quizs= Seq("quest:1","quest:1","quest:1","quest:1","quest:1")
      //  val json : Seq[JsValue] =quizs.map(Json.toJson(_))
   // val  json=Json.parse("[{\"quest\":\"1\",\"quest\":\"1\",\"quest\":\"1\",\"quest\":\"1\",\"quest\":\"1\"}]")
      val oj =
            JsObject(
            "quest"->JsString("1")::
              "quest"->JsString("1")::
              "quest"->JsString("1")::
              "quest"->JsString("1")::
              "quest"->JsString("1")::
             Nil)





    Ok(views.html.quiz(oj))
  }
  def gQuiz(id:String) = Action {

    val quizs= Seq("quest:1","quest:1","quest:1","quest:1","quest:1")
    //  val json : Seq[JsValue] =quizs.map(Json.toJson(_))
    val  json:JsValue=Json.parse("[{\"quest\":\"1\",\"quest\":\"1\",\"quest\":\"1\",\"quest\":\"1\",\"quest\":\"1\"}]")
    val oj=Json.obj("quest"->"1","quest"->"1","quest"->"1","quest"->"1","quest"->"1")
    if(id=="1")
   {
    Ok(views.html.quiz())
   }
    Ok(oj)
  }
}