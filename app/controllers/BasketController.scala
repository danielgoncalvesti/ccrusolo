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
class BasketController @Inject() extends Controller {

  import BasketForm._

  def list = Action { implicit request =>
    val dao = DAOFactory.basketDAO
    val baskets = dao.all()
    Ok(views.html.basket_list("Lista das Cestas", baskets))
  }

  def remove(id: Int) = Action { implicit request =>
    val dao = DAOFactory.basketDAO
    dao.remove(id)
    Redirect(routes.BasketController.list)
  }

  def newbasket() = Action { implicit request =>
    Ok(views.html.basket_add(basketForm))
  }

  def add() = Action { implicit request =>
    basketForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.basket_add(formWithErrors))
      },
      basketData =>{
        print()
        val dao = DAOFactory.basketDAO
        dao.create(basketData.name, basketData.urlFriendly, basketData.description, basketData.price)
        Redirect(routes.BasketController.list)
      }
    )


  }
}
