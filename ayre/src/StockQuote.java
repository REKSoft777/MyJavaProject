
public class StockQuote {
	
	
	private static String fin = "goog 1253$\namzn 1956$\naapl 1057$\nmsft 1123$";
	
	public static double priceOf(String str) {
		
		int start = fin.indexOf(str);
		int end= fin.indexOf("$",start);
		String ret=fin.substring(start+str.length(),end);		
		return Double.parseDouble(ret);
	}

	public static void main(String[] args) {
		
		System.out.println(priceOf("aapl"));
		
		
		

	}

}
