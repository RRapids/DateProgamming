package com.date;

public class SortedSeqList<T extends Comparable<? super T>> extends SeqList<T> {
    //构造空排序顺序表
    public SortedSeqList() {
        super();
    }

    //构造空排序顺序表，容量为length
    public SortedSeqList(int length) {
        super(length);
    }

    //构造排序顺序表，由数组提供元素
    public SortedSeqList(T[] values) {
        //创建空排序顺序表，指定容量
        super(values.length);
        for (int i = 0; i < values.length; i++)
            //插入元素，根据对象大小确定插入位置
            this.insert(values[i]);
    }

    //覆盖父类insert(T x)方法声明
    public int insert(T x) {
        int i = 0;
        //compareTo(T)比较大小
        if (this.isEmpty() || x.compareTo(this.get(this.size() - 1)) > 0)
            //最大值尾插入
            i = this.n;
        else
            //寻找插入位置（升序）
            while (i < this.n && x.compareTo(this.get(i)) > 0)
                i++;
        //调用父类被覆盖的insert(i,x)方法，插入x作为第i个元素
        super.insert(i, x);
        return i;
    }

    //不支持父类的以下两个方法，将其覆盖并抛出异常
    public void set(int i, T x) {
        //只读特性
        throw new java.lang.UnsupportedOperationException("set(int i ,T x)");
    }

    public int insert(int i, T x) {
        //任意位置插入
        throw new UnsupportedOperationException("insert(int i ,T x)");
    }

    //顺序查找首次出现的与key相等元素，返回元素序号i（0<<i<<n）;若查找不成功，则返回-1.
    public int search(T key) {
        for (int i = 0; i < this.n && key.compareTo(this.get(i)) >= 0; i++)
            //对象相等，运行时多态
            if (key.compareTo(this.get(i)) == 0)
                return i;
        //空表或废找到时
        return -1;
    }

    //删除首次出现的与Key相等的元素
    public T remove(T key) {
        return this.remove(this.search(key));
    }
}
