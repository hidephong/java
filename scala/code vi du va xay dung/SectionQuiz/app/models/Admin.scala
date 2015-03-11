package models
import scala.slick.driver.PostgresDriver.simple._


/**
 * Created by tuanna on 5/22/14.
 */
case class AdminRow(username: Option[String], password: Option[String], adminid: Long)
/** GetResult implicit for fetching AdminRow objects using plain SQL queries */
/** Table description of table admin. Objects of this class serve as prototypes for rows in queries. */
class Admin(tag: Tag) extends Table[AdminRow](tag, "admin") {
  def * = (username, password, adminid) <> (AdminRow.tupled, AdminRow.unapply)
  /** Maps whole row to an option. Useful for outer joins. */
  def ? = (username, password, adminid.?).shaped.<>({r=>import r._; _3.map(_=> AdminRow.tupled((_1, _2, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

  /** Database column username  */
  val username: Column[Option[String]] = column[Option[String]]("username")
  /** Database column password  */
  val password: Column[Option[String]] = column[Option[String]]("password")
  /** Database column adminid AutoInc, PrimaryKey */
  val adminid: Column[Long] = column[Long]("adminid", O.AutoInc, O.PrimaryKey)
}
object Admin extends TableQuery(new Admin(_)){
  def findById(id: Long)( implicit session:Session):Option[AdminRow]={
    this.filter(_.adminid===id).firstOption
  }

  def login(username: Option[String], password: Option[String])(implicit session:Session): Option[AdminRow]={
    val q= for {
      a<-this if a.username=== username&& a.password === password
    } yield  a
    q.firstOption
  }

  def insertAd(username: String, password: String)(implicit session:Session)={
    val a = Admin.map(c => (c.username,c.password)).insert(Some(username),Option(password))
    a
  }

}
