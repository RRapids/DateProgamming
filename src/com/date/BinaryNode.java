package com.date;

public class BinaryNode<T> {
    public T data;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(T data, BinaryNode left, BinaryNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T data) {
        this(data, null, null);
    }

    public String toString() {
        return this.data.toString();
    }
}
