package controllers

import play.api._
import play.api.mvc._
import play.api.Play
import models._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }



  def genModels = Action {implicit request=>
    scala.slick.model.codegen.SourceCodeGenerator.main(
      Array("scala.slick.driver.PostgresDriver",Play.current.configuration.getString("db.default.driver").get,
        Play.current.configuration.getString("db.default.url").get,"/Users/tuanna/db","database",
        Play.current.configuration.getString("db.default.user").get,
        Play.current.configuration.getString("db.default.password").get)
    )
    Ok("da xong")
  }
  def findAdmin  = Action {
    SlickDb.db.withSession { implicit session =>
      Ok(Admin.findById(1).get.username.getOrElse("Khong tim thay"))
      }
  }
  def insert  = Action {
    SlickDb.db.withSession { implicit session =>
      val a =Admin.insertAd("tuan","123")
      Ok("od")
    }
  }

}