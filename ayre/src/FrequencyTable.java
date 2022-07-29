import java.util.TreeMap;

public class FrequencyTable {
	
	private TreeMap<String, Integer> st=new TreeMap<String, Integer>();
	
	public int count(String s) {
		if(!st.containsKey(s)) return 0;
		return st.get(s);
	}
	
	public void click(String s) {
		if(s==null) return;
		int c=count(s);
		if(c==0) st.put(s, 1);
		else st.put(s, c+1);
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
        for (String key : st.navigableKeySet()) {
            sb.append(count(key) + " " + key + "\n");
        }
        return sb.toString();
	}

	public static void main(String[] args) {

		FrequencyTable freq = new FrequencyTable();
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            freq.click(key);
        }

        // print frequency table to standard output
        StdOut.println(freq);
	}

}
