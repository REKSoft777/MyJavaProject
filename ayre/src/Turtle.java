
public class Turtle {

	private double x,y;
	private double angle;
	
	public Turtle(double a, double b, double alpha) {
		
		x=a;
		y=b;
		angle=alpha;
	}
	
	public void turnLeft(double delta) {
		
		angle+=delta;
	}
	
	public void goForward(double step) {
		
		double oldx=x;
		double oldy=y;
		x+=step*Math.cos(Math.toRadians(angle));
		y+=step*Math.sin(Math.toRadians(angle));
		StdDraw.line(oldx, oldy, x, y);
	}
	
	
	public static void main(String[] args) {
		
		
		int n= Integer.parseInt(args[0]);
		
		double angle = 360/n;
		double step=Math.sin(Math.toRadians(angle));
		StdDraw.setXscale(0,3);
		StdDraw.setYscale(0,3);
		Turtle turtle= new Turtle(1,0.75,0);
		for (int i=0; i<n; i++) {
			turtle.goForward(step);
			turtle.turnLeft(angle);
		}

	}

}
