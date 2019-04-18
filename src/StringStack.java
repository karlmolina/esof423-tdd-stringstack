/**
 * ESOF 423
 * Assignment 4
 * Karl Molina
 * 4/17/2018
 * Using test driven development to create a stack
 * that holds strings.
 */

/**
 * Array implementation of a stack that hold strings.
 *
 * @author Karl Molina
 */
public class StringStack {
    /**
     * The max size of the stack.
     */
    private int maxSize;

    /**
     * The array that holds the strings of the stack.
     */
    private String[] array;

    /**
     * The index of the array where the next string will be pushed.
     */
    private int index = 0;

    /**
     * String stack constructor. Creates empty stack,
     * with max size of 10.
     */
    public StringStack() {
        this(10);
    }

    /**
     * String stack constructor. Creates empty stack,
     * with a given max size.
     *
     * @param maxSize The maximum size of the stack.
     */
    public StringStack(int maxSize) {
        this.maxSize = maxSize;
        this.array = new String[maxSize];
    }

    /**
     * Pushes a new string onto the stack.
     *
     * @param s The string to push to the stack.
     */
    public void push(String s) {
        this.array[this.index] = s;
        this.index++;
    }

    /**
     * Removes the last string from the stack.
     * Returns null if the stack is empty.
     *
     * @return The last string on the stack.
     */
    public String pop() {
        return this.index > 0 ? this.array[--this.index] : null;
    }

    /**
     * Gets the max size of the stack.
     *
     * @return The stack's max size.
     */
    public int getMaxSize() {
        return this.maxSize;
    }

    /**
     * Gets the number of strings currently on the stack.
     *
     * @return The size of the stack.
     */
    public int getSize() {
        return this.index;
    }
}
