  package controllers

  object BasketForm {
    import play.api.data._
    import play.api.data.Forms._
  
    case class BasketData(name: String, urlFriendly: String, description: String, price: BigDecimal)

    val basketForm = Form(
      mapping(
        "name" -> text,
        "urlFriendly" -> text,
        "description" -> text, 
        "price" -> bigDecimal
      )(BasketData.apply)(BasketData.unapply)
    )
  }