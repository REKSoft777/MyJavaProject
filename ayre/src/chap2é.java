public class chap2é {
     
   public static int floor(int[] a,int key) {
	   
	   if(a.length==0) return key;
	   if(a[a.length-1]<=key) return a[a.length-1];
	   if(key<=a[0]) return key;
	   return floor(a,key,0,a.length);
   }
   
   private static int floor(int[] a,int key, int start, int end) {
	   
	   if (end-start<=0) return a[start];
	   int mid=start+(end-start)/2;
	   if ((a[mid]<key & key<a[mid+1]) || (a[mid]==key)) return a[mid];
	   else if (key<a[mid]) return floor(a,key,start,mid);
	   else return floor(a,key,mid+1,end);
   }
   
   public static int ceiling(int[] a,int key) {
	   
	   if(a.length==0) return key;
	   if(a[a.length-1]<=key) return key;
	   if(key<=a[0]) return a[0];
	   return ceiling(a,key,0,a.length);
   }
   
   private static int ceiling(int[] a,int key, int start, int end) {
	   
	   if (end-start<=0) return a[start];
	   int mid=start+(end-start)/2;
	   if ((a[mid-1]<key & key<a[mid]) || (a[mid]==key)) return a[mid];
	   else if (key<a[mid]) return ceiling(a,key,start,mid);
	   else return ceiling(a,key,mid+1,end);
   }
   
   
  

    public static void main(String[] args) {
    	int[] a= {1,3,5,6,8,10,12,15};
    	int[] b= {3};
    	System.out.println(ceiling(a,14));
    	System.out.println(floor(a,14));
    }

}
