package models.dao.anorm

import anorm.SqlParser._
import anorm._

import play.api.db._
import play.api.Play.current
import models.dao.{Basket, BasketDAO}

object AnormBasketDAO extends BasketDAO {
  val basket = {
    int("id") ~ str("name") ~ str("description") ~ double("price") map {
      case id~name~description~price => Basket(id, name, description, price)
    }
  }

  def all() : List[Basket] = DB.withConnection { implicit c =>
    play.api.Logger.info("bla")
    SQL("SELECT * FROM basket").as(basket *)
  }
}
