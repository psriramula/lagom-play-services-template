package controllers


import play.api.mvc._

import scala.concurrent.ExecutionContext

class PassivDataAPIService( controllerComponents: ControllerComponents)
          (implicit ec: ExecutionContext)
  extends AbstractController( controllerComponents) {

  def index = Action {
    Ok(views.html.index("here is your app."))
  }


}
