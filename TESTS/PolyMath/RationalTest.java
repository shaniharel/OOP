package PolyMath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalTest {
    private Rational r1;
    private Rational r2;
    private Rational r3;
    private Rational r4;
    private Rational r5;
    private Rational r6;
    private Rational r7;
    private  Integer i1;
    private  Integer i2;
    private  Integer i3;
    private Rational r8;



    @BeforeEach
    void setUp() {
        r1=new Rational(2,3);
        r2=new Rational(3,9);
        r3=new Rational(2,2);
        r4=new Rational(100,1);
        r6=new Rational(0,2);
        r7=new Rational(4,5);
        r8=new Rational(-7,8);
        i1=new Integer(0);
        i2=new Integer(8);
        i3=new Integer(100);


    }

    @Test
    void add() {
        assertEquals("1",r1.add(r2).toString());
        assertEquals("4/3",r3.add(r2).toString());
        assertEquals("101",r4.add(r3).toString());
        assertEquals("22/15",r1.add(r7).toString());


    }

    @Test
    void mul() {
        assertEquals("2/9",r1.mul(r2).toString());
        assertEquals("100",r3.mul(r4).toString());
        assertEquals("8/15",r1.mul(r7).toString());
        assertEquals("0",r4.mul(r6).toString());

    }

    @Test
    void addRational() {
        assertEquals("1",r1.addRational(r2).toString());
        assertEquals("4/3",r3.addRational(r2).toString());
        assertEquals("101",r4.addRational(r3).toString());
        assertEquals("22/15",r1.addRational(r7).toString());
    }

    @Test
    void addInteger() {
        assertEquals("26/3",r1.addInteger(i2).toString());
        assertEquals("4/5",r7.addInteger(i1).toString());
        assertEquals("25/3",r2.addInteger(i2).toString());
        assertEquals("301/3",r2.addInteger(i3).toString());
    }

    @Test
    void mulRational() {
        assertEquals("2/9",r1.mulRational(r2).toString());
        assertEquals("100",r3.mulRational(r4).toString());
        assertEquals("8/15",r1.mulRational(r7).toString());
        assertEquals("0",r4.mulRational(r6).toString());
    }

    @Test
    void mulInteger() {
        assertEquals("16/3",r1.mulInteger(i2).toString());
        assertEquals("0",r7.mulInteger(i1).toString());
        assertEquals("8/3",r2.mulInteger(i2).toString());
        assertEquals("100/3",r2.mulInteger(i3).toString());
    }

    @Test
    void power() {
        assertEquals("32/243",r1.power(5).toString());
        assertEquals("1/27",r2.power(3).toString());
        assertEquals("0",r6.power(4).toString());
        assertEquals("4/5",r7.power(1).toString());

    }

    @Test
    void sign() {
        assertEquals(1,r1.sign());
        assertEquals(0,r6.sign());
        assertEquals(-1,r8.sign());

    }

    @Test
    void neg() {
        assertEquals("-2/3",r1.neg().toString());
        assertEquals("0",r6.neg().toString());
        assertEquals("7/8",r8.neg().toString());


    }

    @Test
    void reduce() {
        assertEquals("1/3",r2.reduce().toString());
        assertEquals("0",r6.reduce().toString());
        assertEquals("-7/8",r8.reduce().toString());
    }

    @Test
    void testToString() {
        assertEquals("2/3",r1.toString());
        assertEquals("1/3",r2.toString());
        assertEquals("1",r3.toString());
        assertEquals("-7/8",r8.toString());
    }
}