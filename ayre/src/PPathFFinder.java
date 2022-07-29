
public class PPathFFinder<Item extends Comparable<Item>> {

    private BST<Item, Item>  prev = new BST<Item, Item>();
    private BST<Item, Integer> dist = new BST<Item, Integer>();

	public PPathFFinder(GGraph<Item> G, Item s) {

        Queue<Item> queue = new Queue<Item>();
        queue.enqueue(s);
        dist.put(s, 0);
        while (!queue.isEmpty()) {
            Item v = queue.dequeue();
            for (Item w : G.adjacentTo(v)) {
                if (!dist.contains(w)) {
                    queue.enqueue(w);
                    dist.put(w, 1 + dist.get(v));
                    prev.put(w, v);
                }
            }
        }
    }

    public int distanceTo(Item v) {
        if (dist.contains(v)) return Integer.MAX_VALUE;
        return dist.get(v);
    }
    
    public Iterable<Item> pathTo(Item v) {
        Stack<Item> path = new Stack<Item>();
        while (v != null && dist.contains(v)) {
            path.push(v);
            v = prev.get(v);
        }
        return path;
    }


    public static void main(String[] args) {
       
    }


}
