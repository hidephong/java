/**
 * Created by tuanna on 5/16/14.
 */
import scala.math._
class Complex(a: Double, b:Double) {
  require(b != 0)

  val rez: Double = a
  val imz: Double = b

  def this(n: Double) = this(n, 0)

  private def squared(s:Double)=
    { s * s }

  def add(that: Complex): Complex =
    new Complex(
      rez+ that.rez ,
      imz + that.imz
    )

  def + (that: Complex): Complex =
    new Complex(
      rez+ that.rez ,
      imz + that.imz
    )

  def - (that: Complex): Complex =
    new Complex(
      rez - that.rez ,
      imz - that.imz
    )
  def * (that: Complex): Complex =
    new Complex(
      this.rez*that.rez - this.imz*that.imz ,
      this.rez*that.imz +  this.imz*that.rez
    )

  def / (that: Complex): Complex =
  new Complex(
    (this.rez*that.rez + this.imz*that.imz)/(squared(that.rez) + squared(that.imz)) ,
    (this.imz*that.rez -  this.rez*that.imz)/(squared(that.rez) + squared(that.imz))
  )

  def equals (that: Complex): Boolean =
  {
    if ((this.rez == that.rez)&&(this.imz == that.imz)) true else false
  }

  def conjugate() : Complex =
      new Complex(this.rez,-this.imz)

  def inverse() : Complex =
    new Complex(a/(squared(this.rez)+squared(this.imz)),-b/(squared(this.rez)+squared(this.imz)))

  private def abs(): Double =
       sqrt(squared(this.rez)+squared(this.imz))

  def modulus(): Double =
        this.abs()

  def sgn(i:Double):Double =
      if(i>=0) 1 else -1


  def squareRoot(): Complex =
    new  Complex( sqrt((this.rez+this.modulus)/2),sgn(this.imz)* sqrt((-this.rez+this.modulus)/2))


  override def toString =if(b>=0) {
    a + " + " + b+"i"
  }
  else
  {
    a + " - " + (-b)+"i"
  }
}
val c= new Complex(1,1)
val d= new Complex(3,4.3)
val e = new Complex(3,4.3)
c.squareRoot
d.squareRoot*e.squareRoot
e equals d
e.equals(c)
println("addition (" + c.rez + " + " + c.imz + "i) + ("+ d.rez + " + " + d.imz + "i)")

val a = c + d
println("\n")
println("substraction (" + c.rez + " + " + c.imz + "i) - ("+ d.rez + " + " + d.imz + "i)")



val s = c - d
println("\n")
println("multiplication (" + c.rez + " + " + c.imz + "i) * ("+ d.rez + " + " + d.imz + "i)")



val m = c * d
println("\n")
println("division (" + c.rez + " + " + c.imz + "i) / ("+ d.rez + " + " + d.imz + "i)")

val n = c / d
println("\n")

