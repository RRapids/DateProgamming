package com.date;

public class Complex2 {
    private double real, imag;//实部，虚部

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }
    public Complex2(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex2(double real) {
        this(real, 0);
    }

    public Complex2() {
        this(0, 0);
    }
    public Complex2 sub(Complex2 complex){
        this.real -=complex.real;
        this.imag -=complex.imag;
        return (new Complex2(this.real,this.imag));
    }
    public String toString(){
        return "("+this.real+"-"+this.imag+"i)";
    }

    public static void main(String[] args) {
        Complex2 c1 = new Complex2();
        Complex2 c2 = new Complex2(3,5);
        Complex2 c3 = c1.sub(c2);
        System.out.println(c3);
    }
}
