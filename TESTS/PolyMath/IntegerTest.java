package PolyMath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerTest {
    private Integer n1;
    private Integer n2;
    private Integer n3;
    private Integer n4;
    private Integer n5;
    private Rational r1;
    private Rational r2;
    private Rational r3;
    private Rational r4;

    @BeforeEach
    void setUp() {
        n1 = new Integer(0);
        n2 = new Integer(1);
        n3 = new Integer(1000);
        n4 = new Integer(4);
        n5 = new Integer(-5);
        r1 = new Rational(1,2);
        r2 = new Rational(0,3);
        r3 = new Rational(5,3);
        r4 = new Rational(4,2);
    }

    @Test
    void add() {
        assertEquals("-1", n4.add(n5).toString());
        assertEquals("1", n1.add(n2).toString());
        assertEquals("1", n2.add(n1).toString());
        assertEquals("5", n2.add(n4).toString());
        assertEquals("1004", n3.add(n4).toString());
        assertEquals("1001", n2.add(n3).toString());
        assertEquals("3/2", n2.add(r1).toString());
        assertEquals("1", n2.add(r2).toString());
        assertEquals("6", n4.add(r4).toString());
        assertEquals("3005/3", n3.add(r3).toString());
    }

    @Test
    void mul() {
        assertEquals("-5000", n3.mul(n5).toString());
        assertEquals("0", n1.mul(n2).toString());
        assertEquals("0", n3.mul(n1).toString());
        assertEquals("4", n2.mul(n4).toString());
        assertEquals("1000", n3.mul(n2).toString());
        assertEquals("4000", n3.mul(n4).toString());
        assertEquals("0", n2.mul(r2).toString());
        assertEquals("2", n4.mul(r1).toString());
        assertEquals("2000", n3.mul(r4).toString());
        assertEquals("20/3", n4.mul(r3).toString());
    }

    @Test
    void addRational() {
        assertEquals("1/2", n1.addRational(r1).toString());
        assertEquals("1", n2.addRational(r2).toString());
        assertEquals("1002", n3.addRational(r4).toString());
        assertEquals("17/3", n4.addRational(r3).toString());
    }

    @Test
    void addInteger() {
        assertEquals("0", n1.addInteger(n1).toString());
        assertEquals("2", n2.addInteger(n2).toString());
        assertEquals("1001", n3.addInteger(n2).toString());
        assertEquals("4", n4.addInteger(n1).toString());
        assertEquals("-10", n5.addInteger(n5).toString());
        assertEquals("995", n5.addInteger(n3).toString());
    }

    @Test
    void mulRational() {
        assertEquals("5/3", n2.mulRational(r3).toString());
        assertEquals("8", n4.mulRational(r4).toString());
        assertEquals("0", n3.mulRational(r2).toString());
        assertEquals("500", n3.mulRational(r1).toString());
    }

    @Test
    void mulInteger() {
        assertEquals("0", n1.mulInteger(n1).toString());
        assertEquals("0", n1.mulInteger(n2).toString());
        assertEquals("4000", n4.mulInteger(n3).toString());
        assertEquals("4", n2.mulInteger(n4).toString());
        assertEquals("-20", n4.mulInteger(n5).toString());
    }

    @Test
    void power() {
        assertEquals("16", n4.power(2).toString());
        assertEquals("1", n2.power(23).toString());
        assertEquals("1000000", n3.power(2).toString());
        assertEquals("0", n1.power(3).toString());
        assertEquals("25", n5.power(2).toString());
        assertEquals("-125", n5.power(3).toString());
        assertEquals("1/16", n4.power(-2).toString());
    }

    @Test
    void sign() {
        assertEquals(-1, n5.sign());
        assertEquals(1, n4.sign());
        assertEquals(0, n1.sign());
    }

    @Test
    void neg() {
        assertEquals("5", n5.neg().toString());
        assertEquals("-1000", n3.neg().toString());
        assertEquals("0", n1.neg().toString());
    }

    @Test
    void testToString() {
        assertEquals("0", n1.toString());
        assertEquals("1", n2.toString());
        assertEquals("1000", n3.toString());
        assertEquals("4", n4.toString());
        assertEquals("-5", n5.toString());
    }
}