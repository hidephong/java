package controllers

/**
 * Created by tuanna on 4/23/14.
 */
import play.api.mvc.{Action,Controller}
import models.Product
object Products extends Controller{
def list=Action{implicit request =>
val products=Product.findAll
Ok(views.html.products.list(products))
}
}
