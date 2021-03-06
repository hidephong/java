class Person(val name:String,var age:Int )
def person =new Person("Kumar",12)
(new Person("Kumar", 12)).age_=(20)
person.age_=(20)
println(person.age)

println((new Person("Kumar", 12)).age)

def age = 30
age
class A(a: Int) {
  val x = { println("x is set to something"); a }
  def y = { println("y is set to something"); a }
}

// Prints: x is set to something
val a = new A(1)


// Prints: "1"
println(a.x)


// Prints: "1"
println(a.x)

// Prints: "y is set to something" and "1"
println(a.y)


// Prints: "y is set to something" and "1"
println(a.y)



abstract class SemiGroup[A] {
  def add(x: A, y: A): A
}
abstract class Monoid[A] extends SemiGroup[A] {
  def unit: A
}
object ImplicitTest extends App {
  implicit object StringMonoid extends Monoid[String] {
    def add(x: String, y: String): String = x concat y
    def unit: String = ""
  }
  implicit object IntMonoid extends Monoid[Int] {
    def add(x: Int, y: Int): Int = x + y
    def unit: Int = 0
  }
  def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
    if (xs.isEmpty) m.unit
    else m.add(xs.head, sum(xs.tail))
  println(sum(List(1, 2, 3)))
  println(sum(List("a", "b", "c")))
}
val list = List(1,2,3,4)
val forloop = {for(i <- list; j <- list) yield (i,j)}.foreach(println)
val map = list.map{i => list.map{j => list.map{k => (i,j,k)}}}.foreach(_.foreach(_.foreach(println)))
val flatmap = list.flatMap(i => list.flatMap{j => list.map(k => (i,j,k))}).foreach(println)

 