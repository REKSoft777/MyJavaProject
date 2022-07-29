import java.awt.Color;
import java.util.Objects;
public class Charge {

	private final double rx,ry;
	private double q;
	
	public Charge(double x0, double y0, double q0) {
		rx=x0;
		ry=y0;
		q=q0;
	}
	
	public double potentialAt(double x, double y) {
		
		double k = 8.99e09;
		double dx=x-rx;
	    double dy=y-ry;
	    return k*q/Math.sqrt(dx*dx+dy*dy);
	}
	
	
    public boolean equals(Object x) {
    	
    	if (x==null) return false;
    	if (this.getClass() != x.getClass()) return false;
    	Charge that=(Charge) x;
    	return (rx==that.rx & ry==that.ry & q==that.q);
    }
    
    public int hashCode() {
    	
    	
    	return Objects.hash(rx,ry,q);
    }
    
	public String toString() {
		
		return q+ " at ("+ rx + ","+ry+ ")";
	}
	
	public void incrementq(double x) {
		
		q+=x;
	}
	
	
	
	

	

	    public static void main(String[] args) {

	        Charge a= new Charge(5,7,12.5);
	        Charge b = new Charge(8,6,9);
	        Charge c= new Charge(5,7,12.5);
	        System.out.println(a.equals(b));
	        System.out.println(a.equals(c));
	        System.out.println(a.hashCode());
	        System.out.println(b.hashCode());
	        System.out.println(c.hashCode());
	    }
	}   


