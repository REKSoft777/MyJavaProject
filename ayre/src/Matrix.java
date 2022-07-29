import java.util.Scanner;
public class Matrix {
	
	public static double dot(double[] a, double[] b) {
		int n = Math.min(a.length, b.length);
		double sum=0;
		for (int i=0; i<n; i++) {
			sum += a[i]*b[i];
		}
		return sum;
	}




     public static double[][] multiply(double[][] a, double[][] b) {
    	 double[][] c = new double[a.length][b[0].length];
    	 for (int i=0; i<a.length; i++) {
    		 for (int j=0; j<b[i].length; j++) {
    			 for (int k=0; k<a[0].length; k++) {
    				 c[i][j]+= a[i][k]*b[k][j];
    			 }
    		 }
    	 }
    	 return c;
	
}
     
     
     public static double[][] transpose(double[][] a) {
    	 double[][] b = new double[a.length][a[0].length];
    	 for (int i=0; i<a.length; i++) {
    		 for (int j=0; i<a[i].length; j++) { 
    			 b[i][j]=a[j][i];
    		 }
     }
    	 return b;	
}
     
     
     public static double[] multiply(double[] a, double[][] b) {
    	 double[] c = new double[b[0].length];
    		 for (int j=0; j<b[0].length; j++) {
    			 for (int k=0; k<a.length; k++) {
    				 c[j]+= a[k]*b[k][j];
    			 }
    		 }
    	 return c;
	
}
     
     
     public static void main(String[] args) {
    	 int trial=Integer.parseInt(args[0]);
    	 Scanner myInput = new Scanner(System.in);
    	 double[][] p = StdArrayIO.readDouble2D();
    	 double[][] ranks = new double[p.length][p[0].length];
    	 for (int i=0; i<p.length; i++) {
    		 for (int j=0; j<p[i].length; j++) {
    			 ranks[i][j]=p[i][j];
    		 }
    	 }
    	 for (int i=0; i<trial; i++) {
    		 ranks = Matrix.multiply(ranks, ranks);
    	 }
    	 StdArrayIO.print(ranks);
     }
     
     
     
     
     
}    