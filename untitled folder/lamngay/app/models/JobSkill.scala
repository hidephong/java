package models
import scala.slick.driver.PostgresDriver.simple._
/**
 * Created by tuanna on 5/29/14.
 */
case class JobSkillRow(id: Long, jobid: Option[Long], skillid: Option[Long])

/** Table description of table job_skill. Objects of this class serve as prototypes for rows in queries. */
class JobSkill(tag: Tag) extends Table[JobSkillRow](tag, "job_skill") {
  def * = (id, jobid, skillid) <> (JobSkillRow.tupled, JobSkillRow.unapply)
  /** Maps whole row to an option. Useful for outer joins. */
  def ? = (id.?, jobid, skillid).shaped.<>({r=>import r._; _1.map(_=> JobSkillRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

  /** Database column id AutoInc, PrimaryKey */
  val id: Column[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
  /** Database column jobid  */
  val jobid: Column[Option[Long]] = column[Option[Long]]("jobid")
  /** Database column skillid  */
  val skillid: Column[Option[Long]] = column[Option[Long]]("skillid")
}
object JobSkill extends TableQuery(new JobSkill(_)){
  def findAll( implicit session:Session):List[JobSkillRow]={
    val q = for { c <- JobSkill} yield c
    q.list
  }
}