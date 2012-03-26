import java.io.File

/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 2/10/12
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
val filesHere = (new File("./src/posta").listFiles())

def fileLines(file : File) =
  scala.io.Source.fromFile(file).getLines().toList

def grep(pattern: String) =

  // an example with multiple loops
  for {
    file <- filesHere
    if file.getName.endsWith(".scala");
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(pattern)
  } println(file + ": " + trimmed)

grep(".*gcd.*")
