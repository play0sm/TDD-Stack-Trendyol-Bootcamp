package com.kodluyoruz.stack;

import com.kodluyoruz.stack.exceptions.NoContentFound;

import java.util.ArrayList;
import java.util.Objects;

public class Stack<T> {
    private ArrayList<T> nodeStack;

    public Stack() {
        nodeStack = new ArrayList<>();
    }

    public void push(T item) {
        if (Objects.isNull(item)) {
            throw new IllegalArgumentException("Item can not be null!");
        }
        nodeStack.add(0, item);
    }

    public int count() {
        return nodeStack.size();
    }

    public T pop() {
        if (count() == 0) {
            throw new NoContentFound("Stack is empty!");
        }

        T result = nodeStack.get(0);
        nodeStack.remove(0);
        return result;
    }

    public T peek() {
        if (count() == 0) {
            throw new NoContentFound("Stack is empty!");
        }

        return nodeStack.get(0);
    }
}
