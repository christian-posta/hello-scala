// note, no equals sign, so must be a procedural

// note, no equals sign (and no return value) because this is a procedure (that has side effects)
def printMultiTable() {

  var i = 1
  // only i in scope here

  while (i <= 10){

    var j = 1
    // both i and j in scope here

    while (j <= 10){

      // use no parens if method has no side effects (convention)
      val prod = (i * j).toString
      // i, j, and prod in scope here

      // use no parens if method has no side effects (convention)
      var k = prod.length
      while(k < 4){
        print(" ")
        k += 1
      }

      print(prod)
      j += 1

    }

    // use parens because it does have side effects (IO)
    println()
    i += 1
  }
}

// first note, for it to be a functional style, it should return something
// and also have an equals sign
def multiTable(i: Int): String = {
  if (i == 1) multiRow(i).mkString(" " * 4)
  else {
    multiTable(i - 1) + "\n" + multiRow(i).mkString (" " * 4)
  }
}

def multiRow(j: Int) = {
  for ( i <- 1 to 10) yield (i * j)

}

def theirMultiTable() = {

  val tableSeq = {
    for (row <- 1 to 10)
      yield makeRow(row)
  }

  tableSeq.mkString("\n")
}

def makeRow(row: Int) = makeRowSeq(row).mkString

def makeRowSeq(row: Int) =
  for (col <- 1 to 10) yield {
    // note, avoiding temp vars doesn't mean vals, but vars
    // that mutate and change along with the looping...
    // this apparently is acceptable
    val prod = (row * col).toString
    val padding = " " * (4 - prod.length())
    prod + padding
  }



// run imperative style
//printMultiTable()

// run semi-functional
print(theirMultiTable)