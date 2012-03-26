//A valid sudoku square satisfies these
//two properties:

//   1. Each column of the square contains
//       each of the numbers from 1 to n exactly once.

//   2. Each row of the square contains each
//       of the numbers from 1 to n exactly once.
val correct = List( 
                List(1,2,3),
                List(2,3,1),
                List(3,1,2)
              )

val incorrect = List(
                  List(1,2,3,4),
                  List(2,3,1,3),
                  List(3,1,2,3),
                  List(4,4,4,4)
                )

val aList = List(
              List(1,2,3),
              List(2,3,1),
              List(3,1,2)
            )

val aBadList = List(
                List(1,2,3),
                List(3,2,1),
                List(1,1,1)
              )

val aBadColList = List(
                    List(1,2,3),
                    List(2,3,1),
                    List(3,1,1)
                  )

val aBadList2 = List(
                  List(1,2,3,4),
                  List(3,2,4,1),
                  List(4,3,2,1),
                  List(1,3,2,5)
                )

def convertCols(square: List[List[Int]]) = {
  for (i <- 0 to square.length-1 toList) yield {
    for (row <- square) yield row(i)
  }
}

def checkRows(row: List[Int]): Boolean = {
  def internalCheckRows(index: Int,  expected: Boolean = true): Boolean =  {
    if (index == 0 || !expected) expected
    else internalCheckRows(index - 1, row.contains(index))
  }

  internalCheckRows(row.length)
}

def checkSudoku(square: List[List[Int]]): Boolean = {
  val cols = convertCols(square)
  val rows, cols2 = checkRows(square) && checkRows(cols)
  print(rows, cols2)
  rows && cols2
}


print(checkSudoku(incorrect))