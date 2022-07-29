import java.util.Scanner;
public class Parentheses {

   public static String[] doubleArray(String[] a) {
		
		String[] temp=new String[a.length*2];
		for(int i=0; i<a.length; i++) {
			temp[i]=a[i];
		}
		return temp;
	}
	
	
	public static void main(String[] args) {
	    
    	Scanner myInput=new Scanner(System.in);
    	int size=0;
    	String[] s=new String[1];
    	//System.out.println("100".startsWith("100"));
    	while(!myInput.hasNext("stop")) {
    		if (size==s.length) s=doubleArray(s);
    		s[size++]=myInput.next();
    	}
    	String[] string=new String[size];
    	for (int i=0; i<size; i++) {
    		string[i]=s[i];
    	}
    	boolean isPrefixFree=true;
    	for (int i=0; i<string.length; i++) {
    		for (int j=0; j<string.length; j++) {
    			if(j!=i & string[i].startsWith(string[j])) {
    				isPrefixFree=false;
    				break;
    			}
    		}
    		if(isPrefixFree==false) break;
    	}
	
	if(isPrefixFree==true) System.out.println("IsPrefixFree");
	else System.out.println("IsntPrefixFree");
	}
}