import java.awt.Color;
import java.util.Scanner;

public class percolation {

	
	
	
	public static boolean[][][] random(int n, double p) {
		
	    boolean[][][] a = new boolean[n][n][6];
		for (int i=0; i<n; i++) {
			   for (int j=0; j<n; j++) {
				   for (int k=0; k<6; k++) {
					   a[i][j][k]= StdRandom.bernoulli(Math.sqrt(p));
				   }
				   
			   }
	  }
		return a;
	}
	
	public static void printbool3D(boolean[][][] a) {
		
		for (int i=0; i<a.length; i++) {
			   for (int j=0; j<a[i].length; j++) {
				   for (int k=0; k<6; k++) {
					   System.out.print(a[i][j][k]+ " ");
				   }
				   System.out.print("    ");
			   }
			   System.out.println();
		}
	}
	
	public static void drawbool3D(boolean[][][] a) {
		
		boolean[][][] b = new boolean[a.length+2][a[0].length+2][6];
		for (int i=1; i<=a.length; i++) {
			   for (int j=1; j<=a[0].length; j++) {
				   for (int k=0; k<6; k++) {
					   b[i][j][k]=a[i-1][j-1][k];
				   }
			   }
		}
		for (int i=1; i<=a.length; i++) {
			for (int j=1; j<=a[0].length; j++) {
				if (b[i][j][0] & b[i][j+1][1]) {
					StdDraw.line(j, a.length-i, j+1, a.length-i);
				}
				if (b[i][j][4] & b[i+1][j+1][5]) {
					StdDraw.line(j, a.length-i, j+1, a.length-i-1);
				}
			}
		}
		for (int j=1; j<=a[0].length; j++) {
			for (int i=1; i<=a.length; i++) {
				if (b[i][j][2] & b[i+1][j][3]) {
					StdDraw.line(j, a.length-i, j, a.length-i-1);
				}
			}
		}
		
	}
	
	
    
    
    
    
    
    
    
    
    

	
	
	
	public static void main(String[] args) {
		
		Scanner myInput = new Scanner(System.in);
		int n = myInput.nextInt();
		boolean[][][] a = random(n,0.5);
		printbool3D(a);
		boolean[][][] b = new boolean[a.length+2][a.length+2][6];
		for (int i=1; i<=a.length; i++) {
			   for (int j=1; j<=a[0].length; j++) {
				   for (int k=0; k<6; k++) {
					   b[i][j][k]=a[i-1][j-1][k];
				   }
			   }
		}
		printbool3D(b);
   	    StdDraw.setXscale(-2, n+2);
   	    StdDraw.setYscale(-2, n+2);
   	    drawbool3D(a);
	}
	}


