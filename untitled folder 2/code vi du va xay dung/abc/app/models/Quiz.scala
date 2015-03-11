package models

/**
 * Created by tuanna on 5/17/14.
 */

case class Quiz(name:String,ans:String)

object Quiz {
  var ans = Set(Quiz("quest","1"),Quiz("quest","1"),Quiz("quest","2"),Quiz("quest","2"),Quiz("quest","1"))

   def findAll = this.ans.toList
}

