import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
public class LeetCode {

	public static int reverse(int x) {
	      int z=0;
	      while(x!=0) {
	          int y=x%10;
	          z=y+10*z;
	          x=x/10;
	      }  
	      return z;
	    }
	
	public static int lengthOfLastWord(String s) {
        String[] str=s.split("\\s+");
        return str[str.length-1].length();
    }
	
	public static String addBinary(String a, String b) {
	       StringBuffer sb = new StringBuffer();
	        int i = a.length() - 1;
	        int j = b.length() - 1;
	        int carry = 0;
	        while(i>=0 || j>=0){
	            int sum = carry;
	            if(i>=0){
	                sum += Character.getNumericValue(a.charAt(i--));
	            }
	            if(j>=0){
	                sum += b.charAt(j--)-'0';
	            }
	            sb.insert(0,sum%2);
	            carry = sum/2;
	         }
	        if(carry!=0){
	            sb.insert(0,carry);
	        }
	        return sb.toString();
	}
	
	public static void main(String[] args) {
		
		
		int l=(int) Math.pow(2, 38);
		int a=-2147483648;
		if(a==-2147483648) System.out.println(5);
		String s="zuchjxkz";
		System.out.println(s.substring(0, 0));

	}

}
