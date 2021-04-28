package PolyMath;

import com.sun.source.tree.BreakTree;

public class Rational implements PolyMath.Scalar {

    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        if (numerator == 0) {
            this.numerator = 0;
            this.denominator = 1;
        } else {
            this.numerator = numerator;
            if (denominator != 0) this.denominator = denominator;
            else throw new IllegalArgumentException("can't divide by zero!!");
        }

    }

    public Scalar add(Scalar s) {
        return s.addRational(this);
    }

    public Scalar mul(Scalar s) {
        return s.mulRational(this);
    }

    public Scalar addRational(Rational s) {
        int lcd =  lcm(this.denominator, s.denominator);
        int num = this.numerator * (lcd/this.denominator) + s.numerator * (lcd/s.denominator);
        return new Rational(num, lcd);
    }

    public Scalar addInteger(Integer s) {
        Rational tmp = new Rational(s.getNumber(), 1);
        return addRational(tmp);
    }

    public Scalar mulRational(Rational s) {
        return new Rational(this.numerator * s.numerator, this.denominator * s.denominator);
    }

    public Scalar mulInteger(Integer s) {
        Rational tmp = new Rational(s.getNumber(), 1);
        return mulRational(tmp);
    }

    public Scalar power(int exponent) {
        int num = 1;
        int den = 1;
        for (int i = 0; i < exponent; i++) {
            num *= numerator;
            den *= denominator;
        }
        return new Rational(num, den);
    }

    public int sign() {
        if (numerator / denominator < 0) return -1;
        else if (numerator/ denominator > 0) return 1;
        else return 0;
    }

    public Scalar neg() {
        return new Rational(numerator * (-1), denominator);
    }

    public Rational reduce() {
        int gcd = gcd(numerator, denominator);
        if (gcd != 0) return new Rational(numerator / gcd, denominator / gcd);
        else return new Rational(0,1);
    }

    public String toString() {
        Rational r = this.reduce();
        if (r.numerator == 0) return "";
        if (r.denominator == 1) return String.valueOf(r.numerator);
        return String.valueOf(r.numerator) + "/" + String.valueOf(r.denominator);
    }

    public double getNumber() {
        return (double) numerator/ denominator;
    }

    private int gcd(int a, int b)
    {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    private int lcm(int a, int b)
    {
        return (a * b) / gcd(a, b);
    }
}
