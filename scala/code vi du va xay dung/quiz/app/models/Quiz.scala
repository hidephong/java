package models
/**
 * Created by tuanna on 5/17/14.
 */
import play.api.libs.json._
case class Quiz(name:String,ans:String)
object Quiz{
//implicit object Quiz extends Format[Quiz]{
//  //var ans = Set(Quiz("quest","1"),Quiz("quest","1"),Quiz("quest","2"),Quiz("quest","2"),Quiz("quest","1"))
//   //def findAll = this.ans.toList<Quiz>
//
//  def writes(quiz: Quiz): JsValue = JsObject(List("quest"->JsString("1"),"quest"->JsString("1"),"quest"->JsString("2"),"quest"->JsString("2"),"quest"->JsString("1")))
//
//
// def reads(json: JsValue): JsResult[Quiz] = {  JsSuccess(Quiz("", ""))
// }
//
//
//
// }



}
