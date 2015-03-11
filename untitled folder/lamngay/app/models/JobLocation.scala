package models
import scala.slick.driver.PostgresDriver.simple._
/**
 * Created by tuanna on 5/29/14.
 */
case class JobLocationRow(id: Long, jobid: Option[Long], locationid: Option[Long])
/** Table description of table job_location. Objects of this class serve as prototypes for rows in queries. */
class JobLocation(tag: Tag) extends Table[JobLocationRow](tag, "job_location") {
  def * = (id, jobid, locationid) <> (JobLocationRow.tupled, JobLocationRow.unapply)
  /** Maps whole row to an option. Useful for outer joins. */
  def ? = (id.?, jobid, locationid).shaped.<>({r=>import r._; _1.map(_=> JobLocationRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

  /** Database column id AutoInc, PrimaryKey */
  val id: Column[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
  /** Database column jobid  */
  val jobid: Column[Option[Long]] = column[Option[Long]]("jobid")
  /** Database column locationid  */
  val locationid: Column[Option[Long]] = column[Option[Long]]("locationid")
  /** Foreign key referencing Jobs (database name job_location_jobid_fkey) */
  }
object JobLocation extends TableQuery(new JobLocation(_)){
  def findAll( implicit session:Session):List[JobLocationRow]={
    val q = for { c <- JobLocation} yield c
    q.list
  }
}