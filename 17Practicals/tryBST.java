//package PRACTICALS.Pride-Mnisi-Practicals-repo.17Practicals;
public class tryBST {

    Node root; //Reference to the root node of the tree

    //Methods
    //Method to insert a node into the tree
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
            
        
            System.out.println("New left child: " + newNode.data); //Print a message indicating that the new node has been inserted as a left child
        }
        else {
            root.right = insertHelper(root.right, newNode);
            //This makes the right child be the root of the right subtree,
            //and we recursively call the insertHelper method to insert the new node into the right subtree
        
            System.out.println("New right child: " + newNode.data); //Print a message indicating that the new node has been inserted as a right child
        }

        return root;
    
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
        tryBST bst = new tryBST(); //Create a new instance of the tryBST class

        //Insert some nodes into the tree
        bst.insert(new Node(10));
        bst.insert(new Node(5));
        bst.insert(new Node(15));
        bst.insert(new Node(3));
        bst.insert(new Node(7));
        bst.insert(new Node(12));
        bst.insert(new Node(18));
    }
}