//package PRACTICALS.Pride-Mnisi-Practicals-repo.17Practicals;
public class tryBST {

    Node root; 

    //Methods
    //insert
    public void insert(Node newNode) {

        root = insertHelper(root, newNode); //This calls the helper method to recursively insert the node into the tree, starting from the root
        System.out.println("Node inserted: " + newNode.data); //Print a message indicating that the node has been inserted
    }

    //Helper method to insert a node into the tree recursively
    private Node insertHelper(Node root, Node newNode) {
        int existingData = newNode.data; //Get the value of the node to be inserted
        
        if (root == null) { //If the root is null, we have found the correct position for the new node
            root = newNode; //Assign the new node to the root
            return root; //Return the root node
        }
        //otherwise, if there's already a value in the root,
        //we need to compare it with the value of the new node to determine whether to go left or right
        else if (existingData < root.data) {
            root.left = insertHelper(root.left, newNode);
            //This makes the left child be the root of the left subtree,
            //and we recursively call the insertHelper method to insert the new node into the left subtree
            
        
            //System.out.println("New left child: " + newNode.data); //Print a message indicating that the new node has been inserted as a left child
        }
        else {
            root.right = insertHelper(root.right, newNode);
            //This makes the right child be the root of the right subtree,
            //and we recursively call the insertHelper method to insert the new node into the right subtree
        
            //System.out.println("New right child: " + newNode.data); //Print a message indicating that the new node has been inserted as a right child
        }

        return root;
    
    }

    //Delete a node from the tree
    public void delete(int value) {
        root = deleteHelper(root, value); //This calls the helper method to recursively delete the node from the tree, starting from the root
        System.out.println("Node deleted: " + value); //Print a message indicating that the node has been deleted
    }
    private Node deleteHelper(Node root2, int value) {

        if (root2 == null) return root2; 

        if (value < root2.data) {
            root2.left = deleteHelper(root2.left, value); 
        }
        else if (value > root2.data) {
            root2.right = deleteHelper(root2.right, value); 
        }
        else {
            //Node with only one child or no child
            if (root2.left == null) return root2.right; 
            else if (root2.right == null) return root2.left; 

            //Node with two children: Get the inorder successor (smallest in the right subtree)
            root2.data = minValue(root2.right); 

            //Delete the inorder successor
            root2.right = deleteHelper(root2.right, root2.data); 
        }
    }

    private int minValue(Node right) {
        int minv = right.data; 
        while (right.left != null) {
            minv = right.left.data; 
            right = right.left; 
        }
        return minv;
    }

    //balanced bst
    public void balancedBST(int start, int end) {
        if (start > end) return;

        int mid = (start + end) / 2; 
        insert(new Node(mid)); 

        //Recursively building the left and right subtrees
        balancedBST(start, mid - 1); 
        balancedBST(mid + 1, end); 
    }

    //Display the tree
    public void display() {

        displayHelper(root); //This calls the helper method to recursively display the tree, starting from the root

    }
    //Helper method to display the tree recursively
    private void displayHelper(Node root) {

        if (root != null) { //If the root is not null, we can display its value and its children
            displayHelper(root.left);
            System.out.println(root.data);
            displayHelper(root.right);
        }
    }


    //Check if this tree is a bsst
    public boolean isBST(Node root) {
        return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE); //This calls the helper method to recursively check if the tree is a binary search tree, starting from the root and using the minimum and maximum integer values as the initial bounds
    }

    private boolean isBSTHelper(Node root2, int minValue, int maxValue) {
    
        if (root2 == null) { //If the root is null, we have reached a leaf node and the tree is a binary search tree
            return true;
        }

        if (root2.data < minValue || root2.data > maxValue) { //If the value of the current node is less than the minimum value or greater than the maximum value, then the tree is not a binary search tree
            return false;
        }

        //Recursively check the left and right subtrees with updated bounds
        return isBSTHelper(root2.left, minValue, root2.data - 1) && isBSTHelper(root2.right, root2.data + 1, maxValue);
    
    }
}

class Node {
    int data; //Value of the node
    Node left; //Reference to the left child
    Node right; //Reference to the right child

    //Constructor to initialize the node with a value and set the left and right children to null
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Main {
    public static void main(String[] args) {

        
        int size = 5; //Size of the tree
        int totalNodes = (int) Math.pow(2, size) - 1; //Number of nodes to be inserted into the tree

        int reps= 20;
        double[] durations = new double[reps];

        for (int i = 0; i < reps; i++) {

            tryBST bst = new tryBST(); //Create a new instance of the tryBST class
            long startTime = System.nanoTime(); //Record the start time of the operation
            long endTime = System.nanoTime(); //Record the end time of the operation
            long duration = endTime - startTime; //Calculate the duration of the operation
            durations[i] = duration;
            

        //Display the tree
        //bst.display();
        System.out.println("Is the tree a BST? " + bst.isBST(bst.root));
        

    }
}