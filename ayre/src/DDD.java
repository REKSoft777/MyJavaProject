
public class DDD {
	
	private Node root;
    private int n=1;
    
	
    
    private class Node {
    	
    	private String key;
    	private Integer val;
    	private Node left,right;
    	private int weight;
    	
    	private void increment() {
			val=val+1;
		}
    	
    	
    	public Node(String str,Integer Value,int w) {
    		key=str;
    		val=Value;
    		weight=w;
    		right=null;
    		left=null;	
    	}
    }
    
    
	public void add(String str) {
		if (str==null) throw new IllegalArgumentException("Key is null");
		n++;
		root=add(root,str);
		return;
	}
	
	private Node add(Node x, String str) {
		
		if(x==null) return new Node(str,1,1);
		int cmp=str.compareTo(x.key);
		if(cmp<0) x.left=add(x.left, str);
		else if(cmp==0) x.increment();	
		else x.right=add(x.right, str);
		x.weight=weight(x.left)+x.val+weight(x.right);
		return x;
	}
	
	
	private int weight(Node x) {
		if(x==null) return 0;
		return x.weight;
	}
	
	
	public Node max(Node x) {
		if(x==null) return null;
		if(x.right==null) return x;
		return(x.right);
	}
	
	public String getRandom() {
		if(root==null) throw new IllegalArgumentException("List is null");
		int r=(int)(Math.random()*n);
		return select(root,r);
	}
	
	private String select(Node x,int r) {
		int t1=weight(x.left)+1;
		int t2=weight(x.left)+x.val;
		boolean y=false;
		if(r<t1) y=false;
		else if(r>=t1 && r<=t2) return x.key;
		else if (r>t2) y=true;
		if(y==false) {
			return select(x.left,r);
		}
		else return select(x.right,r-t2);
	}
	

	public static void main(String[] args) {

		DDD st=new DDD();
		st.add("Maya");
		st.add("Ralph");
		st.add("Maya");
		st.add("Karl");
		st.add("Ralph");
		st.add("Ralph");
		st.add("Zgheib");
		st.add("Romeo");
		st.add("Johnny");
		System.out.println(st.select(st.root, 8));
	}

}
