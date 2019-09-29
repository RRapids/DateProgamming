package com.date;

//单链表结点类，T指定结点的元素类型
public class Node<T> {
    public T data; //数据域，存储数据元素
    public Node<T> next;//地址域，引用后继节点

    //构造结点，data指定数据元素，next指定后继节点
    public Node(T data, Node<T> next) {
        this.data = data;  //T对象引用赋值
        this.next = next; //Node<T>对象引用赋值
    }

    public Node() {
        this(null, null);
    }

    //返回结点数据域的描述字符串
    public String toString() {
        return this.data.toString();
    }
}
