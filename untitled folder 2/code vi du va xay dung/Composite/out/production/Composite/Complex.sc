/**
 * Created by tuanna on 5/16/14.
 */
import scala.math._
class Complex(a: Double, b:Double) {
  require(b != 0)
  val real: Double = a
  val imag: Double = b
  def this(n: Double) = this(n, 0)

  private def squared(s:Double)=
    { s * s }

  def add(that: Complex): Complex =
    new Complex(
      real+ that.real ,
      imag + that.imag
    )

  def + (that: Complex): Complex =
    new Complex(
      real+ that.real ,
      imag + that.imag
    )

  def - (that: Complex): Complex =
    new Complex(
      real - that.real ,
      imag - that.imag
    )
  def * (that: Complex): Complex =
    new Complex(
      this.real*that.real - this.imag*that.imag ,
      this.real*that.imag +  this.imag*that.real
    )

  def / (that: Complex): Complex =
  new Complex(
    (this.real*that.real + this.imag*that.imag)/(squared(that.real) + squared(that.imag)) ,
    (this.imag*that.real -  this.real*that.imag)/(squared(that.real) + squared(that.imag))
  )

  def equals (that: Complex): Boolean =
  {
    if ((this.real == that.real)&&(this.imag == that.imag)) true else false
  }

  def conjugate() : Complex =
      new Complex(this.real,-this.imag)

  def inverse() : Complex =
    new Complex(a/(squared(this.real)+squared(this.imag)),-b/(squared(this.real)+squared(this.imag)))

  private def abs(): Double =
       sqrt(squared(this.real)+squared(this.imag))

  def modulus(): Double =
        this.abs()

  def sgn(i:Double):Double =
      if(i>=0) 1 else -1


  def squareRoot(): Complex =
    new  Complex( sqrt((this.real+this.modulus)/2),sgn(this.imag)* sqrt((-this.real+this.modulus)/2))


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

e equals d
e.equals(c)

println("addition (" + c.real + " + " + c.imag + "i) + ("+ d.real + " + " + d.imag + "i)")
val a = c + d
println("\n")
println("substraction (" + c.real + " + " + c.imag + "i) - ("+ d.real + " + " + d.imag + "i)")

val s = c - d
println("\n")
println("multiplication (" + c.real + " + " + c.imag + "i) * ("+ d.real + " + " + d.imag + "i)")

val m = c * d
println("\n")
println("division (" + c.real + " + " + c.imag + "i) / ("+ d.real + " + " + d.imag + "i)")

val n = c / d
println("\n")

