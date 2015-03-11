package models
import scala.slick.driver.PostgresDriver.simple._
/**
 * Created by tuanna on 5/29/14.
 */
case class EmployersRow(id: Int, name: String, address: Option[String], logo: Option[String], phone: Int, description: Option[String], email: String, website: Option[String], surrogate: Option[String], statusid: Int = 1, password: String)
/** GetResult implicit for fetching EmployersRow objects using plain SQL queries */
/** Table description of table employers. Objects of this class serve as prototypes for rows in queries. */
class Employers(tag: Tag) extends Table[EmployersRow](tag, "employers") {
  def * = (id, name, address, logo, phone, description, email, website, surrogate, statusid, password) <> (EmployersRow.tupled, EmployersRow.unapply)
  /** Maps whole row to an option. Useful for outer joins. */
  def ? = (id.?, name.?, address, logo, phone.?, description, email.?, website, surrogate, statusid.?, password.?).shaped.<>({r=>import r._; _1.map(_=> EmployersRow.tupled((_1.get, _2.get, _3, _4, _5.get, _6, _7.get, _8, _9, _10.get, _11.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

  /** Database column id AutoInc, PrimaryKey */
  val id: Column[Int] = column[Int]("id", O.AutoInc, O.PrimaryKey)
  /** Database column name  */
  val name: Column[String] = column[String]("name")
  /** Database column address  */
  val address: Column[Option[String]] = column[Option[String]]("address")
  /** Database column logo  */
  val logo: Column[Option[String]] = column[Option[String]]("logo")
  /** Database column phone  */
  val phone: Column[Int] = column[Int]("phone")
  /** Database column description  */
  val description: Column[Option[String]] = column[Option[String]]("description")
  /** Database column email  */
  val email: Column[String] = column[String]("email")
  /** Database column website  */
  val website: Column[Option[String]] = column[Option[String]]("website")
  /** Database column surrogate  */
  val surrogate: Column[Option[String]] = column[Option[String]]("surrogate")
  /** Database column statusid Default(1) */
  val statusid: Column[Int] = column[Int]("statusid", O.Default(1))
  /** Database column password  */
  val password: Column[String] = column[String]("password")
}

object Employers extends TableQuery(new Employers(_)) {
  def findAll( implicit session:Session):List[EmployersRow]={
    val q = for { c <- Employers} yield c
    q.list
  }
}