package com.date;

public class MyString implements Comparable<MyString>, java.io.Serializable {

    private final char[] value;//字符数组，私有最终变量，只能赋值一次

    public MyString(char[] value) {//构造空串“”，串长度为0
        this.value = new char[0];
    }

    //由字符串常量构造串
    public MyString(java.lang.String str) {
        this.value = new char[str.length()];      //申请字符数组并复制str串的所有字符
        for (int i = 0; i < this.value.length; i++)
            this.value[i] = str.charAt(i);
    }

    //以value数组从i开始的n个字符构造串，i>=0,i+n<=value.length
    //若i与n指定序号越界，则抛出字符串序号越界异常
    public MyString(char[] value, int i, int n) {
        if (i >= 0 && n >= 0 && i + n <= value.length) {
            this.value = new char[n];             //申请字符数组并复制所有字符
            for (int j = 0; j < n; j++)
                this.value[j] = value[i + j];

        } else throw new StringIndexOutOfBoundsException("i=" + i + ",n=" + n + ",i+n=" + (i + n));
    }

    public MyString(char[] value, char[] value1) {      //以字符数组构造串
        this(value, 0, value.length);
    }

    public MyString(MyString str, char[] value)      //拷贝构造方法，深度拷贝，复制字符
    {
        this(str.value);
    }

    public int length()         //返回串长度，既字符数组容量
    {
        return this.value.length;
    }

    public java.lang.String toString() {
        return new String(this.value);
    }

    //返回第i个字符，0<=i<length(),若i越界，则抛出字符串序号越界异常
    public char charAt(int i) {
        if (i >= 0 && i < this.value.length)
            return this.value[i];
        throw new StringIndexOutOfBoundsException(i);
    }

    //    返回序号从begin至end-1的字串，0<=begin<length(),0<end<=length(),begin<end,
//    否则抛出字符串序号越界异常
    public MyString substring(int begin, int end) {
        if (begin == 0 && end == this.value.length)
            return this;
        return new MyString(this.value, begin, end - begin); //以字符数组构造串，若begin，end越界将抛出异常

    }

    public MyString substirng(int begin)  //返回序号从begin串尾的字串
    {
        return substring(begin, this.value.length);
    }

    public MyString concat(MyString str)  //返回this与str串连接生成的串，若str==null,则插入“null”
    {
        if (str == null)
            str = new MyString("null");
        char[] buffer = new char[this.value.length + str.length()];
        int i;
        for (i = 0; i < this.length(); i++) //复制当前串
            buffer[i] = this.value[i];
        for (int j = 0; j < str.value.length; j++)  //复制指定串str
            buffer[i + j] = str.value[j];
        return new MyString(buffer);    //以字符数组构造串对象

    }

    public MyString trim(){
        int len = value.length;
        int st = 0;
        char[] val = value;

        while ((st < len) && (val[st] <= ' ')) {
            st++;
        }
        while ((st < len) && (val[len - 1] <= ' ')) {
            len--;
        }
        return ((st > 0) || (len < value.length)) ? substring(st, len) : this;
    }


    @Override
    public int compareTo(MyString str) {        //比较this与str串的大小，返回两者差值
        for (int i = 0; i < this.value.length && i < str.value.length; i++)
            if (this.value[i] != str.value[i])
                return this.value[i] - str.value[i];//返回两串第一个一个不同个字符的差值
        return this.value.length - str.value.length;//前缀子串，返回两串长度的差值
    }

    public static void main(String[] args) {
        MyString str3 = new MyString("  欧克  ");
        System.out.println("原始值：  ");
        System.out.println(str3);
        System.out.println("删除头尾空白： ");
        System.out.println(str3.trim());
    }
}
