
public class Gaussian {

	
	public static double pdf(double x) {
		
		return (Math.exp(-x*x/2)/Math.sqrt(2*Math.PI));
	}
	
    public static double pdf(double x, double mu, double sigma) {
		
    	double a = (x-mu)/sigma;
		double b = Math.exp(-a*a/2)/Math.sqrt(2*Math.PI);
		return b/sigma;
	}
	
	
	public static double cdf(double z) {
		if (z< -8) {
			return 0;
		}
		if (8< z) {
			return 1;
		}
		double sum=0;
		double term=z;
		for (int i=3; sum != sum+term; i+= 2) {
			sum=sum+term;
			term=term*z*z/i;
		}
		return 0.5 + sum*pdf(z);
	}
	
	public static double cdf(double z, double mu, double sigma) {
		double a = (z-mu)/sigma;
		if (a < -8) {
			return 0;
		}
		if (8< a) {
			return 1;
		}
		double sum=0;
		double term=a;
		for (int i=3; sum != sum+term; i+= 2) {
			sum=sum+term;
			term=term*a*a/i;
		}
		return 0.5 + sum*pdf(a);
	}
	
	public static void main(String[] args) {
		

	}

}
