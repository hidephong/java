package controllers

import play.api._
import play.api.mvc._
import models.Quiz
import com.google._;

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def list= Action {
    //List<Quiz> albums = Album.findAll();
    val albums= List("a","b","c")
    val gson = new Gson();
    renderJSON(albums)
    Ok()
  }
}

