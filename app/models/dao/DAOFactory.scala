package models.dao

import models.dao.anorm._

object DAOFactory {
  def basketDAO: BasketDAO = AnormBasketDAO
  def orderDAO: OrderDAO = AnormOrderDAO
}
