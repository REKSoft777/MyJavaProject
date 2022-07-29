import java.util.Scanner;

public class Hyperbolic {

	public static double cosh(double x) {
		return (Math.exp(x)+Math.exp(-x))/2;
	}
	
	public static double sinh(double x) {
		return (Math.exp(x)-Math.exp(-x))/2;
	}
	
	public static double tanh(double x) {
		return (sinh(x)/cosh(x));
	}
	
	public static double coth(double x) {
		  return   cosh(x)/sinh(x);
	
	}
	
	public static double csch(double x) {
		  return   1.0/sinh(x);
	
	}
	
	
	public static double sech(double x) {
		  return   1.0/cosh(x);
	
	}
	
	
	
	public static void main(String[] args) {
		double[] a = new double[501];
		for (int i=0; i<=500; i++) {
			a[i]= coth(-2*Math.PI+(i*1.0/500)*4*Math.PI);
			
		}
		System.out.println(coth(-2*Math.PI));
		System.out.println(coth(2*Math.PI));
		System.out.println(coth(0));
		System.out.println(a[0]);
		System.out.println(a[50]);
		System.out.println(a[150]);
		System.out.println(a[250]);
		System.out.println(a[350]);
		System.out.println(a[450]);
		System.out.println(a[500]);
		System.out.println(a[250]);
	}

}
