package PolyMath;
import java.util.LinkedList;
import java.util.List;

public class Polynomial {
    private List<Monomial> poly;


    public static Polynomial PolyByList(List<Monomial> monos) {
        int max = 0;
        for (Monomial m: monos) if (m.getExp() > max) max = m.getExp();
        String[] coef = new String[max + 1];
        for (Monomial m: monos) coef[m.getExp()] = m.getCoefficient().toString();
        String s = "";
        for (int i = 0; i < coef.length - 1; i++) {
            if (coef[i] == null) s += "0 ";
            else s+= coef[i] + " ";
        }
        s += coef[coef.length-1];
        return build(s);
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
        return PolyByList(monos);
    }

    Polynomial mul(Polynomial p) {
        List<Monomial> thisPoly = this.poly;
        List<Monomial> pPoly = p.poly;
        Polynomial output = new Polynomial("0");
        List<Monomial> mono = new LinkedList<Monomial>();
        for (int i = 0; i < thisPoly.size(); i++) {
            for (int j = 0; j < pPoly.size(); j++) {
                mono.add(thisPoly.get(i).mult(pPoly.get(j)));
            }
            output = output.add(PolyByList(mono));
            mono.clear();
        }
        return output;
/*
        List<Monomial> monos = new LinkedList<Monomial>();
        //for (int i = 0; i < p.poly.size(); i++) {
        //    monos.add(poly.get(0).mult(p.poly.get(i)));
        //}
        //Polynomial NewPoly = byList(monos);
        Polynomial addMe = new Polynomial("0");

        for (int i = 0; i < poly.size(); i++) {
            for (int j = 0; j < p.poly.size(); j++) {
                monos.add(this.poly.get(i).mult(p.poly.get(j)));
                //addMe.poly.add(p.poly.get(j).mult(this.poly.get(i)));
            }
            addMe.add(byList(monos));
            monos = new LinkedList<Monomial>();
            //NewPoly = NewPoly.add(addMe);
        }
        return addMe;
*/
    }

    Scalar evaluate(Scalar s) {
        Scalar scalar = new Rational(0,1);
        for (int i = 0; i <poly.size() ; i++) {
            scalar = scalar.add(poly.get(i).evaluate(s));

        }
        return scalar;
    }

    Polynomial derivative() {
        //Polynomial NewPoly = new Polynomial("0");
        List<Monomial> monos = new LinkedList<Monomial>();
        for (int i = 0; i < poly.size(); i++) {
            monos.add(poly.get(i).derivative());
        }
        return PolyByList(monos);
    }

    public String toString() {
        String s = "";
        if (poly.size() == 1) return poly.get(0).toString();
        //s = poly.get(0).toString();
        for (int i = 0; i < poly.size(); i++) {
            if (poly.get(i).sign() != 0) {
                if (s.length() == 0) {
                    s += poly.get(i).toString();
                } else {
                    if (poly.get(i).sign() < 0) {
                        s += " " + poly.get(i).toString().charAt(0) + " " + poly.get(i).toString().substring(1);
                    }
                    else s += " + " + poly.get(i).toString();
                }
            }
        }
        if (s.isEmpty()) return "0";
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