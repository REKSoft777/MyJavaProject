
public class AllPaths {

    private Stack<String> path  = new Stack<String>();   
    private BSSET<String> onPath  = new BSSET<String>();     

    public AllPaths(Graph G, String s, String t) {
        enumerate(G, s, t);
    }

    private void enumerate(Graph G, String v, String t) {
        path.push(v);
        onPath.add(v);
        if (v.equals(t)) 
            StdOut.println(path);
        else {
            for (String w : G.adjacentTo(v)) {
                if (!onPath.contains(w)) enumerate(G, w, t);
            }
        }
        path.pop();
        onPath.remove(v);
    }

    public static void main(String[] args) {
        Graph G = new Graph();
        G.addEdge("A", "B");
        G.addEdge("A", "C");
        G.addEdge("C", "D");
        G.addEdge("D", "E");
        G.addEdge("C", "F");
        G.addEdge("B", "F");
        G.addEdge("F", "D");
        G.addEdge("D", "G");
        G.addEdge("E", "G");
        new AllPaths(G, "A", "G");
        StdOut.println();
        new AllPaths(G, "B", "U");
    }

}
