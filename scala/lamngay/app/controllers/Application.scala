package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("lamngay"))
  }

  def details = Action {
    Ok(views.html.details("lamngay"))
  }
  def search(s:String) = Action {
    Ok(views.html.search("lamngay"))
  }
}