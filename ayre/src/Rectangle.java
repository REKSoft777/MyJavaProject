
public class Rectangle {

	private final double x, y;
	private final double w,h;
	
	private final double xmax,ymax,xmin,ymin;
	
	public Rectangle(double x0,double y0,double width,double height) {
		
		x=x0;
		y=y0;
		w=width;
		h=height;
		xmin=x-w/2;
		xmax=x+w/2;
		ymin=y-h/2;
		ymax=y+h/2;
	}
	
	
	
	public double area() {
		return  w*h;
	}
	
	public double perimeter() {
		
		return 2*w+2*h;
	}
	
	public double getXmax() {
		
		return xmax;
	}
	
    public double getXmin() {
		
		return xmin;
	}
    
    public double getYmax() {
		
		return ymax;
	}
	
    public double getYmin() {
		
		return ymin;
	}
	
	public boolean contains(Rectangle rect) {
		
		if (rect.getXmax()<=this.getXmax() & this.getXmin()<=rect.getXmin() & rect.getYmax()<=this.getYmax() & this.getYmin()<=rect.getYmin()) {
			return true;
		}
		return false;
	}
	
	public boolean intersects(Rectangle rect) {
		
		if ((this.contains(rect) || rect.contains(this)) & (rect.xmin!=xmin & rect.xmax!=xmax & rect.ymin!= ymin & rect.ymax!=ymax)) {
			return false;
		}
		
		if(this.xIntersects(rect) & this.yIntersects(rect)) {
			return true;
		}
		return false;
	}
	
	
	
	public boolean xIntersects(Rectangle b) {
		
		if ((b.xmin<=xmin & xmin<=b.xmax) || (b.xmin<=xmax & xmax<=b.xmax) || (xmin<=b.xmin & b.xmax<=xmax) || (b.xmin<=xmin & xmax<=b.xmax)) {
			return true;
		}
		return false;
	}
	
    public boolean yIntersects(Rectangle b) {
		
		if ((b.ymin<=ymin & ymin<=b.ymax) || (b.ymin<=ymax & ymax<=b.ymax) || (ymin<=b.ymin & b.ymax<=ymax) || (b.ymin<=ymin & ymax<=b.ymax)) {
			return true;
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		
		int n = Integer.parseInt(args[0]);
		double min = Double.parseDouble(args[1]);
		double max = Double.parseDouble(args[2]);
		for (int i=0; i<n; i++) {
			double width = StdRandom.uniform(min, max);
			double height = StdRandom.uniform(min,max);
			Rectangle rect = new Rectangle(StdRandom.)
		}

	}

}
