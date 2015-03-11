package models

import scala.slick.driver.PostgresDriver.simple._
import play.api.libs.json.Json

/**
 * Created by tuanna on 5/21/14.
 */
case class Quest(name:String,quest:String)

case class QuizRow(quizid: Long, question: Option[String], scoreearn: Option[Long], expearn: Option[Long], ordernumber: Int = 1, sectionid: Int = 1)
/** Table description of table quiz. Objects of this class serve as prototypes for rows in queries. */

class Quiz(tag: Tag) extends Table[QuizRow](tag, "quiz") {
  def * = (quizid, question, scoreearn, expearn, ordernumber, sectionid) <> (QuizRow.tupled, QuizRow.unapply)
  /** Maps whole row to an option. Useful for outer joins. */
  def ? = (quizid.?, question, scoreearn, expearn, ordernumber.?, sectionid.?).shaped.<>({r=>import r._; _1.map(_=> QuizRow.tupled((_1.get, _2, _3, _4, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

  /** Database column quizid AutoInc, PrimaryKey */
  val quizid: Column[Long] = column[Long]("quizid", O.AutoInc, O.PrimaryKey)
  /** Database column question  */
  val question: Column[Option[String]] = column[Option[String]]("question")
  /** Database column scoreearn  */
  val scoreearn: Column[Option[Long]] = column[Option[Long]]("scoreearn")
  /** Database column expearn  */
  val expearn: Column[Option[Long]] = column[Option[Long]]("expearn")
  /** Database column ordernumber Default(1) */
  val ordernumber: Column[Int] = column[Int]("ordernumber", O.Default(1))
  /** Database column sectionid Default(1) */
  val sectionid: Column[Int] = column[Int]("sectionid", O.Default(1))
}
object Quiz{
  object Quiz  extends TableQuery(new Quiz(_)){
    def findById(id: Int)( implicit session:Session):List[QuizRow]={
      val q = for { c <- Quiz if c.sectionid === id } yield c
      q.list
    }
  }
}