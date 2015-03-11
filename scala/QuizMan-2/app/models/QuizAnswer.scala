package models

import scala.slick.lifted.TableQuery
import play.api.mvc.Session
import scala.slick.driver.PostgresDriver.simple._
import play.api.libs.json.{Json, JsValue, Writes}
/**
 * Created by tuanna on 5/24/14.
 */
case class QuizanswersRow(quizid: Option[Long], answerid: Long, answertext: Option[String], types: Option[Boolean])
/** GetResult implicit for fetching QuizanswersRow objects using plain SQL queries */
/** Table description of table quizanswers. Objects of this class serve as prototypes for rows in queries. */
class Quizanswers(tag: Tag) extends Table[QuizanswersRow](tag, "quizanswers") {
  def * = (quizid, answerid, answertext, types) <> (QuizanswersRow.tupled, QuizanswersRow.unapply)
  /** Maps whole row to an option. Useful for outer joins. */
  def ? = (quizid, answerid.?, answertext, types).shaped.<>({r=>import r._; _2.map(_=> QuizanswersRow.tupled((_1, _2.get, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

  /** Database column quizid  */
  val quizid: Column[Option[Long]] = column[Option[Long]]("quizid")
  /** Database column answerid AutoInc */
  val answerid: Column[Long] = column[Long]("answerid", O.AutoInc)
  /** Database column answertext  */
  val answertext: Column[Option[String]] = column[Option[String]]("answertext")
  /** Database column types  */
  val types: Column[Option[Boolean]] = column[Option[Boolean]]("types")
}

object  QuizAnswer  extends TableQuery(new Quizanswers(_)){
  def findAll( implicit session:Session):List[QuizanswersRow]={
    val q = for { c <- QuizAnswer } yield c
    List()
  }
}