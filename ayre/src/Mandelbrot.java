import java.awt.Color;

public class Mandelbrot {

	private static int mand(Complex z0, int max) {
		
		Complex z=z0;
		for (int t=0; t<max; t++) {
			if (z.norm()>2) {
				return t;
			}
            z=z.times(z).plus(z0);
		}
		return max;
	}
	
	private static int mand(double a0, double b0, int max) {
		
		double a=a0;
		double b=b0;
		for (int t=0; t<max; t++) {
			double olda=a;
			if (Math.sqrt(a*a+b*b)>2) {
				return t;
			}
			a=a*a-b*b+a0;
			b=2*olda*b+b0;
		}
		return max;
	}
	
	public static void main(String[] args) {
		
		Picture pic = new Picture(800,800);
		Color[] color= new Color[256];
		for (int i=0; i<256; i++) {
			int a =Integer.parseInt(args[3*i]);
			int b =Integer.parseInt(args[3*i+1]);
			int c =Integer.parseInt(args[3*i+2]);
			color[i]=new Color(a,b,c);
		}
		for (int col=0; col<pic.width(); col++) {
			   for (int row=0; row<pic.height(); row++) {
				   int g = mand(new Complex(-1.5+2*col/800.0,-1+2*row/800.0),255);
				   pic.set(col, row, color[g]);
			   }
		}
		pic.show();
	}

}
