package PolyMath;

public class Monomial {

    private int exponent;
    private Scalar coefficient;

    public Monomial(int exp, Scalar coef) {
        exponent = exp;
        coefficient = coef;
    }

    public Monomial add(Monomial m) {
        if (m.exponent != exponent) throw new IllegalArgumentException("can't add monomial with different exponent");
        Scalar sum = this.coefficient.add(m.coefficient);
        return new Monomial(exponent, sum);
    }

    public Monomial mult(Monomial m) {
        Scalar multiply = this.coefficient.mul(m.coefficient);
        return new Monomial(this.exponent + m.exponent, multiply);
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
            coef = coef.mul(new Integer(exp));
            exp--;
        }
        return new Monomial(exp, coef);
    }

    public int sign() {
        return coefficient.sign();
    }

    public String toString() {
        String output = coefficient.toString();
        if (exponent == 0) return output;
        if (output.equals("0")) return "";
        if (output.equals("1")) output = "";
        if (output.equals("-1")) output = "-";
        if (exponent == 1) output += "x";
        else output += "x^" + String.valueOf(exponent);

        return output;
    }

    public int getExp() {
        return exponent;
    }

    public Scalar getCoefficient() {
        return coefficient;
    }
}
