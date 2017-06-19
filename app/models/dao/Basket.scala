package models.dao

case class Basket(id: Int, name: String, description: String, price: Double)

trait BasketDAO {
  def all() : List[Basket]
}
