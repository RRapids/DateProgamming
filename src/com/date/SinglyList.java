package com.date;

public class SinglyList<T> extends Object {
    public Node<T> head; //头指针，指向单链表的头结点

    //（1）构造方法
    public SinglyList() {
        this.head = new Node<T>();//创建头结点，data和next值均为null
    }

    //创建空单链表，由values数组提供元素
    public SinglyList(T[] values) {
        //创建单链表，只有头结点
        this();
        //rear指向单链表最后一个结点
        Node<T> rear = this.head;
        //若values.length=0,创造空链表
        for (int i = 0; i < values.length; i++) {
            //尾插入，创建结点链入rear结点之后
            rear.next = new Node<T>(values[i], null);
            //rear指向新的链尾结点
            rear = rear.next;
        }
    }

    public static void main(String[] args) {

    }
}
