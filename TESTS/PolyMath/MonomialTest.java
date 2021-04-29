package PolyMath;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {
    private Monomial m1;
    private Monomial m2;
    private Monomial m3;
    private Monomial m4;
    private Monomial m5;
    private Monomial m6;
    private Monomial m7;
    private Monomial m8;
    private Monomial m9;

    @BeforeAll
    void setUp() {
        m1 = new Monomial(2, new Integer(-8));
        m2 = new Monomial(0, new Integer(7));
        m7 = new Monomial(0, new Integer(-9));
        m3 = new Monomial(1, new Integer(9));
        m4 = new Monomial(2, new Rational(2, 3));
        m5 = new Monomial(4, new Rational(1, 8));
        m8 = new Monomial(4, new Rational(3, 4));
        m6 = new Monomial(2, new Integer(11));
        m9 = new Monomial(8, new Integer(0));

    }


    @Test
    void add() {
        assertEquals("3x^2",m1.add(m6).toString());
        assertEquals("null",m2.add(m5).toString());
        assertEquals("null",m3.add(m4).toString());
        assertEquals("-2",m2.add(m7).toString());
        assertEquals("(7/8)x^4",m5.add(m8).toString());
    }

    @Test
    void mult() {
        assertEquals("-88x^4",m1.mult(m6).toString());
        assertEquals("7/8x^4",m2.mult(m5).toString());
        assertEquals("6x^3",m3.mult(m4).toString());
        assertEquals("-63",m2.mult(m7).toString());
        assertEquals("(3/32)x^8",m5.mult(m8).toString());


    }

    @Test
    void evaluate() {
        assertEquals("-9/2",m1.evaluate(new Rational(3,4)).toString());
        assertEquals("null",m2.evaluate(new Integer(6)).toString());
        assertEquals("1",m3.evaluate(new Rational(1,9)).toString());
        assertEquals("24",m4.evaluate(new Integer(6)).toString());
    }

    @Test
    void derivative() {
        assertEquals("-16x",m1.derivative().toString());
        assertEquals("0",m2.derivative().toString());
        assertEquals("9",m3.derivative().toString());
        assertEquals("4/3x",m4.derivative().toString());
        assertEquals("3x^3",m8.derivative().toString());
    }

    @Test
    void sign() {
        assertEquals(-1,m1.sign());
        assertEquals(1,m2.sign());
        assertEquals(0,m9.sign());
    }

    @Test
    void testToString() {
    }
}