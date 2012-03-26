import java.io.{File, PrintWriter}
import java.util.Date

def withPrintWriter(file: File)(op: PrintWriter => Unit) {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  }
  finally {
    writer.close()
  }
}

withPrintWriter(new File("test.fbr")) {
  _.println(new java.util.Date())
}