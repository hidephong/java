/**
 * Created by tuanna on 5/17/14.
 */

import akka.actor._
case object PingMessage
case object PongMessage
case object StartMessage
case object StopMessage
class Ping(pong: ActorRef) extends Actor {
  var count = 0
  def incrementAndPrint { count += 1; println("ping") }
  def receive = {
    case StartMessage =>
      incrementAndPrint
      pong ! PingMessage 
    case PongMessage =>
      incrementAndPrint
      if (count > 10) {
        sender ! StopMessage
        println("ping stopped")
        context.stop(self) }
      else {
        sender ! PingMessage
      }
    case _ => println("Ping got something unexpected.") }
}

class Pong extends Actor {
  def receive = {
    case PingMessage =>
      println(" pong")
      sender ! PongMessage
    case StopMessage =>
      println("pong stopped")
      context.stop(self)
    case _ => println("Pong got something unexpected.")
  }
}
object Main3 extends App {
  val system = ActorSystem("PingPongSystem")
  val pong = system.actorOf(Props[Pong], name = "pong")
  val ping = system.actorOf(Props(new Ping(pong)), name = "ping")
  // start the action
  ping ! StartMessage
  Thread.sleep(5000)
  system.shutdown
}