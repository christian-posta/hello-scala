import java.io.File

object FileMatcher {
  private def filesHere = (new File(".")).listFiles

  def filesEnding(query: String) =
    for (file <- filesHere; if file.getName.endsWith(query))
      yield file

  def filesContaining(query: String) =
    for (file <- filesHere; if file.getName.contains(query))
      yield file

  def filesRegex(query: String) =
    for (file <- filesHere; if file.getName.matches(query))
      yield file

  def filesGeneric(matcher: (String) => Boolean ) =
    for (file <- filesHere; if matcher(file.getName))
      yield file

  def filesEnding2(query: String) =
    filesGeneric(_.endsWith(query))

}

println("Ending in fbr")
//FileMatcher.filesEnding(".fbr").foreach(println)
FileMatcher.filesEnding2("fbr").foreach(println)

println("Containing 'test'")
//FileMatcher.filesContaining("test").foreach(println)