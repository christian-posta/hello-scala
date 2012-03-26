/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 2/20/12
 * Time: 9:45 AM
 * To change this template use File | Settings | File Templates.
 */

import scala.io.Source

// define a function that finds the length of a string, then finds the
// length of that int that represents the length of the string
def widthOfLength(s: String) = s.length.toString.length

if (args.length > 0){

  // note that functions don't need to have the () parens if there
  // are no params
  val fileLines = Source.fromFile(args(0)).getLines().toList

  // basically does a "reduce" starting with the leftmost items going right.
  // a reduce is comparing the first two elements, then using that value and the
  // next value in the list
  val longestLine = fileLines.reduceLeft((a, b) => if (a.length() > b.length()) a else b)
  val maxWidth = widthOfLength(longestLine)

  for (line <- fileLines) {
    val numSpaces = maxWidth - widthOfLength(line)
    val padding = " " * numSpaces
    println(padding + line.length() + "|" + line)
  }
}
else {
  Console.err.println("Please enter filename")
}