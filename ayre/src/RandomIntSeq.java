
import java.awt.Color;
import java.util.Scanner;

   public class RandomIntSeq{
	   
	   
	   
	   
	   public static boolean[][] flow(boolean[][] a) {
			
			boolean[][] isFull = new boolean[a.length][a[0].length];
			for (int j=0; j<a[0].length; j++) {
				flow(a, isFull, 0, j);
			}
			return isFull;
		}
	   
	   
		
		private static void flow(boolean[][] a, boolean[][] b, int i, int j) {
			
			
			if (i<0 || a.length<=i || j<0 || a[0].length<= j) {
				return;
			}
			if (!a[i][j]) return;
			if (b[i][j]) return;
			b[i][j]=true;
			flow(a,b,i+1,j);
			flow(a,b,i,j+1);
			flow(a,b,i,j-1);
			flow(a,b,i-1,j);
		}
		
		public static void drawbool(boolean[][] a, boolean which ) {
			   
			   
			   for (int i=0; i<a.length; i++) {
				   for (int j=0; j<a.length; j++) {
					   if (a[i][j]==which) {
					   StdDraw.filledSquare(j, a.length-1-i, 0.5);
					   StdDraw.show();
					   }
				   }
			   }
			   StdDraw.show();
			   
			   
		   }
		
		
		
		
		public static boolean[][] random(int n, double p) {
			
		    boolean[][] a = new boolean[n][n];
			for (int i=0; i<n; i++) {
				   for (int j=0; j<n; j++) {
					   a[i][j]= StdRandom.bernoulli(p);
				   }
		  }
			return a;
		}
		
		
	    public static boolean percolate(boolean[][] a) {
			
			boolean[][] b = flow(a);
	    	for (int i=0; i<a.length; i+=1) {
		         
		        	 if (b[a.length-1][i]) {
		        		 return true;
		        	 }
			}     
			return false;
		}
	    
       public static int bernoullipercolate(int n) {
			
	      int count=0;		
	      for (int i=0; i<n; i++) {
	    	  boolean[][] a = random(5,0.6);
	    	  if (percolate(a)) {
	    		  count++;
	    	  }
	      }
	      return count;
		}
	    
        
	    
        
	    
	    
	    public static double percestimate(int n, double p, int trial) {
	    	
	    	int count=0;
	    	for (int t=0;t <trial; t++) {
	    		boolean[][] isOpen= random(n,p);
	    		if (percolate(isOpen)) {
	    			count++;
	    		}
	    	}
	    	return (count*1.0/trial);
	    }
	    
	    
	    public static void curve(int n, double x0, double y0, double x1, double y1) {
	    	
	    	double gap=0.01;
	    	double err=0.0025;
	    	int trial = 10000;
	    	double xm= (x0+x1)/2;
	    	double ym = (y0+y1)/2;
	    	double fxm= percestimate(n, xm, trial);
	    	if (x1-x0<gap || Math.abs(fxm-ym)<err) {
	    		StdDraw.line(x0, y0, x1, y1);
	    		return;
	    	}
	    	curve(n, x0, y0, xm, fxm);
	    	StdDraw.filledCircle(xm, fxm, 0.005);
	    	curve(n, xm, fxm, x1, y1);
	    	
	    }
	    
	    

		
		
		
		public static void main(String[] args) {
			
			Scanner myInput = new Scanner(System.in);
			int n = myInput.nextInt();
			int trial =10000;
			int[] freq = new int[n+1];
			for (int t=0; t<trial; t++) {
				freq[bernoullipercolate(n)]++;
			}
			double[] norm = new double[n+1];
			for (int i=0; i<=n; i++) {
				norm[i]=1.0*freq[i]/trial;
			}
			StdStats.plotBars(norm);
			
		}
   }
      