
/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 3/8/12
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */

import scala.io.Source
object LongLines {

  // note, no equals sign after func dec, so must be procedural
  def processFile(filename: String, width: Int) {
    // function within another function. only visible within this
    // scope
    // dont need the filename arg here, because the parent function
    // has it (and all params are vals)
    def processLine(line: String){
      if (line.length() > width)
        println(filename + ": " + line.trim())
    }

    val source = Source.fromFile(filename)

    // call the internal/local function
    for (line <- source.getLines())
      processLine(line)
  }


}

// objects are singletons with static members. must have a main func to run a program
object FindLongLines {
  def main(args: Array[String]) {
    val width = args(0).toInt
    for (arg <- args.drop(1))
      LongLines.processFile(arg, width)

  }

}