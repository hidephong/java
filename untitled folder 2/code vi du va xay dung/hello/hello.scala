import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
class HelloActor extends Actor {
  def receive = {
    case "hello" => println("hello back at you")
    case "meo" => println("go go")
    case _ => println("huh?")
  }
}
object Main extends App {
  // an actor needs an ActorSystem
  val system = ActorSystem("HelloSystem") // create and start the actor
  val helloActor = system.actorOf(Props[HelloActor], name = "helloactor")
  // send the actor two messages
  helloActor ! "hello"
  helloActor ! "buenos dias"
  helloActor ! "meo"
  // shut down the system
  system.shutdown
}
