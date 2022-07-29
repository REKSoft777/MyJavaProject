import java.util.Objects;

public class Vector2D { 

             
    private final Complex z;       
    
    public Vector2D(double x, double y) {
        z=new Complex(x,y);
        
        
    }

    
    public double dot(Vector2D that) {
  
        return z.Re()*that.z.Re()+z.Im()*that.z.Im();
    }

   
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }

    public Vector2D plus(Vector2D that) {
        
        return new Vector2D(z.Re()+that.z.Re(),z.Im()+that.z.Im());
    }

    
    public Vector2D minus(Vector2D that) {
        
        return new Vector2D(z.Re()-that.z.Re(),z.Im()-that.z.Im());
    }

    public  Vector2D scale(double factor) {
        return new Vector2D(factor*z.Re(),factor*z.Im());
    }


    
    public Vector2D direction() {
        if (this.magnitude() == 0.0)
            throw new ArithmeticException("zero-vector has no direction");
        return this.scale(1.0 / this.magnitude());
    }

    
    public String toString() {
        
    	return "("+z.Re()+","+z.Im()+")";
    }

    public int hashCode() {
    	return Objects.hash(z.Re(),z.Im());
    }

    
    public static void main(String[] args) {
    	
    	Vector2D v= new Vector2D(5,-2);
    	Vector2D u = new Vector2D(2,7);
    	Vector2D w= new Vector2D(5,-2);
    	System.out.println(u.dot(v));
    	System.out.print(u.hashCode());
    }
}
