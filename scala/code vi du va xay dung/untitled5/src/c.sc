/**
 * Created by tuanna on 5/14/14.
 */
def time[A](a: => A) = {
  val now = System.nanoTime
  val result = a
  val micros = (System.nanoTime - now)/1000
  println("%d microseconds".format(micros))
  result

}

println("test init array and print all element")



time {
  val arr= Array.range(1, 10000)
  for (i <- 0 to arr.length-1) yield(arr.drop(i))
  println()
}
println("test init list and print all element")




time {
  val lst=  List.range(1, 10000)
  for (i <- 0 to lst.length-1) yield(lst.drop(i))
  println()
}
time {
val list1 = List("This","is")
val list2 = List("a","list")
val list3 = list1 ::: list2
val list4 = "Hey!" :: list3
println(list1)
println(list2)
println(list3)
println(list4)
}
time{
val list1 = Array("This","is")
val list2 = Array("a","list")
val list3 = list1 ++ list2
val list4 = "Hey!" ++ list3
println(list1)
println(list2)
println(list3)
println(list4)
}