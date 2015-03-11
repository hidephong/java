package controllers


import play.api.mvc._
import models._
import scala.slick.driver.PostgresDriver.simple._
import play.api.Play.current

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("lamngay"))
  }
//  def genModels = Action {implicit request=>
//    scala.slick.model.codegen.SourceCodeGenerator.main(
//      Array("scala.slick.driver.PostgresDriver",Play.current.configuration.getString("db.default.driver").get,
//        Play.current.configuration.getString("db.default.url").get,"/Users/tuanna/db1","database",
//        Play.current.configuration.getString("db.default.user").get,
//        Play.current.configuration.getString("db.default.password").get)
//    )
//    Ok("da xong")
//  }

  def join = Action { implicit request =>
    SlickDb.db.withSession {
      implicit session  => {
        Ok(views.html.join(JobJoin.findAll))
      }

    }
  }


  def sayHello = Action(parse.json) { request =>
    (request.body \ "name").asOpt[String].map { name =>
      Ok("Hello " + name)
    }.getOrElse {
      BadRequest("Missing parameter [name]")
    }
  }

  def p = Action(parse.json) { request =>
    (request.body \ "p").asOpt[String].map { p =>
      Ok("Hello " + p)
    }.getOrElse {
      BadRequest("Missing parameter [p]")
    }
  }
}