package com.date;

public class Student extends Object implements Comparable<Student> {
    String name;//姓名
    int score;//成绩

    //构造方法
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    //返回对象的描述字符串，形式为“（,）”。覆盖
    public String toString() {
        return "(" + this.name + "," + this.score + ")";
    }

    //比较对象是否相等，仅比较name.覆盖
    public boolean equals(Object object) {
        //调用String类的equals（Object）方法，比较两串是否相等
        return this == object || (object instanceof Student) && this.name.equals(((Student) object).name);
    }

    //比较对象大小,实现Comparable<T>接口
    @Override
    public int compareTo(Student student) {
        return this.score - student.score;
    }
}
