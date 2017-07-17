package models.dao.anorm

import anorm.SqlParser._
import anorm._

import play.api.db._
import play.api.Play.current
import models.dao.{Basket, BasketDAO}

object AnormBasketDAO extends BasketDAO {
  val basket = {
    int("id") ~ str("name") ~ str("urlfriendly") ~ str("description") ~ get[java.math.BigDecimal]("price") map {
      case id~name~urlfriendly~description~price => Basket(id, name, urlfriendly, description, price)
    }
  }

  def create(name: String, urlfriendly: String, description: String, price: BigDecimal) = 
    DB.withConnection { implicit c =>
      SQL("INSERT INTO basket(name, urlfriendly, description, price) VALUES({name}, {urlfriendly}, {description}, {price})").on(
        'name -> name, 
        'urlfriendly -> urlfriendly, 
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

  def findByName(urlfriendly: String): Option[Basket] = DB.withConnection { implicit c =>
    SQL("SELECT * FROM basket WHERE urlfriendly = {urlfriendly}").on('urlfriendly -> urlfriendly).as(basket singleOpt)
  }

  def remove(id: Int) = DB.withConnection { implicit c =>
    SQL("DELETE FROM basket WHERE id = {id}").on('id -> id).executeUpdate()
  }
}
