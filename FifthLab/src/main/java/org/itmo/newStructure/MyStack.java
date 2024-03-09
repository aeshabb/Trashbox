package org.itmo.newStructure;

import java.util.LinkedList;
import java.util.List;

/**
 * @author aeshabb
 * Структура данных для хранения stack.
 * @param <T>
 */
public class MyStack<T> {
    LinkedList<T> stack = new LinkedList<>();

    /**
     *
     * @param element
     * @return
     */
    public T push(T element) {
        stack.add(element);
        return element;
    }

    /**
     *
     * @return
     */
    public int size() {
        return stack.size();
    }

    /**
     *
     * @return
     */
    public T pop() {
        return stack.pop();
    }

    /**
     *
     * @param startIndex
     * @param endIndex
     * @return
     */
    public List<T> subList(int startIndex, int endIndex) {
        return stack.subList(startIndex, endIndex);
    }

    /**
     *
     * @param index
     * @return
     */
    public T get(int index) {
        return stack.get(index);
    }

    /**
     *
     * @return
     */
    public T peek() {
        return stack.peek();
    }

    /**
     *
     * @return
     */
    public boolean empty() {
        return stack.isEmpty();
    }

    /**
     *
     * @param elemenet
     * @return
     */
    public int search(T elemenet) {
        int count = 0;
        for (T el : stack) {
            if (el.equals(elemenet)) {
                return stack.size() - count - 1;
            } else {
                count += 1;
            }
        }
        return 1;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "MyStack{" +
                "stack=" + stack +
                '}';
    }
}
