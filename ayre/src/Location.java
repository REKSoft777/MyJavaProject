public class Location {

	private final double lat;
	private final double longi;
	
	public Location(double latitude, double longitude) {
		
		lat=latitude;
		longi=longitude;
	}
	
	public double getLatitude() {
		
		return lat;
	}
	
	public double getLongitude() {
		
		return longi;
	}
	
	public double distanceTo(Location loc) {
		
		double x1=lat;
		double x2=loc.getLatitude();
		double y1=longi;
		double y2=loc.getLongitude();
		x1=Math.toRadians(x1);
		x2=Math.toRadians(x2);
		y1=Math.toRadians(y1);
		y2=Math.toRadians(y2);
		double sx1=Math.sin(x1);
		double sx2=Math.sin(x2);
		double cx1=Math.sin(x1);
		double cx2=Math.sin(x2);
		return 60*Math.acos(sx1*sx2+cx1*cx2*Math.cos(y1-y2));
	}
	
	public static Location parseLocation(String str) {
		
		String xx = str.substring(0,str.indexOf("N"));
		String yy= str.substring(str.indexOf("N")+2,str.indexOf("W"));
		double x= Double.parseDouble(xx);
		double y= Double.parseDouble(yy);
		return new Location(x,y);
	}
	
	public String toString() {
		
		return "Latitude: "+lat+"N\nLongitude: "+longi+"W";
	}
	
	public static Location randomLoc() {
		
		double x =360*Math.random();
		double y= 360*Math.random();
		return new Location(x,y);
	}
	
	
	public static void main(String[] args) {
		
		Location paris= new Location(48.87,-2.33);
		Location SanFransisco= new Location(37.8,122.4);
		System.out.println(paris.distanceTo(SanFransisco));
		String str="25.344 N, 63.552W";
		Location u= parseLocation(str);
		System.out.println(u);

	}

}
