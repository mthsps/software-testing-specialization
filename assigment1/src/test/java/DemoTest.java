import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * The class containing your tests for the {@link Demo} class.  Make sure you
 * test all methods in this class (including both 
 * {@link Demo#main(String[])} and 
 * {@link Demo#isTriangle(double, double, double)}).
 */
public class DemoTest {

    @Test
    public void is_triangle_1() {
        assertTrue(Demo.isTriangle(3, 4, 5));
    }

    @Test
    public void is_triangle_2() {
        assertTrue(Demo.isTriangle(5, 12, 13));
    }

    @Test
    public void is_triangle_3() {
        assertTrue(Demo.isTriangle(5, 13, 12));
    }

    @Test
    public void is_triangle_4() {
        assertTrue(Demo.isTriangle(13, 5, 12));
    }

    @Test
    public void is_triangle_5() {
        assertTrue(Demo.isTriangle(12, 13, 5));
    }

    @Test
    public void is_triangle_6() {
        assertTrue(Demo.isTriangle(10.55, 10.4343, 5.223));
    }

    @Test
    public void is_triangle_8() {
        assertTrue(Demo.isTriangle(10, 10, 5));
    }

    @Test
    public void is_triangle_7() {
        assertTrue(Demo.isTriangle(2147483647, 2147483647, 2147483647));
    }

    @Test
    public void test_is_triangle_9() {
        assertTrue(Demo.isTriangle(Double.MAX_VALUE+1, Double.MAX_VALUE+1000, Double.MAX_VALUE));
    }

    @Test
    public void test_is_triangle_10() {
        assertTrue(Demo.isTriangle(12, 13, 12));
    }


    @Test
    public void is_not_triangle_1() {
        assertFalse(Demo.isTriangle(10, 11, -12));
    }

    @Test
    public void is_not_triangle_2() {
        assertFalse(Demo.isTriangle(-12, 11, 10));
    }

    @Test
    public void is_not_triangle_3() {
        assertFalse(Demo.isTriangle(-12, 10, 11));
    }

    @Test
    public void is_not_triangle_4() {
        assertFalse(Demo.isTriangle(-10, -12, 11));
    }

    @Test
    public void is_not_triangle_5() {
        assertFalse(Demo.isTriangle(-10, -5, -12));
    }

    @Test
    public void is_not_triangle_6() {
        assertFalse(Demo.isTriangle(0, 13, 12));
    }

    @Test
    public void is_not_triangle_7() {
        assertFalse(Demo.isTriangle(-1, 13, 12));
    }

    @Test
    public void is_not_triangle_8() {
        assertFalse(Demo.isTriangle(1, 13, 18));
    }

    @Test
    public void is_not_triangle_9() {
        assertFalse(Demo.isTriangle(0, 0, 0));
    }

    @Test
    public void is_not_triangle_10() {
        assertFalse(Demo.isTriangle(-3, -3, -3));
    }

    @Test
    public void is_not_triangle_11() {
        assertFalse(Demo.isTriangle(-3, -3, -12));
    }

    @Test
    public void is_not_triangle_12() {
        assertFalse(Demo.isTriangle(-3.55, -3.88, -12.0333));
    }

    @Test
    public void is_not_triangle_13() {
        assertFalse(Demo.isTriangle(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
    }

    @Test
    public void is_not_triangle_14() {
        assertFalse(Demo.isTriangle(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
    }

    @Test
    public void is_not_triangle_15() {
        assertFalse(Demo.isTriangle(-2147483647, 2147483647, 2147483647));
    }

    @Test
    public void is_not_triangle_16() {
        assertFalse(Demo.isTriangle(-Double.MAX_VALUE, 2147483647, 2147483647));
    }

    @Test
    public void main_input_true() {
        String input = "1\n1\n1\n1\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String[] args = {};
        Demo.main(args);

        String consoleOutput = "Enter side 1: "  +  System.getProperty("line.separator");
        consoleOutput += "Enter side 2: " +  System.getProperty("line.separator");
        consoleOutput += "Enter side 3: " +  System.getProperty("line.separator");
        consoleOutput += "This is a triangle." +  System.getProperty("line.separator");

        assertEquals(consoleOutput, out.toString());
    }

    @Test
    public void main_input_false() {
        String input = "0\n1\n1\n1\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String[] args = {};
        Demo.main(args);

        String consoleOutput = "Enter side 1: "  +  System.getProperty("line.separator");
        consoleOutput += "Enter side 2: " +  System.getProperty("line.separator");
        consoleOutput += "Enter side 3: " +  System.getProperty("line.separator");
        consoleOutput += "This is not a triangle." +  System.getProperty("line.separator");

        assertEquals(consoleOutput, out.toString());
    }

    @Test(expected = InputMismatchException.class)
    public void main_input_error() {
        String input = "a\n1\n1\n1\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String[] args = {};
        Demo.main(args);

        String consoleOutput = "Enter side 1: "  +  System.getProperty("line.separator");
        consoleOutput += "Enter side 2: " +  System.getProperty("line.separator");
        consoleOutput += "Enter side 3: " +  System.getProperty("line.separator");
        consoleOutput += "This is not a triangle." +  System.getProperty("line.separator");

        assertEquals(consoleOutput, out.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void main_input_empty() {
        String input = "";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String[] args = {};
        Demo.main(args);

        String consoleOutput = "Enter side 1: "  +  System.getProperty("line.separator");
        consoleOutput += "Enter side 2: " +  System.getProperty("line.separator");
        consoleOutput += "Enter side 3: " +  System.getProperty("line.separator");
        consoleOutput += "This is not a triangle." +  System.getProperty("line.separator");

        assertEquals(consoleOutput, out.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void main_input_onearg() {
        String input = "1\n";

        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String[] args = {};
        Demo.main(args);

        String consoleOutput = "Enter side 1: "  +  System.getProperty("line.separator");
        consoleOutput += "Enter side 2: " +  System.getProperty("line.separator");
        consoleOutput += "Enter side 3: " +  System.getProperty("line.separator");
        consoleOutput += "This is not a triangle." +  System.getProperty("line.separator");

        assertEquals(consoleOutput, out.toString());
    }

}

