import com.lightbend.lagom.scaladsl.api.{LagomConfigComponent, ServiceAcl, ServiceInfo}
import com.lightbend.lagom.scaladsl.client.LagomServiceClientComponents
import com.lightbend.lagom.scaladsl.devmode.LagomDevModeComponents
import com.softwaremill.macwire._
import com.typesafe.conductr.bundlelib.lagom.scaladsl.ConductRApplicationComponents
import controllers.{AssetsComponents, PlayServiceA}
import play.api.ApplicationLoader.Context
import play.api.libs.ws.ahc.AhcWSComponents
import play.api.{ApplicationLoader, BuiltInComponentsFromContext, Mode}
import play.filters.HttpFiltersComponents
import router.Routes

import scala.collection.immutable
import scala.concurrent.ExecutionContext

abstract class WebGateway(context: Context) extends BuiltInComponentsFromContext(context)
  with AssetsComponents  // future need
  with HttpFiltersComponents
  with AhcWSComponents
  with LagomConfigComponent
  with LagomServiceClientComponents {

  override lazy val serviceInfo: ServiceInfo = ServiceInfo(
    "play-service-a",

    Map(
      "play-service-a" -> immutable.Seq(ServiceAcl.forPathRegex("(?!/api/).*"))
    )
  )
  override implicit lazy val executionContext: ExecutionContext = actorSystem.dispatcher

  override lazy val router = {
    val prefix = "/service-a"
    wire[Routes]
  }


  lazy val main = wire[PlayServiceA]

}

class PlayServiceALoader extends ApplicationLoader {
  override def load(context: Context) = context.environment.mode match {
    case Mode.Dev =>
      (new WebGateway(context) with LagomDevModeComponents).application
    case _ =>
      (new WebGateway(context) with ConductRApplicationComponents).application
  }
}
