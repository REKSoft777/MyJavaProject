
public class Merge {

	public static void sort(Comparable[] a) {
		
		if(a.length<=1) return;
		Comparable[] aux= new Comparable[a.length];
		sort(a,aux,0,a.length);
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int start, int end) {
		
		if (end-start<=1) return;
		int mid=start+(end-start)/2;
	    sort(a,aux,start,mid);
	    sort(a,aux,mid,end);
	    int i=start, j=mid;
	    for (int k=start; k<end; k++) {
	    	if(i==mid) aux[k]=a[j++];
	    	else if(j==end) aux[k]=a[i++];
	    	else if(a[j].compareTo(a[i])<0) aux[k]=a[j++];
	    	else aux[k]=a[i++];
	    }
	    for (int k=start; k<end; k++) {
	    	a[k]=aux[k];
	    }
	}
	
   public static void sort(Comparable[] a, int x, int y) {
		
	   if(y<x) throw new IllegalArgumentException("SubArray Invalid");
	   if(y-x<=1) return;
	   Comparable[] aux= new Comparable[y-x];
	   sortSub(a,aux,x,y);
	}
   
   private static void sortSub(Comparable[] a, Comparable[] aux, int start, int end) {
		
		if (end-start<=1) return;
		int mid=start+(end-start)/2;
	    sortSub(a,aux,start,mid);
	    sortSub(a,aux,mid,end);
	    int i=start, j=mid;
	    for (int k=start; k<end; k++) {
	    	if(i==mid) aux[k-start]=a[j++];
	    	else if(j==end) aux[k-start]=a[i++];
	    	else if(a[j].compareTo(a[i])<0) aux[k-start]=a[j++];
	    	else aux[k-start]=a[i++];
	    }
	    for (int k=start; k<end; k++) {
	    	a[k]=aux[k-start];
	    }
	}
   
   public static void iterativeSort(Comparable[] a) {
		
		if(a.length<=1) return;
		Comparable[] aux= new Comparable[a.length];
		for (int pow=2; pow<=a.length; pow*=2) {
			for (int sub=0; sub<a.length; sub+=pow) {
				int i=sub,j=sub+pow/2;
				for (int k=sub; k<sub+pow; k++) {
					if(i==sub+pow/2) aux[k]=a[j++];
					else if(j==sub+pow) aux[k]=a[i++];
					else if(a[j].compareTo(a[i])<0) aux[k]=a[j++];
					else aux[k]=a[i++];
				}
				for (int k=sub; k<sub+pow; k++) {
					a[k]=aux[k];
				}
			}
		}
	}
	
	public static void main(String[] args) {

	}

}
