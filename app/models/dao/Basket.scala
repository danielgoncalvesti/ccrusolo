package models.dao

case class Basket(id: Int, name: String, urlfriendly: String, description: String, price: BigDecimal)

trait BasketDAO {
  def create(name: String, urlfriendly: String, description: String, price: BigDecimal)

  def all() : List[Basket]

  def findById(id: Int): Option[Basket]

  def findByName(urlName: String): Option[Basket]
}


