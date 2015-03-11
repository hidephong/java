/**
 * Created by tuanna on 5/14/14.
 */


val x2 = (i : Int) => {
println("demo function val")
  i * 2
}

var x3 = (i : Int) => {
  println("demo function var")
  i * 3
}
def x4 = (i : Int) => {
  println("demo function def")
    i * 4
}

x2(2)



x3(2)


x4(2)


x3 = (i : Int) => {
  println("demo function var")
  i * 5
}
x3(2)

val test: () => Int = {
  val r = util.Random.nextInt
  () => r
}
test()
test()
def test1: () => Int = {
  val r = util.Random.nextInt
  () => r
}
test1()
test1()

var test2: () => Int = {
  val r = util.Random.nextInt
  () => r
}
test2()
test2()