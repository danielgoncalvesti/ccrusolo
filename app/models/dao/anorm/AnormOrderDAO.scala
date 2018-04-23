package models.dao.anorm

import anorm.SqlParser._
import anorm._

import play.api.db._
import play.api.Play.current
import models.dao.{Order, OrderDAO}

object AnormOrderDAO extends OrderDAO {
  val order = {
    int("id") ~ str("place") ~ str("urlFriendly") ~ str("name") ~ str("email") map {
      case id~place~urlFriendly~name~email => Order(id, place, urlFriendly, name, email)
    }
  }

  def create(place: String, urlFriendly: String, name: String, email: String) =
    DB.withConnection { implicit c =>
      SQL("INSERT INTO order_basket(place, urlFriendly, name, email) VALUES({place}, {urlFriendly}, {name}, {email})").on(
        'place -> place,
        'urlFriendly -> urlFriendly,
        'name -> name,
        'email -> email
      ).executeUpdate()
    }

  def all() : List[Order] = DB.withConnection { implicit c =>
    SQL("SELECT * FROM order_basket").as(order *)
  }

}


