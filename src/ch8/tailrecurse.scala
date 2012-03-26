
/**
 * Created by IntelliJ IDEA.
 * User: ceposta
 * Date: 3/12/12
 * Time: 9:02 AM
 * To change this template use File | Settings | File Templates.
 */

// not tail recursive
def boom(x: Int): Int = {
  if (x == 0) throw new Exception("Boom!")
  else boom(x - 1) + 1
}


// tail recursive, but not very helpful stack trace (however can turn off tail-call-elim with -g:notailcalls)
def bang(x: Int): Int = {
  if (x == 0) throw new Exception("Boom!")
  else bang(x - 1)
}

bang(3)