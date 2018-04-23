package models.dao

case class Order(id: Int, place: String, urlFriendly: String, name: String, email: String)

trait OrderDAO {
  def create(place: String, urlFriendly: String, name: String, email: String)

  def all() : List[Order]

}
