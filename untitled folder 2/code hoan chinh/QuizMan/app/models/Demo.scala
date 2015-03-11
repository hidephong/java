package models
import scala.slick.driver.PostgresDriver.simple._
import play.api.libs.json.Json

/**
 * Created by tuanna on 5/24/14.
 */
case class Demo(
                 firstname: String,
                 lastname: String,
                 company: Option[String]
                 )
object Demo
{
  def delete(ean: String) = {}

  var demos = Set(
    Demo("Paperclips","Large",Option("sdsad")),
    Demo("Giant","Plain",Option("asdasdasd")),
    Demo("Paperclip","Giant",Option("adasdasd")),
    Demo("Clip","Extra",Option("adasdasd")),
    Demo("Zebra","Pack",Option("sadasd"))
  )

  def findAll = demos.toList.sortBy(_.firstname)

  def findByEan(ean: String) = demos.find(_.firstname == ean)

  def add(demo: Demo) {
    demos = demos + demo
  }

//  def find(implicit session:Session) = {
//    val a=  Quiz.findById(2)
//    val data = a
//    Ok(Json.toJson(data))
//  }
}