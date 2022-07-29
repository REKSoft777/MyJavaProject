
public class Universe {
    private final int n;             // number of bodies
    private final Body[] bodies;     // array of n bodies

    // read universe from standard input
    public Universe(String str) {

        // number of bodies
    	In in = new In(str);
        n = in.readInt(); 

        // the set scale for drawing on screen
        double radius = in.readDouble(); 
        StdDraw.setXscale(-radius, +radius); 
        StdDraw.setYscale(-radius, +radius); 

        // read in the n bodies
        bodies = new Body[n]; 
        for (int i = 0; i < n; i++) { 
            double rx   = in.readDouble(); 
            double ry   = in.readDouble(); 
            double vx   = in.readDouble(); 
            double vy   = in.readDouble(); 
            double mass = in.readDouble(); 
            double[] position = { rx, ry }; 
            double[] velocity = { vx, vy }; 
            Vector r = new Vector(position); 
            Vector v = new Vector(velocity); 
            bodies[i] = new Body(r, v, mass); 
        } 
    } 

    
    public void increaseTime(double dt) {

        // initialize the forces to zero
        Vector[] f = new Vector[n];
        for (int i = 0; i < n; i++) {
            f[i] = new Vector(new double[2]);
        }

        // compute the forces
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    f[i] = f[i].plus(bodies[i].forceFrom(bodies[j]));
                }
            }
        }

        // move the bodies
        for (int i = 0; i < n; i++) {
            bodies[i].move(f[i], dt);
        }
    }

    // draw the n bodies
    public void draw() {
        for (int i = 0; i < n; i++) {
            bodies[i].draw();
        }
    } 


    // client to simulate a universe
    public static void main(String[] args) {
        Universe newton = new Universe(args[1]);
        double dt = Double.parseDouble(args[0]);
        StdDraw.enableDoubleBuffering();
        while (true) {
            StdDraw.clear(); 
            newton.increaseTime(dt); 
            newton.draw(); 
            StdDraw.show();
            StdDraw.pause(10);
        } 
    } 
}
