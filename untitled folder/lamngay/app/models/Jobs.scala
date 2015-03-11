package models
import scala.slick.driver.PostgresDriver.simple._
import play.api.libs.json.Json
/**
 * Created by tuanna on 5/29/14.
 */
case class JobsRow(id: Int, name: String, salary: Option[String], description: Option[String], requirement: Option[String], createdate: Option[java.sql.Date] = None, expiresdate: java.sql.Date, ishot: Boolean = false, employerid: Int, statusid: Int = 1)
/** Table description of table jobs. Objects of this class serve as prototypes for rows in queries. */
class Jobs(tag: Tag) extends Table[JobsRow](tag, "jobs") {
  def * = (id, name, salary, description, requirement, createdate, expiresdate, ishot, employerid, statusid) <> (JobsRow.tupled, JobsRow.unapply)
  /** Maps whole row to an option. Useful for outer joins. */
  def ? = (id.?, name.?, salary, description, requirement, createdate, expiresdate.?, ishot.?, employerid.?, statusid.?).shaped.<>({r=>import r._; _1.map(_=> JobsRow.tupled((_1.get, _2.get, _3, _4, _5, _6, _7.get, _8.get, _9.get, _10.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

  /** Database column id AutoInc, PrimaryKey */
  val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
  /** Database column name  */
  val name: Column[String] = column[String]("name")
  /** Database column salary  */
  val salary: Column[Option[String]] = column[Option[String]]("salary")
  /** Database column description  */
  val description: Column[Option[String]] = column[Option[String]]("description")
  /** Database column requirement  */
  val requirement: Column[Option[String]] = column[Option[String]]("requirement")
  /** Database column createdate Default(None) */
  val createdate: Column[Option[java.sql.Date]] = column[Option[java.sql.Date]]("createdate", O.Default(None))
  /** Database column expiresdate  */
  val expiresdate: Column[java.sql.Date] = column[java.sql.Date]("expiresdate")
  /** Database column ishot Default(false) */
  val ishot: Column[Boolean] = column[Boolean]("ishot", O.Default(false))
  /** Database column employerid  */
  val employerid: Column[Int] = column[Int]("employerid")
  /** Database column statusid Default(1) */
  val statusid: Column[Int] = column[Int]("statusid", O.Default(1))
}

object Jobs extends TableQuery(new Jobs(_)) {
  def findAll( implicit session:Session):List[JobsRow]={
    val q = for { c <- Jobs} yield c
    q.list
  }
}