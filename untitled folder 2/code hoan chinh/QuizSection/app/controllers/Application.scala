package controllers
import play.api.mvc._
import play.api.Play

object Application extends Controller {
  def genModels = Action {implicit request=>
    scala.slick.model.codegen.SourceCodeGenerator.main(
      Array("scala.slick.driver.PostgresDriver",Play.current.configuration.getString("db.default.driver").get,
        Play.current.configuration.getString("db.default.url").get,"/Users/tuanna/db","database",
        Play.current.configuration.getString("db.default.user").get,
        Play.current.configuration.getString("db.default.password").get)
    )
    Ok("da xong")
  }
}