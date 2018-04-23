package controllers

object DetailsForm {
  import play.api.data.Forms._
  import play.api.data.Form

  case class Data(place: String, urlFriendly: String, name: String, email: String)

  val form = Form(
    mapping(
      "place"-> nonEmptyText,
      "urlFriendly"-> nonEmptyText,
      "name" -> nonEmptyText,
      "email" -> nonEmptyText
    )(Data.apply)(Data.unapply)
  )
}
