package models

import scala.slick.driver.PostgresDriver.simple._
import play.api.Play

/**
 * Created by tuanna on 5/15/14.
 */
object SlickDb {
val db=Database.forURL(Play.current.configuration.getString("db.default.url").get,
Play.current.configuration.getString("db.default.user").get,
Play.current.configuration.getString("db.default.password").get,
driver=Play.current.configuration.getString("db.default.driver").get
)
}
