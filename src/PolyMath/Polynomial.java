package PolyMath;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Polynomial {
    private List<Monomial> poly;


    private Polynomial(String input) {
        String[] s=input.split(" ");
        System.out.println(Arrays.toString(s));
        poly = new LinkedList<Monomial>();
        for (int i=0;i<s.length;i++)
        {
            if(s[i].contains("/")) {
                String[] s2=s[i].split("/");
                poly.add(new Monomial(i, new Rational(java.lang.Integer.parseInt(s2[0]),java.lang.Integer.parseInt(s2[1]))));
            } else {
                int in = java.lang.Integer.parseInt(s[i]);
                Integer integ = new Integer(in);
                poly.add(new Monomial(i,integ));
            }
        }
    }

    public static Polynomial build(String input)
    {
        return new Polynomial(input);

    }

    /*
    Polynomial add(Polynomial p) {
        boolean[] me = this.exps();
        boolean[] other = p.exps();
        for (int i = 0; i < )
    }

     */
//"--------------------------------------"
    Polynomial add(Polynomial p) {
        Polynomial NewPoly = new Polynomial("");
        for (int i=0;i<poly.size();i++)
        {
            NewPoly.poly.add(p.poly.get(i).add(this.poly.get(i)));
        }
        return NewPoly;
    }

    Polynomial mul(Polynomial p) {
        Polynomial NewPoly=new Polynomial("0");
        for (int i=0;i<p.poly.size();i++) {
            NewPoly.poly.add(poly.get(0).mult(p.poly.get(i)));
        }
        Polynomial addMe=new Polynomial("0");
        for (int i=0;i<poly.size();i++)
        {
            for (int j=1; j<p.poly.size();j++) {
                addMe.poly.add(p.poly.get(j).mult(this.poly.get(i)));
            }
            NewPoly=NewPoly.add(addMe);
        }
        return NewPoly;

    }

    Scalar evaluate(Scalar s) {
        Scalar scalar= new Rational(0,1);
        for (int i = 0; i <poly.size() ; i++) {
            scalar=scalar.add(poly.get(i).evaluate(s));

        }
        return scalar;
    }

    Polynomial derivative() {
        Polynomial NewPoly=new Polynomial("");
        for (int i=0;i<=poly.size();i++)
        {
            NewPoly.poly.add(poly.get(i).derivative());
        }
        return NewPoly;
    }

    public String toString() {
        String s="";
        s=poly.get(0).toString();
        for (int i=1;i<poly.size();i++)
        {
            if(poly.get(i).toString().contains("-"))
            {
                s += " " + poly.get(i).toString().charAt(0) + " " + poly.get(i).toString().substring(1);
            }
            else{
                s += " + "+ poly.get(i).toString();
            }

        }
        //s = s.substring(0, s.length()-1);
        return s;
    }

    private String[] backToInput() {
        String[] output = new String[poly.get(poly.size() - 1).getExp() + 1];
        for (Monomial m: poly) {
            output[m.getExp()] = m.getCoefficient().toString();
        }
        for (String s: output) {
            if (s == null) s = "0";
        }
        return output;
    }

    private boolean[] exps() {
        boolean[] output = new boolean[poly.get(poly.size() - 1).getExp() + 1];
        for (Monomial m: poly) {
            output[m.getExp()] = true;
        }
        return output;
    }
}