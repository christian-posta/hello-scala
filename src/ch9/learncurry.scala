def process[A](filter: A=>Boolean)(list: List[A]): List[A]  = {

  lazy val recurse = process(filter) _

  list match {
    case head::tail => if (filter(head)) {
      head::recurse(tail)
    } else {
      recurse(tail)
    }

    case Nil => Nil
  }
}

val even = (a: Int) => a % 2 == 0
val processEven = process(even) _

val numbersAsc = 1::2::3::4::5::Nil
val numbersDsc = 5::4::3::2::1::Nil

println(processEven(numbersAsc))
println(processEven(numbersDsc))