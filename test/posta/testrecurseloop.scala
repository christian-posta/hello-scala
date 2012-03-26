val args2 = Array[String]("-filename.scala", "notfilename.scala", "nothing")

def searchFrom(i: Int): Int =
  if (i >= args2.length) -1
  else if (args2(i).startsWith("-")) searchFrom(i + 1)
  else if (args2(i).endsWith(".scala")) i
  else searchFrom(i + 1)

val i = searchFrom(0)

println("Found it: at position " + i + " [" + args2(i) + "]")
