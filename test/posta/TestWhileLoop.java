package posta;

import org.junit.Test;

/**
 * @author: ceposta
 */
public class TestWhileLoop {

    @Test
    public void testFoo(){
        int i = 0;
        boolean foundIt = false;
        String[] args2 = new String[]{ "-filename.scala", "notfilename.scala", "nothing"};

        while (i < args2.length) {
            if (args2[i].startsWith("-")) {
                i = i + 1;
                continue;
            }

            if (args2[i].endsWith(".scala")) {
                foundIt = true;
                break;
            }

            i = i + 1;
        }

        System.out.println("Found it: " + foundIt + " at position " + i + " [" + args2[i] + "]");
    }
}
