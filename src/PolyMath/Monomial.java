package PolyMath;

public class Monomial {

    private int exponent;
    private Scalar coefficient;

    public Monomial(int exp, Scalar coef) {
        exponent = exp;
        coefficient = coef;
    }

    public Monomial add(Monomial m) {
        Scalar sum = this.coefficient.add(m.coefficient);
        return new Monomial(exponent, sum);
    }

    public Monomial mult(Monomial m) {
        Scalar multiply = this.coefficient.mul(m.coefficient);
        return new Monomial(this.exponent * m.exponent, multiply);
    }

    public Scalar evaluate(Scalar s) {
        Scalar output = s.power(exponent);
        return output.mul(coefficient);
    }
    public Monomial derivative() {
        int exp = exponent;
        Scalar coef = coefficient;
        if (exponent == 0) coef = new Integer(0);
        else {
            coef.mul(new Integer(exp));
            exp--;
        }
        return new Monomial(exp, coef);
    }

    public int sign() {
        return coefficient.sign();
    }

    public String toString() {
        String output = coefficient.toString();
        if (output.length() == 0) return output;
        if (exponent > 1) output += "x^" + String.valueOf(exponent);
        else if (exponent == 1) output += "x";
        return output;
    }

    public int getExp() {
        return exponent;
    }
}
