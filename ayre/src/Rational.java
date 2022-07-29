
public class Rational {

	private final int num,den;
	
	public Rational(int numerator, int denominator) {
		
		if (denominator==0) {
			throw new IllegalArgumentException("Denominator is 0");
		}
		if ((numerator<0 & 0<denominator) || (0<numerator & denominator<0)) {
			num=-Math.abs(numerator)/gcd(Math.abs(numerator),Math.abs(denominator));
			den=Math.abs(denominator)/gcd(Math.abs(numerator),Math.abs(denominator));
		}
		else {
			num=Math.abs(numerator)/gcd(Math.abs(numerator),Math.abs(denominator));
			den=Math.abs(denominator)/gcd(Math.abs(numerator),Math.abs(denominator));
		}
	}
	
	private static int gcd(int p,int q) {
		
		if (q==0) return p;
		if (p<q) return gcd(q,p);
		return gcd(q,p%q);
	}
	
	public String toString() {
		
		return num+"/"+den;
	}
	
	public Rational plus(Rational r) {
		
		return new Rational(num*r.den+r.num*den, den*r.den);
	}
	
	public Rational minus(Rational r) {
		
		return new Rational(num*r.den-r.num*den, den*r.den);
	}
	
	public Rational times(Rational r) {
		
		return new Rational(num*r.num,den*r.den);
	}
	
	public Rational divides(Rational r) {
		
		return new Rational(num*r.den,den*r.num);
	}
	
	public static void main(String[] args) {
		
		Rational x, y, z;

        
        x = new Rational(1, 2);
        y = new Rational(1, 3);
        z = x.plus(y);
        StdOut.println(z);

        // 8/9 + 1/9 = 1
        x = new Rational(8, 9);
        y = new Rational(1, 9);
        z = x.plus(y);
        StdOut.println(z);

        //  4/17 * 7/3 = 28/51
        x = new Rational(4, 17);
        y = new Rational(7,  3);
        z = x.times(y);
        StdOut.println(z);

        // 203/16957 * 9299/5887 = 17/899
        x = new Rational(203, 16957);
        y = new Rational(9299, 5887);
        z = x.times(y);
        StdOut.println(z);

        // 0/6 = 0
        x = new Rational(0, 6);
        StdOut.println(x);

    }

	
	

}
