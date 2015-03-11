package models
import scala.slick.driver.PostgresDriver.simple._
/**
 * Created by tuanna on 5/29/14.
 */
case class SkillsRow(id: Long, name: Option[String], ispopular: Option[Boolean] = Some(false))
/** Table description of table skills. Objects of this class serve as prototypes for rows in queries. */
class Skills(tag: Tag) extends Table[SkillsRow](tag, "skills") {
  def * = (id, name, ispopular) <> (SkillsRow.tupled, SkillsRow.unapply)
  /** Maps whole row to an option. Useful for outer joins. */
  def ? = (id.?, name, ispopular).shaped.<>({r=>import r._; _1.map(_=> SkillsRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

  /** Database column id AutoInc, PrimaryKey */
  val id: Column[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
  /** Database column name  */
  val name: Column[Option[String]] = column[Option[String]]("name")
  /** Database column ispopular Default(Some(false)) */
  val ispopular: Column[Option[Boolean]] = column[Option[Boolean]]("ispopular", O.Default(Some(false)))
}
object Skills extends TableQuery(new Skills(_)){
  def findAll( implicit session:Session):List[SkillsRow]={
    val q = for { c <- Skills} yield c
    q.list
  }
}