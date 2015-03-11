package models

/**
 * Created by tuanna on 5/15/14.
 */
class Person(name: String)
object Person {
  def getAll = List(Person("Al"),Person("Darren"),Person("Rich"))
}

