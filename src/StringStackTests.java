/**
 * ESOF 423
 * Assignment 4
 * Karl Molina
 * 4/17/2018
 * Using test driven development to create a stack
 * that holds strings.
 */

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the StringStack class.
 *
 * @author Karl Molina
 * @see StringStack
 */
public class StringStackTests {
    /**
     * Tests creating a new StringStack with no parameters
     * makes an empty stack with a max size of 10.
     */
    @Test
    public void createEmptyStack() {
        StringStack stack = new StringStack();
        assertEquals(0, stack.getSize());
        assertEquals(10, stack.getMaxSize());
    }

    /**
     * Verifies that creating a stack with a negative
     * max size throws an exception.
     */
    @Test(expected = NegativeArraySizeException.class)
    public void createStackNegativeSize() {
        StringStack stack = new StringStack(-1);
    }

    /**
     * Tests creating a stack with a max size of 5.
     */
    @Test
    public void createSize5() {
        StringStack stack = new StringStack(5);
        assertEquals(0, stack.getSize());
        assertEquals(5, stack.getMaxSize());
    }

    /**
     * Tests pushing to the stack increases the stack's size.
     */
    @Test
    public void pushToStack() {
        StringStack stack = new StringStack();
        stack.push("hello");
        assertEquals(1, stack.getSize());
    }

    /**
     * Verifies that pushing more strings than the max size throws
     * an exception.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void pushOverMaxSize() {
        StringStack stack = new StringStack(1);
        stack.push("hi");
        stack.push("hi");
    }

    /**
     * Tests filling the stack to the max size does not throw
     * an exception.
     */
    @Test
    public void pushToMaxSize() {
        StringStack stack = new StringStack(1);
        stack.push("hi");
    }

    /**
     * Tests popping a string from the stack.
     */
    @Test
    public void popStack() {
        StringStack stack = new StringStack();
        stack.push("hello");
        String result = stack.pop();
        assertEquals("hello", result);
        assertEquals(0, stack.getSize());
    }

    /**
     * Tests that popping an empty stack returns null.
     */
    @Test
    public void popEmptyStack() {
        StringStack stack = new StringStack();
        String result = stack.pop();
        assertNull(result);
        assertEquals(0, stack.getSize());
    }

    /**
     * Tests getting the size of the stack.
     */
    @Test
    public void getSize() {
        StringStack stack = new StringStack();
        assertEquals(0, stack.getSize());
        for (int i = 0; i < 5; i++) {
            stack.push("test");
        }

        assertEquals(5, stack.getSize());

        while (stack.getSize() != 0) {
            stack.pop();
        }

        assertEquals(0, stack.getSize());
    }

    /**
     * Verifies that the size remains correct if you try to push
     * above max size.
     */
    @Test
    public void getSizePastMaxSize() {
        StringStack stack = new StringStack(1);
        stack.push("hi");
        try {
            stack.push("hi");
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals(1, stack.getSize());
        }
    }
}
