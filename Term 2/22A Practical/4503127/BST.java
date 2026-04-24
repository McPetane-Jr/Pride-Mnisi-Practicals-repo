
class BST {

    //Encapsulated Attributes 
    private Node root;
    private int size;
    
    //Default constructor
    public BST() {
        this.root = null;
        this.size = 0;
    }

    public BST(Node root, int size){
        this.root = root;
        this.size = size;
    }

    public Node getRoot(){
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }
    
    public boolean search(int data){
        return searchInt(root, data);
    }

    //
    private boolean searchInt(Node node, int data) {
        if (node==null) return false;
        if (data==node.getData()) return true;
        if (data>node.getData()) return searchInt(node.getRight(), data);
        else return searchInt(node.getLeft(), data);
    }

    public void insert(int data){
        root = insertInt(root, data);
    }
    
    private Node insertInt(Node node, int data) {
        if (node==null) {
            size++;
            return new Node(data);
        }
        if (data > node.getData()) node.setRight(insertInt(node.getRight(), data));
        else node.setLeft(insertInt(node.getLeft(), data));
        return node;
    }

    public int height(){
        return heightInt(root);
    }

    private int heightInt(Node node) {
        if (node==null) return -1;
        int leftHeight = heightInt(node.getLeft());
        int rightHeight = heightInt(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void printInOrder(){
        printInOrderInt(root);
    }

    private void printInOrderInt(Node node) {
        if (node==null) return;
        printInOrderInt(node.getLeft());
        System.out.print(node.getData() + " ");
        printInOrderInt(node.getRight());
    }

//     if k is greater than the BST size, print out “Input not valid” 
// • perform an in-order traversal of the BST in-order 
// • keep track of the number of nodes visited 
// • when the kth node is reached, print out that node’s value
    public int find_kth_smallest(int k){
        if (k > size) {
            System.out.println("Input not valid");
            return -1;
        }
        return find_kth_smallestInt(root, k);
    }

    private int find_kth_smallestInt(Node node, int k) {
        if (node == null) return -1; // Base case: empty subtree

        // Traverse the left subtree
        int leftSize = size(node.getLeft());
        if (k <= leftSize) {
            return find_kth_smallestInt(node.getLeft(), k);
        } else if (k == leftSize + 1) {
            return node.getData(); // Found the kth smallest
        } else {
            return find_kth_smallestInt(node.getRight(), k - leftSize - 1);
        }
    }

//      Implement the void delete(int data) method: 
// • delete a node from the tree, maintaining the BST property 
// • if data does not exist, print “Input not valid”  
// • use the in-order predecessor for deletion of an internal node with two children 
// • update the size attribute after deletion 
    public void delete(int data) {
        if (!search(data)) {
            System.out.println("Input not valid");
            return;
        }
        root = deleteInt(root, data);
        size--;
    }

    private Node deleteInt(Node node, int data) {
        if (node == null) return null;

        if (data < node.getData()) {
            node.setLeft(deleteInt(node.getLeft(), data));
        } else if (data > node.getData()) {
            node.setRight(deleteInt(node.getRight(), data));
        } else {
            // Node with only one child or no child
            if (node.getLeft() == null) return node.getRight();
            else if (node.getRight() == null) return node.getLeft();

            // Node with two children: Get the in-order predecessor (max in the left subtree)
            Node predecessor = getMax(node.getLeft());
            node.setData(predecessor.getData()); // Replace data with predecessor's data
            node.setLeft(deleteInt(node.getLeft(), predecessor.getData())); // Delete the predecessor
        }
        return node;
    }

    private Node getMax(Node node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    private int size(Node node) {
        if (node == null) return 0;
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

}
