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

  def places(urlName: String) = Action { implicit request =>
    val dao = DAOFactory.basketDAO
    dao.findByName(urlName) match {
      case Some(basket) => Ok(views.html.places(basket))
      case None => NotFound("Não existe")

    }
  }

  def details(places: String, urlFriendly: String) = Action { implicit request =>
    Ok(views.html.details(urlFriendly, places, form))
  }

  def submit = Action { implicit request =>

    Redirect(routes.OrderController.baskettype)
  }

}
