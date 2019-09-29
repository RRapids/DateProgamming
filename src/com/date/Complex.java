package com.date;

public class Complex {

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

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public Complex(double real) {
        this(real, 0);
    }

    public Complex() {
        this(0, 0);
    }

    public Complex add(Complex complex) {
        this.real += complex.real;
        this.imag += complex.imag;
        return (new Complex(this.real, this.imag));
    }

    public Complex sub(Complex complex){
        this.real -=complex.real;
        this.imag -=complex.imag;
        return (new Complex(this.real,this.imag));
    }

    public String toString(){
        return "("+this.real+"+"+this.imag+"i)";
    }

    public static void main(String[] args) {
        Complex c1 = new Complex();
        Complex c2 = new Complex(3,5);
        Complex c3 = c1.add(c2);
        System.out.println(c3);

    }

}
