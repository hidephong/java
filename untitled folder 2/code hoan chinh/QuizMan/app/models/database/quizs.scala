//package models.database
//
///**
// * Created by tuanna on 5/24/14.
// */
//
//import play.api.db.slick.Config.driver.simple._
//import scala.slick.model.{Column, Table}
//import scala.slick.direct.AnnotationMapper.column
//
///**
// * Getting started: simple table definition.
// */
//class Quizs extends Table[(Long, String)]("Quizs") {
//  def quizid = column[Long]("quizid")
//  def question = column[String]("question")
//    def * = quizid ~ question
//}
