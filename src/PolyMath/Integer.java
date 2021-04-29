package PolyMath;

public class Integer implements Scalar {
    private int number;

    public Integer (int num)
    {
        this.number=num;
    }
    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }
    public int getNumber()
    {
        return number;
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }

    @Override
    public Scalar addRational(Rational s) {
        return s.addInteger(this);
    }

    @Override
    public Scalar addInteger(Integer s) {
        return new Integer(s.getNumber()+this.number);
    }

    @Override
    public Scalar mulRational(Rational s) {
        return s.mulInteger(this);
    }

    @Override
    public Scalar mulInteger(Integer s) {
        return new Integer(s.getNumber()*this.number);
    }

    @Override
    public Scalar power(int exponent) {
        Scalar powered=new Integer(1);
        for (int i=1; i<=exponent;i++)
        {
            powered=powered.mulInteger(this);
        }
        return  powered;
    }

    @Override
    public int sign() {
        int output=0;
        if(this.number<0)
            output=-1;
        else if (this.number>0)
            output=1;
        return output;
    }

    @Override
    public Scalar neg() {
        return new Integer(this.number*-1);
    }

    public String toString() {
        return String.valueOf(number);
    }
}