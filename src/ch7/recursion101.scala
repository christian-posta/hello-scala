
/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 3/8/12
 * Time: 9:47 AM
 * To change this template use File | Settings | File Templates.
 */
// note, this is head recursion since there are still computations AFTER the recursive
// call (the 1 is added to the return value) so the stack frame must be kept around
// tail recursion has the recursive call last, and there is not need for the stack
// frame to stay around, just sue the current/same one
def listLength1(list: List[_]): Int = {
  if (list == Nil) 0
  else 1 + listLength1(list.tail)
}

var list1 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
var list2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
list1.exists()

1 to 15 foreach (x => list2 = list2 ++ list2)

def listLength2(list: List[_]): Int = {
  def list2Helper(list: List[_], len: Int): Int = {
    if (list == Nil) len
    else list2Helper(list.tail, len + 1)
  }

  list2Helper(list, 0)
}

println( listLength2(list1) )
println( listLength2(list2) )