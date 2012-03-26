var i = 0
var foundIt = false
val args2 = Array[String]("-filename.scala", "notfilename.scala", "nothing")

while (i < args2.length && !foundIt){
  if (!args2(i).startsWith("-")){
    if (args2(i).endsWith(".scala"))
      foundIt = true
  }

  if (!foundIt)
    i = i + 1
}

println("Found it: " + foundIt + " at position " + i + " [" + args2(i) + "]")
