package controllers

import play.api.mvc._
/**
 * Created by tuanna on 5/29/14.
 */
object FindJobs  extends Controller{
  def details = Action {
    Ok(views.html.details("lamngay"))
  }

  def search= Action {
    Ok(views.html.search("lamngay"))
  }
}
