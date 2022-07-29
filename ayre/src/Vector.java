import java.util.Arrays;
import java.util.Objects;

public class Vector implements Comparable<Vector>
{ 

            
    private final double[] coords;       
 
    public Vector(double[] freq) {
         
    	coords=new double[freq.length];
        for (int i = 0; i<freq.length; i++) {
            coords[i] = freq[i];
        }
    }

    public int length() {
        return coords.length;
    }
    
	public int compareTo(Vector that) {
		
		if (this.magnitude()<that.magnitude()) return -1;
		else if (this.magnitude()>that.magnitude()) return 1;
		else {
			if (coords.length<that.coords.length) return -1;
			else if(coords.length>that.coords.length) return 1;
			else {
				for (int i = 0; i<coords.length; i++) {
					if(coords[i]>that.coords[i]) return 1;
					else if(coords[i]<that.coords[i]) return -1;
				}
			}
		}
		return 0;
	}

    public double dot(Vector that) {
        if (this.length() != that.length()) {
            throw new IllegalArgumentException("dimensions disagree");
        }
        double sum = 0.0;
        for (int i = 0; i < coords.length; i++) {
            sum = sum + (coords[i] * that.coords[i]);
        }
        return sum;
    }

    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    public double distanceTo(Vector that) {
        if (this.length() != that.length()) {
            throw new IllegalArgumentException("dimensions disagree");
        }
        return this.minus(that).magnitude();
    }

    public Vector plus(Vector that) {
        if (this.length() != that.length()) {
            throw new IllegalArgumentException("dimensions disagree");
        }
        double[] co= new double[coords.length];
        Vector c = new Vector(co);
        for (int i = 0; i < coords.length; i++) {
            c.coords[i] = coords[i] + that.coords[i];
        }
        return c;
    }

    public Vector minus(Vector that) {
        if (this.length() != that.length()) {
            throw new IllegalArgumentException("dimensions disagree");
        }
        double[] co= new double[coords.length];
        Vector c = new Vector(co);
        for (int i = 0; i < coords.length; i++) {
            c.coords[i] = coords[i] - that.coords[i];
        }
        return c;
    }

    public double cartesian(int i) {
        return coords[i];
    }

    public Vector scale(double factor) {
    	double[] co = new double[coords.length];
        Vector c = new Vector(co);
        for (int i = 0; i < coords.length; i++) {
            c.coords[i] = factor * coords[i];
        }
        return c;
    }

    public Vector direction() {
        if (this.magnitude() == 0.0) {
            throw new ArithmeticException("zero-vector has no direction");
        }
        return this.scale(1.0 / this.magnitude());
    }

    public String toString() {
       
    	
    	StringBuilder s = new StringBuilder();
        s.append('(');
        for (int i = 0; i < coords.length; i++) {
            s.append(coords[i]);
            if (i < coords.length-1) s.append(", ");
        }
        s.append(')');
        return s.toString();
    }
    
    public boolean equals(Object x) {
    	
    	if (x==null) return false;
    	if (this.getClass() != x.getClass()) return false;
    	Vector that=(Vector) x;
    	if (that.coords.length!=this.coords.length) return false;
    	for (int i = 0; i < coords.length; i++) {
    		if (coords[i]!=that.coords[i]) return false;
    	}
    	return true;
    }
    
    public int hashCode() {
    	
    	return Arrays.hashCode(coords);
    }


    public static void main(String[] args) {
        double[] xdata = {1.0, 2.0, 3.0, 4.0};
        double[] ydata = { 5.0, 2.0, 4.0, 1.0 };
        double[] zz= {1,2,3,4};
        

        Vector x = new Vector(xdata);
        Vector y = new Vector(ydata);
        Vector z = new Vector(zz);

        StdOut.println("x        =  " + x);
        StdOut.println("y        =  " + y);
        StdOut.println("x + y    =  " + x.plus(y));
        StdOut.println("10x      =  " + x.scale(10.0));
        StdOut.println("|x|      =  " + x.magnitude());
        StdOut.println("<x, y>   =  " + x.dot(y));
        StdOut.println("|x - y|  =  " + x.minus(y).magnitude());
        System.out.println(y.hashCode());
        
    }

	
}
