package controllers

object DetailsForm {
  import play.api.data.Forms._
  import play.api.data.Form

  case class Data(name: String, email: String)

  val form = Form(
    mapping(
      "name" -> nonEmptyText,
      "email" -> nonEmptyText
    )(Data.apply)(Data.unapply)
  )
}