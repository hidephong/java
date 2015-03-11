package controllers

import play.api.data.Form
import play.api._
import play.api.mvc._
import play.api.Play
import models._
import play.api.libs.json.Json

/**
 * Created by tuanna on 5/24/14.
 */
object DemoController extends Controller {

  import play.api.data.Forms._

  val demoForm = Form(
    mapping(
      "firstname" -> nonEmptyText,
      "lastname" -> nonEmptyText,
      "company" -> optional(text)
    )(Demo.apply)(Demo.unapply)
  )


  def show(ean: String) = Action {
    implicit request =>

      Demo.findByEan(ean).map {
        demo =>

          Ok(views.html.vdemo.details(demo))

      }.getOrElse(NotFound)
  }

  def newDemo = Action {
    implicit request =>
      val form = if (flash.get("error").isDefined)
        demoForm.bind(flash.data)
      else
        demoForm

      Ok(views.html.vdemo.editProduct(form))
  }

  def save = Action {
    implicit request =>
      val newDemoForm = demoForm.bindFromRequest()
      newDemoForm.fold(
        hasErrors = {
          form =>
            Redirect(routes.DemoController.newDemo())
        },
        success = {
          newDemo =>
            Demo.add(newDemo)
            Redirect(routes.DemoController.show(newDemo.firstname))
        })
  }


  def findQuiz = Action {
    SlickDb.db.withSession {
      implicit session => {
        Ok(views.html.list(Quiz.findById(2)))
      }

    }
  }

//  def findAns = Action {
//    SlickDb.db.withSession {
//      implicit session => {
//        Ok(views.html.listAns(QuizAnswer.findAll))
//      }
//
//    }
//  }

  def p = Action(parse.json) { request =>
    (request.body \ "p").asOpt[String].map { p =>
      SlickDb.db.withSession {
        implicit session => {
          Ok(Json.toJson(Quiz.findById(p.toInt)))
        }
      }
    }.getOrElse {
      BadRequest("Missing parameter [p]")
    }
  }
//  def find = Action {
//    SlickDb.db.withSession {
//      implicit session => {
//        val a = Quiz.findById(2)
//        Ok(Json.toJson(a))
//      }
//    }
//  }
}