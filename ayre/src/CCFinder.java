
public class CCFinder {

	public static boolean isNeighbor(String a, String b) {
        int differ = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) differ++;
        }
        return (differ == 1);
    }

    public static void main(String[] args) {
        String from = args[0];
        String to   = args[1];
        if (from.length() != to.length()) 
            throw new RuntimeException("Words have different lengths");
        String[] words = new String[10000];
        int n = 0;
        while (!StdIn.isEmpty()) {
            words[n] = StdIn.readString();
            if (words[n].length() != from.length())
                throw new RuntimeException("Words have different lengths");
            n++;
        }
        System.err.println("Finished reading word list");
        Graph G = new Graph();
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++)
                if (isNeighbor(words[i], words[j]))
                    G.addEdge(words[i], words[j]);
        System.err.println("Finished building graph");
        PathFinder finder = new PathFinder(G, from);
        if (finder.hasPathTo(to)) StdOut.println(finder.pathTo(to));
        else                      StdOut.println("NOT CONNECTED");
    }
}
