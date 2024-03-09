package newStructure;

import java.util.LinkedList;
import java.util.List;

public class MyStack<T> {
    LinkedList<T> stack = new LinkedList<>();

    public T push(T element) {
        stack.add(element);
        return element;
    }

    public int size() {
        return stack.size();
    }

    public T pop() {
        return stack.pop();
    }

    public List<T> subList(int startIndex, int endIndex) {
        return stack.subList(startIndex, endIndex);
    }

    public T get(int index) {
        return stack.get(index);
    }

    public T peek() {
        return stack.peek();
    }

    public boolean empty() {
        return stack.isEmpty();
    }

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

    @Override
    public String toString() {
        return "MyStack{" +
                "stack=" + stack +
                '}';
    }
}
