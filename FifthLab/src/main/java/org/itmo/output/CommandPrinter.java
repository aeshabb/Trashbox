package org.itmo.output;

import org.itmo.newStructure.MyStack;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class CommandPrinter {

    private final PrintStream printStream;

    public CommandPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printLine(String lineToPrint) {
        printStream.println(lineToPrint);
    }


    public <T> void printArray(T[] array) {
        for (T arg : array) {
            printStream.println(arg);
        }
    }


    public <T> void printList(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            printLine((i + 1) + ". " + list.get(i));
        }
    }


    public <T> void printSet(Set<T> set) {
        Iterator<T> iter = set.iterator();
        int i = 0;
        while (iter.hasNext()) {
            printLine((i + 1) + ". " + iter.next());
            i++;
        }
    }


    public <T> void printStack(MyStack<T> stack) {
        for (int i = 0; i < stack.size(); i++) {
            printLine((i + 1) + ". " + stack.get(i));
        }
    }

}
