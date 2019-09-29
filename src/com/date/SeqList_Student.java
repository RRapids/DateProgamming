package com.date;

public class SeqList_Student {
    //分类统计线性表list的元素信息，分段信息存于grade数组，返回保存统计结果的数组
    public static int[] groupCount(SeqList<Student> list, int grade[]) {
        //result数组保存统计结果
        int result[] = new int[grade.length];
        for (int i = 0; i < list.size(); i++) {
            //获得list的第i个元素，对象引用赋值
            Student student = list.get(i);
            for (int j = 0; j < grade.length - 1; j++)
                //判断student范围
                if (student.score >= grade[j] && student.score < grade[j + 1]) {
                    result[j]++;
                    break;
                }
        }
        //返回result数组变量引用的数组
        return result;
    }

    //输出线性表list元素及分类统计结果
    public static void printCount(SeqList<Student> list, String titles[], int result[]) {
        System.out.println("学生集合：" + list.toString() + "\n共+" + "list.size()" + "人，成绩统计：");
        for (int i = 0; i < titles.length; i++)
            System.out.println(titles[i] + result[i] + "人，");
        System.out.println();
    }

    public static void main(String[] args) {
        Student group[] = {new Student("张三", 85), new Student("李四", 75), new Student("王二", 90),
                new Student("麻子", 80), new Student("张si", 60), new Student("张wu", 55),};
        //构建顺序表，由数组提供初值
        SeqList<Student> lista = new SeqList<Student>(group);
        lista.insert(new Student("麻子", 70));//尾插入
        int[] grade = {0, 60, 70, 80, 90, 100};//指定分段信息
        String[] titles = {"不及格", "及格", "中等", "良好", "优秀"};//字符串数组指定分类名称
        int[] result = groupCount(lista, grade);//分类统计，返回存放统计结果的数组
        printCount(lista, titles, result);
        String name = "小白";
        //key 包含姓名，比较相等，按姓名查找
        Student key = new Student(name, 0);
        System.out.println("\"" + name + "\"的成绩是:" + lista.get(lista.search(key)).score);
        System.out.println("删除" + lista.remove(key));
        //由顺序表构造拍寻顺序表
        SeqList<Student> slistb = new SortedSeqList<Student>();
        result = groupCount(slistb, grade);
        printCount(slistb, titles, result);
        int score = 70;
        key = new Student("", score);
        System.out.println("成绩为：" + score + "分的学生是" + slistb.get(slistb.search(key)).name);
    }
}
