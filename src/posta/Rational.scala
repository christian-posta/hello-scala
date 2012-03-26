package posta

/**
 * 
 * A class that represents a rational number in the
 * mathematical sense
 *
 */
class Rational(n: Int, d: Int) {
  // precondition for creating a Rational class: d cannot be zero
  // require will throw an InvalidArgumentException if d is zero
  require(d != 0)
  private val g: Int = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(numer: Int) = this(numer, 1)

  override def toString = this.numer + "/" + this.denom

  def + (that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def + (i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def - (that: Rational): Rational =
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )

  def - (i: Int): Rational =
    new Rational(numer - i * denom, denom)

  def * (that: Rational): Rational =
    new Rational(
      numer * that.numer,
      denom * that.denom
    )

  def * (i: Int): Rational =
    new Rational(numer * i,  denom)

  def / (that: Rational) : Rational =
    new Rational(numer * that.denom, denom * that.numer)

  def / (i: Int): Rational =
    new Rational(numer, denom * i)


  def lessThan(that: Rational) = this.numer * that.denom < that.numer * this.denom
  def max(that: Rational) = if (lessThan(that)) that else this

  // note, for a recursive function, you MUST declare a return type
  private def gcd(a: Int,  b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

}
