
public class Body {
    private Vector r;           
    private Vector v;           
    private final double mass;  
    

    public Body(Vector r0, Vector v0, double m0) {
        r = r0;
        v = v0;
        mass = m0;
    }

    public void move(Vector f, double dt) {
        Vector a = f.scale(1/mass);
        v = v.plus(a.scale(dt));
        r = r.plus(v.scale(dt));
    }

    public Vector forceFrom(Body b) {
        
        double G = 6.67e-11;
        Vector delta = b.r.minus(r);
        double dist = delta.magnitude();
        double magnitude = (G * mass * b.mass) / (dist * dist);
        return delta.direction().scale(magnitude);
    }

    public void draw() {
        StdDraw.setPenRadius(0.025);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    }
    
    public void drawC() {
        StdDraw.setPenRadius(0.025);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    }

    // this method is only needed if you want to change the size of the bodies
    public void draw(double penRadius) {
        StdDraw.setPenRadius(penRadius);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    }

} 
