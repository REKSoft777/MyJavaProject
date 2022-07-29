
public class GenomeSketch {

	
		
	private final Vector profile;         

	public GenomeSketch(String text, int k) {
	        int n = text.length();
	        double[] freq = new double[(int)Math.pow(4, k)];
	        for (int i = 0; i < n-k+1; i++) {
	            String kgram = text.substring(i, i+k);
	            int hash = hash(kgram);
	            freq[hash] += 1;
	        }
	        Vector vector = new Vector(freq);
	        profile = vector.direction();
	    }
    public static int hash(String str) {
    	
    	int x=0;
    	int k=str.length();
    	for (int i = 0; i<k; i++) {
    		if (str.charAt(i)=='A');
    		else if (str.charAt(i)=='C') {
    			x+=Math.pow(4, k-i-1)*1;
    		}
    		else if (str.charAt(i)=='G') {
    			x+=Math.pow(4, k-i-1)*2;
    		}
    		else if (str.charAt(i)=='T') {
    			x+=Math.pow(4, k-i-1)*3;
    		}
    		else throw new IllegalArgumentException("Illegal Nucleotide");
    	}
    	return x;
    	
    }
    
    
    public static String unhash(int n) {
    	
    	int k=0;
    	int n1=n;
    	while(n1!=0) {
    		n1=n1/4;
    		k++;
    	}
    	String s="";
    	for (int i = 0; i<k; i++) {
    		int m=n/(int)Math.pow(4, k-i-1);
    		n= n % (int)Math.pow(4, k-i-1);
    		if (m==0) s=s+'A';
    		else if (m==1) s=s+'C';
    		else if (m==2) s=s+'G';
    		else s=s+'T';
    	}
    	return s;
    }    
	    

	    public double similarTo(GenomeSketch other) {
	        return profile.dot(other.profile);
	    }

	    public String toString() {
	        return "" + profile;
	    }


	
       public static void main(String[] args) {
    	   
    	   String s1="";
    	   String s2="";
    	   for (int i = 0; i<100; i++) {
    		   int n=StdRandom.uniform(4);
    		   if (n==0) s1=s1+'A';
       		   else if (n==1) s1=s1+'C';
       		   else if (n==2) s1=s1+'G';
       		   else s1=s1+'T';
    	   }
    	   for (int i = 0; i<100; i++) {
    		   int m=StdRandom.uniform(4);
    		   if (m==0) s2=s2+'A';
       		   else if (m==1) s2=s2+'C';
       		   else if (m==2) s2=s2+'G';
       		   else s2=s2+'T';
    	   }
    	   GenomeSketch S1= new GenomeSketch(s1,3);
    	   GenomeSketch S2= new GenomeSketch(s2,3);
    	   System.out.println(s1);
    	   System.out.println(s2);
    	   System.out.println(S1.similarTo(S2));
       }
}
