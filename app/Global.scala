 import models.dao.anorm._
 import play.api._
 import org.h2.jdbc.JdbcSQLException

  object Global extends GlobalSettings {
    override def onStart(app: Application) = try {
     InsertData.insert()
    } catch {
      case e: JdbcSQLException => //ignored
    }
  }

  object InsertData {
    def insert() = {
      Seq(
        ("Cesta Básica", "cestabasica", "alface, cenoura, repolho", 10.0),
        ("Cesta Completa", "cestacompleta", "cafe, cebola, arroz", 12.0)).foreach {
          case (name, urlfriendly, description, price) => AnormBasketDAO.create(name, urlfriendly, description, price)
        }
    }
 } 
