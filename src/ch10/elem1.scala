package ch10
import Element.elem

abstract class Element {

  // parameterless methods
  // this is abstract cause it doesn't have any braces or equals sign
  // note that it's also immutable! it cannot be changed/reassigned
  def contents: Array[String]

  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length

  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height

    elem(
      for ( (line1, line2) <- this1.contents zip that1.contents )
        yield line1 + line2
    )
  }

  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width

    // the ++ concatenates two arrays! contents is of type Array[String]
    // result will be an array with two arrays in it
    elem(this1.contents ++ that1.contents)
  }

  def widen(w: Int): Element = {
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      var right = elem(' ', (w - width - left.width), height)

      // note the expressive, dsl-like syntax
      left beside this beside right
    }
  }

  def heighten(h: Int): Element = {
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height))
      val bot = elem(' ', width, (h - height - top.height))

      top above this above bot
    }
  }


  override def toString = contents mkString "\n"
}

object Element {

  /**
   * Make all classes "inner" or "private" classes since they will be accessed only by
   * the factory methods (this is a good thing as it suggests polymorphic behavior without
   * the clients knowing about it)
   */

  class ArrayElement(conts: Array[String]) extends Element {

    def contents: Array[String] = conts

  }

  // note, the parent class's primary constructor is called with the
  // param from the current class's primary constructor argument
  class LineElement(s: String) extends Element {
    // note, contents implements contents from Element (element has it as a paramless method,
    // but here when we override it, we change it to a field. Universal Access Principle says that
    // a client should not be able to tell the diff if an attribute is a method or field
    val contents = Array(s)

    override def width = s.length

    override def height = 1
  }

  class UniformElement(
                        ch: Char,
                        override val width: Int,
                        override val height: Int) extends Element {

    private val line = ch.toString * width

    // fill an array of dimension 1x (height) with expression (line)
    def contents = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element = new ArrayElement(contents)

  def elem(s: String): Element = new LineElement(s)

  def elem(ch: Char, width: Int, height: Int) = new UniformElement(ch, width, height)
}


object Spiral {
  val space = elem(" ")
  val corner = elem("+")

  def spiral(nEdges: Int,  direction: Int): Element = {
    if (nEdges == 1)
      elem("+")
    else {
      val sp = spiral(nEdges - 1, (direction + 3) % 4)

      def verticalBar = elem('|', 1, sp.height)

      def horizontalBar = elem('-', sp.width, 1)

      if (direction == 0)
        (corner beside horizontalBar) above (sp beside space)
      else if (direction == 1)
        (sp above space) beside (corner above verticalBar)
      else if (direction == 2)
        (space beside sp) above (horizontalBar beside corner)
      else
        (verticalBar above corner) beside (space above sp)
    }
  }

  def main(args: Array[String]) {
    val nSides = args(0).toInt
    println(spiral(nSides, 0))
  }
}
