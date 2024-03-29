package com.date;

public final class SeqStack<T> implements Stack<T> {
    private SeqList<T> list;
    public SeqStack(int length){
        this.list = new SeqList<T>();
    }
    public SeqStack(){
        this(64);
    }
    public boolean isEmpty(){
        return this.list.isEmpty();
    }
    public void push(T x){
        this.list.insert(x);
    }
    public T peek(){
        return this.list.get(list.size()-1);
    }
    public T pop(){
        return list.remove(list.size()-1);
    }
}
