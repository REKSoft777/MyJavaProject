import java.util.TreeMap;
import java.util.Scanner;

public class Chap3  {


	
	
public static void main(String[] args) {
		
		String[] list= {"https://fr.finance.yahoo.com/","https://www.nike.com/fr/","https://wallstreetenglish.fr/"};
		TreeMap<String,Queue<String>> st=new TreeMap<String,Queue<String>>();
		for (int i=0; i<list.length; i++) {
			In in=new In(list[i]);
			while(!in.isEmpty()) {
				String s=in.readString();
				if(!st.containsKey(s)) {
				   st.put(s,new Queue<String>());
				}
				Queue<String> queue=st.get(s);
				if(!queue.find(list[i])) {
				   queue.enqueue(list[i]);
				}
			}
		}
		System.out.println(st.get("concatenation"));
		//System.out.println(4);
		//In in=new In("https://www.nike.com/fr/");
		//System.out.println(in.readAll());
		//System.out.println(4);
}
}
	
	

	

