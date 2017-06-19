package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import play.api.Play.current
import play.api.db._
import play.api.mvc._
import play.api.i18n.Messages.Implicits._

import models.dao._

@Singleton
class OrderController @Inject() extends Controller {

  import DetailsForm._
  

  def baskettype = Action { implicit request =>
    val dao = DAOFactory.basketDAO
    val baskets = dao.all()
    Ok(views.html.baskettype(baskets))
  }
  
  def places(baskettype: String) = Action { implicit request =>
    Ok(views.html.places(baskettype))
  }
  
  def details(places: String, baskettype:String) = Action { implicit request =>
  
    Ok(views.html.details(baskettype, places, form))
  }

  def submit() = Action { implicit request =>
    Redirect(routes.OrderController.baskettype)
  }
}