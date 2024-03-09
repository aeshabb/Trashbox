package output;

import newStructure.MyStack;

import java.util.List;

public class ConsolePrinter {
    public void printLine(String lineToPrint) {
        System.out.println(lineToPrint);
    }

    public <T> void printArray(T[] array) {
        for (T arg : array) {
            System.out.println(arg);
        }
    }

    public <T> void printList(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            printLine((i + 1) + ". " + list.get(i));
        }
    }

    public <T> void printStack(MyStack<T> stack) {
        for (int i = 0; i < stack.size(); i++) {
            printLine((i + 1) + ". " + stack.get(i));
        }
    }
}
