import java.lang.AssertionError

var assertionEnabled = true
def myAssert(predicate: => Boolean) =
  if (assertionEnabled && !predicate)
    throw new AssertionError

// note, this expression (function) is not evaluated before it's sent, since
// it's passed as a function. it is not even evaluated if assertions are not
// enabled, that's the advantage to doing it like this
myAssert(5 > 3)