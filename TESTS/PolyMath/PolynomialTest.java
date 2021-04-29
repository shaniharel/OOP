package PolyMath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PolynomialTest {
    private Polynomial p0;
    private Polynomial p1;
    private Polynomial p2;
    private Polynomial p3;
    private Polynomial p4;
    private Polynomial p5;
    private Polynomial p6;
    private Polynomial p7;
    private Polynomial p8;
    private Polynomial p9;
    private Polynomial p10;
    private Integer n1;
    private Integer n2;
    private Integer n3;
    private Rational r1;
    private Rational r2;


    @BeforeEach
    void setUp() {
        p0 = new Polynomial("0");
        p1 = new Polynomial("1");
        p2 = new Polynomial("0 1");
        p3 = new Polynomial("1 1 1");
        p4 = new Polynomial("0 0 0 1");
        p5 = new Polynomial("0 0 0 0 0 0 0 0 0 0 4");
        p6 = new Polynomial("4 2 6 7");
        p7 = new Polynomial("4/2 2 6/3 2");
        p8 = new Polynomial("0 3 -3/8 0/4 -5 2/5");
        p9 = new Polynomial("0 1 0 0 0 0 2 0 -3");
        p10 = new Polynomial("-1/2");
        n1 = new Integer(3);
        n2 = new Integer(-5);
        n3 = new Integer(0);
        r1 = new Rational(1, 4);
        r2 = new Rational(-3, 2);

    }

    @Test
    void build() {
        assertEquals("0", Polynomial.build("0").toString());
        assertEquals("1", Polynomial.build("1").toString());
        assertEquals("x", Polynomial.build("0 1").toString());
        assertEquals("1 + x + x^2", Polynomial.build("1 1 1").toString());
        assertEquals("x^3", Polynomial.build("0 0 0 1").toString());
        assertEquals("4x^10", Polynomial.build("0 0 0 0 0 0 0 0 0 0 4").toString());
        assertEquals("4 + 2x + 6x^2 + 7x^3", Polynomial.build("4 2 6 7").toString());
        assertEquals("2 + 2x + 2x^2 + 2x^3", Polynomial.build("4/2 2 6/3 2").toString());
        assertEquals("3x - 3/8x^2 - 5x^3 + 2/5x^4", Polynomial.build("0 3 -3/8 0/4 -5 2/5").toString());
        assertEquals("x + 2x^6 - 3x^8", Polynomial.build("0 1 0 0 0 0 2 0 -3").toString());
        assertEquals("-1/2", Polynomial.build("-1/2").toString());
    }

    @Test
    void add() {
        assertEquals("1 + x", p1.add(p2).toString());
        assertEquals("1 + x + x^2 + x^3", p4.add(p3).toString());
        assertEquals("1 + 4x + 5/8x^2 - 5x^4 + 2/5x^5", p3.add(p8).toString());
        assertEquals("7/2 + 2x + 6x^2 + 7x^3", p6.add(p10).toString());
        assertEquals("1 + 4x^10", p1.add(p5).toString());
        assertEquals("5 + 3x + 7x^2 + 7x^3", p6.add(p3).toString());
        assertEquals("2 + 5x + 13/8x^2 + 2x^3 - 5x^4 + 2/5x^5", p7.add(p8).toString());
    }

    @Test
    void mul() {
        assertEquals("-1 - x - x^2 - x^3", p7.mul(p10).toString());
        assertEquals("x^3", p4.mul(p1).toString());
        assertEquals("0", p6.mul(p0).toString());
        assertEquals("4 + 6x + 12x^2 + 15x^3 + 13x^4 + 7x^5", p3.mul(p6).toString());
        assertEquals("8 + 12x + 24x^2 + 38x^3 + 30x^4 + 26x^5 + 14x^3", p6.mul(p7).toString());
    }

    @Test
    void evaluate() {
        assertEquals("1", p1.evaluate(r2).toString());
        assertEquals("13", p3.evaluate(n1).toString());
        assertEquals("59049/256", p5.evaluate(r2).toString());
        assertEquals("1811/2560", p8.evaluate(r1).toString());
        assertEquals("-731", p6.evaluate(n2).toString());
        assertEquals("-18222", p9.evaluate(n1).toString());
        assertEquals("1", p3.evaluate(n3).toString());
    }

    @Test
    void derivative() {
        assertEquals("2 + 12x + 21x^2", p6.derivative().toString());
        assertEquals("3 - 3/4x - 20x^3 + 2x^4", p8.derivative().toString());
        assertEquals("1 + 2x", p3.derivative().toString());
        assertEquals("2 + 4x + 6x^2", p7.derivative().toString());
        assertEquals("0", p1.derivative().toString());
        assertEquals("1 + 12x^5 - 24x^7", p9.derivative().toString());
    }

    @Test
    void testToString() {
        assertEquals("0", p0.toString());
        assertEquals("1", p1.toString());
        assertEquals("x", p2.toString());
        assertEquals("1 + x + x^2", p3.toString());
        assertEquals("x^3", p4.toString());
        assertEquals("4x^10", p5.toString());
        assertEquals("4 + 2x + 6x^2 + 7x^3", p6.toString());
        assertEquals("2 + 2x + 2x^2 + 2x^3", p7.toString());
        assertEquals("3x - 3/8x^2 - 5x^3 + 2/5x^4", p8.toString());
        assertEquals("x + 2x^6 - 3x^8", p9.toString());
        assertEquals("-1/2", p10.toString());
    }
}