/**
 * Created by tuanna on 5/13/14.
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
  for (i <- 0 to arr.length-1) print(arr(i))
  println()
}
println("test init list and print all element")

time {
  val lst=  List.range(1, 10000)
  for (i <- 0 to lst.length-1) print(lst(i))
  println()
}
val arr= Array.range(1, 10000)
val lst=  List.range(1, 10000)

println("test time remove 2 element first")

time {
  val newArr = arr.filter( _ > 2)
}
time {
  val newList = lst.filter( _ > 2)
}
time {
  val newArr = arr.reverse
}
time {
  val newList = lst.reverse
}

println("test quicksort")


time {
val fruits = Array("cherry", "apple", "banana")
  scala.util.Sorting.quickSort(fruits)
fruits
}
time {

  def sort(a: Array[Int]) {

    def swap(i: Int, j: Int) {
      val t = a(i); a(i) = a(j); a(j) = t
    }
    def sort1(l: Int, r: Int) {
      val pivot = a((l + r) / 2)
      var i = l
      var j = r
      while (i <= j) {
        while (a(i) < pivot) i += 1
        while (a(j) > pivot) j -= 1
        if (i <= j) {
          swap(i, j)
          i += 1
          j -= 1
        }
      }
      if (l < j) sort1(l, j)
      if (j < r) sort1(i, r)
    }

    if (a.length > 0)
      sort1(0, a.length - 1)
  }

  def println(ar: Array[Int]) {
    def print1 = {
      def iter(i: Int): String =
        ar(i) + (if (i < ar.length-1) "," + iter(i+1) else "")
      if (ar.length == 0) "" else iter(0)
    }
    Console.println("[" + print1 + "]")
  }
  def main(args: Array[String]) {
    val ar = Array(6, 2, 8, 5, 1,11,32,2,3,5,2,1,9,43,2,12,3,7,6,8,3,4,5,6,7,8)
    println(ar)
    sort(ar)
    println(ar)
  }
}

time{

  object sort1 {
    def sort(a: List[Int]): List[Int] = {
      if (a.length < 2)
        a
      else {
        val pivot = a(a.length / 2)
        sort(a.filter(_ < pivot)) :::
          a.filter(_ == pivot) :::
          sort(a.filter(_ > pivot))
      }
    }
    def main(args: Array[String]) {
      val xs = List(6, 2, 8, 5, 1,11,32,2,3,5,2,1,9,43,2,12,3,7,6,8,3,4,5,6,7,8)
      println(xs)
      println(sort(xs))
    }
  }
}
//time{
//  val rows = 2
//  val cols = 3
//  val array = Array.ofDim[String](rows, cols)
//
//  a(0)(0) = "a"
//  a(0)(1) = "b"
//  a(0)(2) = "c"
//  a(1)(0) = "d"
//  a(1)(1) = "e"
//  a(1)(2) = "f"
//  for { i <- 0 until rows
//        j <-0 until cols
//  }
//    println(s"($i)($j) = ${a(i)(j)}")
//}

time{

  val a = Array( Array("a", "b", "c"), Array("d", "e","f"),Array("d", "e","f"),Array("a", "b", "c"), Array("d", "e","f"),Array("d", "e","f"),Array("a", "b", "c"), Array("d", "e","f"),Array("d", "e","f"),Array("a", "b", "c"), Array("d", "e","f"),Array("d", "e","f"))
}
time {
  def add2(x: Array[Long], y: Array[Long], agg: List[Long], counter: Int): List[Long] = {
    if (counter == 0) agg
    else add2(x, y, x(counter-1) + y(counter-1) :: agg, counter-1)
  }
     add2(Array(1,2), Array(3,4), Nil, 2)
}


time{
  def add(x: List[Long], y: List[Long], agg: List[Long]): List[Long] = x match {
    case Nil => agg.reverse
    case x1 :: xs => y match {
      case y1 :: ys => add(xs, ys,  x1 + y1 :: agg)
    }
  }
    add(List(1,2), List(3,4), Nil)
}
time{
  def add3(x: Array[Long], y: Array[Long], agg: Array[Long],i: Int): Array[Long] = {
    if (i == x.length) agg
    else {
      agg(i) = x(i) + y(i)
      add3(x, y, agg, i+1)
    }
  }
    add3(Array(1,2), Array(3,4), new Array(2), 0)
}

