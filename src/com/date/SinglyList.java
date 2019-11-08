package com.date;

public class SinglyList<T> extends Object {
    protected Object[] element;
    protected int n;
    protected int length;

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

    //判断是否为空
    public boolean isEmpty() {
        return this.head.next == null;
    }

    //（2）存取
    public T get(int i) {       //返回第i个元素，0<=i<表长度，若i越界，则返回null，O（n）
        Node<T> p = head;
        for (int j = 0; j <= i; i++) {       //遍历单链表，寻找第i个结点（p指向）
            p = p.next;
        }
        System.out.println(p.data.toString());
        return p.data;
    }

    //设置第i个元素为x，0<=i<表长度，x！=null。
    public void set(int i, T x) {

    }

    //返回单链表长度，O（n）
    public int size() {
        return size();
    }
    public String toString(){
        String str = this.getClass().getName()+"(";
        for (Node<T> p=this.head.next;p!=null;p=p.next){
            str+=p.data.toString();
            if (p.next!=null)
                str+=",";
        }
        return str+")";
    }
    public Node<T> insert(int i,T x){
        if (x==null)
            throw new NullPointerException("x == null");
        Node<T> front = this.head;
        for (int j =0;front.next!=null&&j<i;j++)
            front = front.next;
        front.next=new Node<T>(x,front.next);
        return front.next;
    }
    public Node<T> insert(T x){
        return insert(Integer.MAX_VALUE,x);

    }
    public T remove(int i){
        Node<T> front = this.head;
        for (int j =0;front.next!=null&&j<i;j++)
            front = front.next;
        if (i>=0&&front.next!=null){
            T old = front.next.data;
            front.next = front.next.next;
            return old;
        }
        return null;
    }

    public void clear(){
        this.head.next = null;
    }

    public int search(T key) {
        return 0;
    }

    public boolean contains(T key){
        return this.search(key) != -1;
    }

    public int insertDifferent(T x){
        if (x==null){
            throw new NullPointerException("x==null");     //抛出空对象异常
        }
        if(this.isEmpty()){   //空表,尾插入, O(1)
            this.insert(x);
            return -1;
        }
        this.insert(x);   //查找不成功，尾插入, O(1)
        return 1;

    }

    public static<T> void reverse(SinglyList<T> list){
        Node<T> p = list.head.next,succ=null,front=null;
        while (p!=null){
            succ= p.next;
            p.next = front;
            front = p;
            p=succ;
        }
        list.head.next=front;
    }

    public static<T> void s_reverse(SinglyList<T> list){
        Node<T> q = list.head.next,succ=null,front=null;
        while (q!=null){
        }
//        q.next = head.next;
//        head.next = q;

    }


    public static void main(String[] args){
        String[] values = {"A", "B", "C", "D", "E", "F"};
        SinglyList<String> list = new SinglyList<String>(values);
//        Object x;
//        x = list.get(3);
        Node<String> p = list.head;
        while (p.next != null) {
            p = p.next;
            System.out.println(p.data.toString());
        }
    }
}
