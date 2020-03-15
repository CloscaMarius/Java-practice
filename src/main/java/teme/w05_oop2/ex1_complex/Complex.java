package teme.w05_oop2.ex1_complex;

import java.util.Objects;

class Complex implements ArithmeticOps {

    private double real;
    private double img;

    public double getReal() {
        return real;
    }

    public double getImg() {
        return img;
    }

    Complex(double real, double img) {
        this.real = real;
        this.img = img;
    }

    static Complex complex(double real, double imaginary) {
        return new Complex(real, imaginary);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Complex complex = (Complex) other;
        return real == complex.real &&
                img == complex.img;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, img);
    }

    @Override
    public String toString() {
        return "Complex{" +
                "real=" + real +
                ", img=" + img + "i" +
                '}';
    }


    @Override
    public Complex add(Complex other) {
        double real = this.real + other.real;
        double imag = this.img + other.img;
        return new Complex(real, imag);
    }

    @Override
    public Complex negate() {
        double real = -this.real;
        double imag = -this.img;
        return new Complex(real, imag);
    }

    @Override
    public Complex multiply(Complex other) {
        double real = this.real * other.real - this.img * other.img;
        double imag = this.real * other.img + this.img * other.real;
        return new Complex(real, imag);
    }
}


interface ArithmeticOps {
    Complex add(Complex other);

    Complex negate();

    Complex multiply(Complex other);
}
