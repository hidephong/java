import scala.math._


/**
 * Created by tuanna on 5/17/14.
 */
class Complex(a: Double, b: Double) {
  require(a != 0 || b != 0)
  val rez: Double = a
  val imz: Double = b

  println("Created " + this.toString)

  def this(n: Double) = this(n, 0)

  private def squared(s:Double)=
  { s * s }

  private def abs(): Double =
    sqrt(squared(this.rez)+squared(this.imz))

  private def sgn(i:Double):Double =
    if(i>=0) 1 else -1

  def add(that: Complex): Complex =
    new Complex(
      rez+ that.rez ,
      imz + that.imz
    )

  def + (that: Complex): Complex =
      this.add(that)

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
      (this.imz*that.rez - this.rez*that.imz)/(squared(that.rez) + squared(that.imz))
    )

  def equals (that: Complex): Boolean =
  {
    if ((this.rez == that.rez)&&(this.imz == that.imz)) true else false
  }
  def conjugate() : Complex =
    new Complex(this.rez,-this.imz)
  def inverse() : Complex =
    new Complex(a/(squared(this.rez)+squared(this.imz)),-b/(squared(this.rez)+squared(this.imz)))


  def modulus(): Double =
    this.abs()

  def squareRoot(): List[Complex] =
  {
    val sqrt1 = new  Complex( sqrt((this.rez+this.modulus)/2),sgn(this.imz)* sqrt((-this.rez+this.modulus)/2))
    val sqrt2 = new  Complex( -sqrt((this.rez+this.modulus)/2),sgn(-this.imz)* sqrt((-this.rez+this.modulus)/2))
    val lst = List(sqrt1,sqrt2)
   return lst
  }


  override def toString = if (b >= 0) {
    String.format("%2.2f  +  %2.2f",a.asInstanceOf[Object],b.asInstanceOf[Object])+"i"
  }
  else {
    "%2.2f  - %2.2f".format(a,-b)+"i"
  }
}

val c = new Complex(1, 1)
val d = new Complex(3,4.3)
c + d

c - d

c * d

c / d

c.conjugate

c equals d
c.equals(c)
c.inverse


c.modulus
c.squareRoot



c.toString





