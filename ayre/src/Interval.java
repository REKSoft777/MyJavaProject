import java.util.Scanner;
public class Interval {

	private final double xmin,xmax;
	
	public Interval(double min, double max) {
		
		xmin=min;
		xmax=max;
	}
	
	public  boolean contains(double x) {
		
		if (x<=xmax & xmin<=x) {
			return true;
		}
		return false;
	}
	
	public boolean intersects(Interval b) {
		
		if ((b.xmin<=xmin & xmin<=b.xmax) || (b.xmin<=xmax & xmax<=b.xmax) || (this.contains(b.xmin) & this.contains(b.xmax)) || (b.contains(xmin) & b.contains(xmax))) {
			return true;
		}
		return false;
	}
	
	public String toString() {
		
		return "["+xmin+","+xmax+"]";
	}
	
	public static void main(String[] args) {
		
		Scanner myInput = new Scanner(System.in);
		int n= Integer.parseInt(args[0]);
		Interval[] a = new Interval[n];
		for (int i=0; i<n; i++) {
			double x = myInput.nextDouble();
			double y = myInput.nextDouble();
			a[i]=new Interval(x,y);
		}
		for (int i=0; i<n-1; i++) {
			   for (int j=i+1; j<n; j++) {
				   if (a[i].intersects(a[j])) {
					   System.out.println(a[i]+"X"+a[j]);
				   }
			   }
	}
	}
}
