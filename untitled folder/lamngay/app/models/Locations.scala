package models
import scala.slick.driver.PostgresDriver.simple._
/**
 * Created by tuanna on 5/29/14.
 */
case class LocationsRow(id: Long, name: Option[String], ordernumber: Option[Int])
/** Table description of table locations. Objects of this class serve as prototypes for rows in queries. */
class Locations(tag: Tag) extends Table[LocationsRow](tag, "locations") {
  def * = (id, name, ordernumber) <> (LocationsRow.tupled, LocationsRow.unapply)
  /** Maps whole row to an option. Useful for outer joins. */
  def ? = (id.?, name, ordernumber).shaped.<>({r=>import r._; _1.map(_=> LocationsRow.tupled((_1.get, _2, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

  /** Database column id AutoInc, PrimaryKey */
  val id: Column[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
  /** Database column name  */
  val name: Column[Option[String]] = column[Option[String]]("name")
  /** Database column ordernumber  */
  val ordernumber: Column[Option[Int]] = column[Option[Int]]("ordernumber")
}
object Locations extends TableQuery(new Locations(_)){
  def findAll( implicit session:Session):List[LocationsRow]={
    val q = for { c <- Locations} yield c
    q.list
  }
}