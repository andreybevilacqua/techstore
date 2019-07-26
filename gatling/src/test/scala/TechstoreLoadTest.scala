import java.net.HttpURLConnection

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._
import scala.concurrent.duration._

class TechstoreLoadTest extends Simulation {
  val rampUpTimeSecs = 5
  val testTimeSecs = 60
  val numberOfUsers = 200
  val numberOfRequestsPerSeconds = 1000

  val baseURL = "http://localhost:8080"
  val productsPath = "/products"

  object CreateAndLoadProduct {
    val load = exec(http("LoadProducts")
      .get(productsPath)
      .check(status.is(HttpURLConnection.HTTP_OK)))
  }

  val httpProtocol = http.baseUrl(baseURL).acceptHeader("application/json").userAgentHeader("Gatling")
  val testScenario = scenario("LoadTest")
    .during(testTimeSecs) {
      exec(CreateAndLoadProduct.load)
    }

  setUp(testScenario.inject(atOnceUsers(numberOfUsers)))
    .throttle(
      reachRps(numberOfRequestsPerSeconds) in (rampUpTimeSecs.seconds),
      holdFor(testTimeSecs.seconds))
    .protocols(httpProtocol)
}