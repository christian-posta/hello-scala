/**
 * 
 * @author: ceposta
 */
import scala.collection.mutable.Map
/**
 *
 * @author: ceposta
 */
// a companion class to the companion object singleton
// note, in scala, classes cannot have static methods, but can refer to
// a companion object which can (all methods for a companion object are therefore
// static since it's a singleton and only one instance can exist)

// an "object" is a singleton. it's considered a companion object
// to the class with the same name
object ChecksumAccumulator {
  private val cache = Map[String, Int]()

  // if it has an = sign in the function spec,
  // it returns a value. otherwise, it's a procedure and doesn't
  // return a value
  // notice that no braces needed since it's actually just a one-line 'if' statement
  def calculate(s: String): Int =
    if (cache.contains(s))
      // automatically returns this since it's the last statement
      cache(s)
    else {
      val acc = new ChecksumAccumulator
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)

      // automatically returns this since it's the last statement
      cs
    }

}

class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = {
    sum += b
  }

  def checksum(): Int = {
    return ~(sum & 0xFF) + 1
  }

  override def toString = sum.toString
}