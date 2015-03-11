package controllers

import play.api._
import play.api.mvc._
import models.Quiz
import play.mvc.Controller
import play.api.libs.json.Json



object Application extends Controller {
  def getJson = Action {
    List[Quiz] quiz = Quiz.getAll
    Ok(Json.toJson(quiz))
  }
 }

