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

    @BeforeAll
    void setUp() {
        m1 = new Monomial(2, new Integer(-8));
        m2 = new Monomial(0, new Integer(7));
        m3 = new Monomial(1, new Integer(9));
        m4 = new Monomial(2, new Rational(2, 3));
        m5 = new Monomial(4, new Rational(1, 8));
        m6 = new Monomial(2, new Integer(11));
    }


    @Test
    void add() {
        assertEquals(m1.add(m6),3);
    }

    @Test
    void mult() {
    }

    @Test
    void evaluate() {
    }

    @Test
    void derivative() {
    }

    @Test
    void sign() {
    }

    @Test
    void testToString() {
    }
}