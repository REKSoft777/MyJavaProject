
public class AVL {
	
	private Node root;
	
    public int height(Node N) {
        if (N == null)
            return 0;
 
        return N.height;
    }
    
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }
	
	private class Node {
	    int key, height;
	    Node left, right;
	 
	    public Node(int d) {
	        this.key = d;
	        height = 1;
	    }
	}
	
	Node rightRotate(Node y) {
		
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        return x;
    }
	
	int getBalance(Node N) {
        if (N == null)
            return 0;
 
        return height(N.left) - height(N.right);
    }
	
	Node leftRotate(Node x) {
		
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
        return y;
    }
	
	void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
	
	public void insert(int key) {
		root=insert(root,key);
	}
	
	private Node insert(Node node, int key) {
		
        if (node == null)
            return (new Node(key));
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else 
            return node; 
        node.height = 1 + max(height(node.left),
                              height(node.right));
 
        /* 3. Get the balance factor of this ancestor 
         * node to check whether this node became
              unbalanced */
        int balance = getBalance(node);
 
        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);
 
        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);
 
        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
         
     // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
        /* return the (unchanged) node pointer */
        return node;
    }
	

	public static void main(String[] args) {
		AVL tree = new AVL();
		tree.insert(tree.root, 10);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 50);
        tree.insert(tree.root, 25);
        System.out.println("Preorder traversal" +
                " of constructed tree is : ");
        tree.preOrder(tree.root);
	}

}
