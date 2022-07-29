import java.awt.Color;

public class Complex {

	private final double re,im;
	
	public Complex(double real, double imaginary) {
		re=real;
		im=imaginary;
	}
	
	public  double Re() {
		return re;
	}
	public  double Im() {
		return im;
	}
	
	public String toString() {
		
		if (re==0 & im==0) {
		       return "0";
		}
		else if (this.re==0) {
		       return im+"i";
		}
		else if (this.im==0) {
		       return re+"";
		}
		else if (this.im<0) {
		      return re+""+im+"i";
		}
		else {
		      return re+ "+" + im+ "i";
		
		}


	}
	
	
	public double theta() {
		
		if (0<re) {
		    double a = im/re;
		    return Math.atan(a);
		}
		if (re<0) {
		    double a = im/re;
		    return Math.atan(a)+Math.PI;
		}
		if (im<0) {
			return -Math.PI/2;
		}
		if (0<im) {
			return Math.PI/2;
		}
		return 0;
	}
	
	public Complex conjugate() {
		
		return new Complex(re,-im);
	}
	
	public Complex plus(Complex z) {
		
		return new Complex(re+z.re,im+z.im);
	}
	
	public Complex minus(Complex z) {
		
		return new Complex(re-z.re,im-z.im);
	}
	
	public Complex times(Complex z) {
		
		return new Complex(re*z.re-im*z.im, re*z.im+im*z.re);
	}
	
	public Complex divide(double real) {
		
		return new Complex(re/real,im/real);
	}
	
	public Complex divide(Complex z) {
		
		double real=(z.times(z.conjugate())).re;
		return this.times(z.conjugate()).divide(real);
	}
	
	
	public Complex power(int n) {
		
		if (n==0) {
			return new Complex(1,0);
		}
		return this.times(this.power(n-1));
	}
	
	public double norm() {
		
		return Math.sqrt(re*re+im*im);
	}
	
	public String toPolar() {
		
		return "("+this.norm()+","+Math.toDegrees(this.theta())+")";
	}
	
	public Complex rootsOfUnity(int n) {
		
		double normR=Math.pow(this.norm(),1.0/n);
		double thetaR=this.theta()/n;
		return new Complex(normR*Math.cos(thetaR),normR*Math.sin(thetaR));
	}
	
	public static void main(String[] args) {
		
			Complex z = new Complex(1,0);
			Picture pic = new Picture(800,800);
			for (int col=0; col<pic.width(); col++) {
				   for (int row=0; row<pic.height(); row++) {
					   Complex t = new Complex(-1+2*col/800.0,-1+2*row/800.0);
					   int count=0;
					   while (z.minus(t.power(4)).norm()>1e-15 & 100>count) {
							t=t.minus((t.power(4).minus(new Complex(1,0))).divide((t.power(3).times(new Complex(4,0)))));
							count++;
						}
					   if (count==100) {
						   pic.set(col, 800-1-row, Color.BLACK);
					   }
					   else if (t.minus(new Complex(-1,0)).norm()<1e-8) {
						   pic.set(col, 800-1-row, Color.RED);
					   }
					   else if (t.minus(new Complex(0,-1)).norm()<1e-8) {
						   pic.set(col, 800-1-row, Color.blue);
					   }
					   else if (t.minus(new Complex(0,1)).norm()<1e-8) {
						   pic.set(col, 800-1-row, Color.green);
					   }
					   else {
						   pic.set(col, 800-1-row, Color.white);
					   }
				   }
			}
			pic.show();
			
			
			//t=t.divide(new Complex(1.1,1.1));
			//System.out.println(t);
			
	}
}
