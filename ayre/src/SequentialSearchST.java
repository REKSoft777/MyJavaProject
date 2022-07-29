
public class SequentialSearchST<Key, Value> {

    private int n;           
    private Node first;     
    
    private class Node {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next)  {
            this.key   = key;
            this.value = value;
            this.next  = next;
        }
    }

    public int size() {
        return n;
    }

    public boolean contains(Key key) {
        for (Node x = first; x != null; x = x.next)
            if (key.equals(x.key)) return true;
        return false;
    }

    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        n++;
    }

    public Value remove(Key key) {
        // special cases
        if (first == null) return null;

        if (key.equals(first.key)) {
            Value val = first.value;
            first = first.next;
            n--;
            return val;
        }

        // general case
        for (Node x = first; x.next != null; x = x.next)
            if (key.equals(x.next.key)) {
                Value val = x.next.value;
                x.next = x.next.next;
                n--;
                return val;
            }
        return null;
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return x.value;
        }
        return null;     // not found
    }
    
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

    
    public static void main(String[] args) {
        SequentialSearchST<String, String> st = new SequentialSearchST<String, String>();

        // insert some key-value pairs
        st.put("www.cs.princeton.edu",   "128.112.136.11");
        st.put("www.cs.princeton.edu",   "128.112.136.35");
        st.put("www.princeton.edu",      "128.112.130.211");
        st.put("www.math.princeton.edu", "128.112.18.11");
        st.put("www.yale.edu",           "130.132.51.8");
        st.put("www.amazon.com",         "207.171.163.90");
        st.put("www.simpsons.com",       "209.123.16.34");
        st.put("www.stanford.edu",       "171.67.16.120");
        st.put("www.google.com",         "64.233.161.99");
        st.put("www.ibm.com",            "129.42.16.99");
        st.put("www.apple.com",          "17.254.0.91");
        st.put("www.slashdot.com",       "66.35.250.150");
        st.put("www.whitehouse.gov",     "204.153.49.136");
        st.put("www.espn.com",           "199.181.132.250");
        st.put("www.snopes.com",         "66.165.133.65");
        st.put("www.movies.com",         "199.181.132.250");
        st.put("www.cnn.com",            "64.236.16.20");
        st.put("www.iitb.ac.in",         "202.68.145.210");

        // search for IP addresses given URL
        StdOut.println("size = " + st.size());
        StdOut.println(st.get("www.cs.princeton.edu"));
        StdOut.println(st.get("www.amazon.com"));
        StdOut.println(st.get("www.amazon.edu"));
        StdOut.println();

        // test out the iterator
        for (String s : st.keys()) 
            StdOut.println(s); 


        // print out all key-value pairs
       /* for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
        StdOut.println(); */

        StdOut.println("Deleting");
        StdOut.println(st.remove("www.princeton.edu"));
        StdOut.println(st.remove("www.princeton.edu"));
    }

}