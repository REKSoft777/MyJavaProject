
public class Insertion {

	public static void sort(Comparable[] a) {
		if(a.length<=1) return;
		for (int i=1; i<a.length; i++) {
			for (int j=i; j>0; j--) {
				if(a[j].compareTo(a[j-1])<0) exchange(a,j-1,j);
				else break;
			}
		}
	}
	
	public static void sort(Comparable[] a, int x, int y) {
		
		if(y<x) throw new IllegalArgumentException("SubArray Invalid");
		for (int i=x+1; i<y; i++) {
			for (int j=i; j>x; j--) {
				if(a[j].compareTo(a[j-1])<0) exchange(a,j-1,j);
				else break;
			}
		}
	}
	
	private static void exchange(Comparable[] a, int i, int j) {
		
		Comparable temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	public static void main(String[] args) {
		

	}

}
