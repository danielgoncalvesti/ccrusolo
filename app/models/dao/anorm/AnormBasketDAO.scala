package models.dao.anorm

import anorm.SqlParser._
import anorm._

import play.api.db._
import play.api.Play.current
import models.dao.{Basket, BasketDAO}

object AnormBasketDAO extends BasketDAO {
  val basket = {
    int("id") ~ str("name") ~ str("urlFriendly") ~ str("description") ~ get[java.math.BigDecimal]("price") map {
      case id~name~urlFriendly~description~price => Basket(id, name, urlFriendly, description, price)
    }
  }

  def create(name: String, urlFriendly: String, description: String, price: BigDecimal) = 
    DB.withConnection { implicit c =>
      SQL("INSERT INTO basket(name, urlFriendly, description, price) VALUES({name}, {urlFriendly}, {description}, {price})").on(
        'name -> name, 
        'urlFriendly -> urlFriendly, 
        'description -> description, 
        'price -> price.bigDecimal
      ).executeUpdate()    
    }

  def all() : List[Basket] = DB.withConnection { implicit c =>
    SQL("SELECT * FROM basket").as(basket *)
  }

  def findById(id: Int): Option[Basket] = DB.withConnection { implicit c =>
    SQL("SELECT * FROM basket WHERE id = {id}").on('id -> id).as(basket singleOpt)
  }

  def findByName(urlFriendly: String): Option[Basket] = DB.withConnection { implicit c =>
    SQL("SELECT * FROM basket WHERE urlFriendly = {urlFriendly}").on('urlFriendly -> urlFriendly).as(basket singleOpt)
  }

  def remove(id: Int) = DB.withConnection { implicit c =>
    SQL("DELETE FROM basket WHERE id = {id}").on('id -> id).executeUpdate()
  }
}
