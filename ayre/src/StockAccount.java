
public class StockAccount implements Comparable<StockAccount> 
{

	private final String name;
	private double cash;
	private int n;
	private int[] shares;
	private String[] stock;
	
	
	public int compareTo(StockAccount that) {
		
		if(name.compareTo(that.name)<0) return -1;
		else if(name.compareTo(that.name)==0) return 0;
		else return 0;
	}
	
	public StockAccount(In in) {
		
		//In in = new In(filename);
		name=in.readLine();
		cash=in.readDouble();
		n=in.readInt();
		shares=new int[n];
		stock=new String[n];
		for (int i=0; i<n; i++) {
			shares[i]=in.readInt();
			stock[i]=in.readString();
		}
	}
	
	public double valueOf() {
		
		double total=cash;
		for (int i=0; i<n; i++) {
			total+=shares[i]*StockQuote.priceOf(stock[i]);
		}
		return total;
	}
	
	public void save(Out filename)  {
		
		filename.println(name);
		filename.println(cash);
		filename.println(n);
		for (int i=0; i<n; i++) {
			filename.print(shares[i]+"   ");
			filename.println(stock[i]);
		}
	}
	
	public void addCash(double x) {
		
		cash=cash+x;
	}
	
	public void printReport() {
		
		System.out.println(name);
		double total=cash;
		for (int i=0; i<n; i++) {
			int amount=shares[i];
			double price=StockQuote.priceOf(stock[i]);
			total+=amount*price;
			System.out.printf("%4d %5s ", amount, stock[i]);
			System.out.printf("%9.2f %11.2f\n", price, amount*price);
			
		}
		System.out.printf("%21s %10.2f\n ", "Cash: ", cash);
		System.out.printf("%20s %10.2f\n", "Total:", total);
	}
	
	
	public static void main(String[] args) {
		
		//I modified the class to take In instead of String la2an ahsan w "zaabart" cz na22et n de8re
		int n= Integer.parseInt(args[0]);
		In in=new In(args[1]);
		StockAccount[] acc=new StockAccount[n];
		for (int i=0; i<n; i++) {
			acc[i]=new StockAccount(in);
			in.readLine();
		}
		double max=acc[0].valueOf();
		double min=acc[0].valueOf();
		int cmax=0;
		int cmin=0;
		for (int i=1; i<n; i++) {
			double t=acc[i].valueOf();
			if (max<t) {
				max=t;
				cmax=i;
			}
			if(t<min) {
				min=t;
				cmin=i;
			}
		}
		acc[cmin].printReport();
		acc[cmax].printReport();
		

	}

	

}
