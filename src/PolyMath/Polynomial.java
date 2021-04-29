package PolyMath;
import java.util.LinkedList;
import java.util.List;

public class Polynomial {
    private List<Monomial> poly;


    private Polynomial(List<Monomial> monos) {
        poly = monos;
    }

    public Polynomial(String input) {
        String[] s=input.split(" ");
        poly = new LinkedList<Monomial>();
        for (int i = 0; i < s.length; i++)
        {
            if (s[i].contains("/")) {
                String[] s2 = s[i].split("/");
                poly.add(new Monomial(i, new Rational(java.lang.Integer.parseInt(s2[0]),java.lang.Integer.parseInt(s2[1]))));
            } else {
                poly.add(new Monomial(i,new Integer(java.lang.Integer.parseInt(s[i]))));
            }
        }
    }

    public static Polynomial build(String input) {
        return new Polynomial(input);
    }

    Polynomial add(Polynomial p) {
        List<Monomial> me = new LinkedList<Monomial>();
        List<Monomial> other = new LinkedList<Monomial>();
        me.addAll(this.poly);
        other.addAll(p.poly);
        padding(me, other.size());
        padding(other, me.size());
        List<Monomial> monos = new LinkedList<Monomial>();
        for (int i = 0; i < me.size(); i++) monos.add(me.get(i).add(other.get(i)));
        return new Polynomial(monos);
    }

    Polynomial mul(Polynomial p) {
        Polynomial NewPoly = new Polynomial("0");
        for (int i = 0; i < p.poly.size(); i++) {
            NewPoly.poly.add(poly.get(0).mult(p.poly.get(i)));
        }
        Polynomial addMe = new Polynomial("0");
        for (int i = 0; i < poly.size(); i++) {
            for (int j = 1; j < p.poly.size(); j++) {
                addMe.poly.add(p.poly.get(j).mult(this.poly.get(i)));
            }
            NewPoly = NewPoly.add(addMe);
        }
        return NewPoly;

    }

    Scalar evaluate(Scalar s) {
        Scalar scalar = new Rational(0,1);
        for (int i = 0; i <poly.size() ; i++) {
            scalar = scalar.add(poly.get(i).evaluate(s));

        }
        return scalar;
    }

    Polynomial derivative() {
        Polynomial NewPoly = new Polynomial("0");
        for (int i = 0; i < poly.size(); i++) NewPoly.poly.add(poly.get(i).derivative());
        return NewPoly;
    }

    public String toString() {
        String s = "";
        s = poly.get(0).toString();
        for (int i = 1; i < poly.size(); i++) {
            if(poly.get(i).toString().contains("-"))
                s += " " + poly.get(i).toString().charAt(0) + " " + poly.get(i).toString().substring(1);
            else s += " + " + poly.get(i).toString();

        }
        return s;
    }

    private void padding(List<Monomial> monos, int n) {
        if (monos.size() < n) {
            for (int i = monos.size(); i < n; i++) {
                monos.add(new Monomial(i, new Integer(0)));
            }
        }
    }
}