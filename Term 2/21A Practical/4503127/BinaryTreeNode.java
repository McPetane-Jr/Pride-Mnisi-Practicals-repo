class BinaryTreeNode <E> {

    //Encapsulation
    private E value;
    private BinaryTreeNode<E> left;
    private BinaryTreeNode<E> right;

    //Generic default constructor
    public BinaryTreeNode() {
        this.value = null;
        this.left = null;
        this.right = null;
    }

    //Loaded constructor
    public BinaryTreeNode(E value, BinaryTreeNode<E> left, BinaryTreeNode<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    //Generic getter methods
    public E getValue() {
        return value;
    }
    //Getting the left node's value
    public BinaryTreeNode<E> getLeft() {
        return left;
    }

    //Getting the right node's value
    public BinaryTreeNode<E> getRight() {
        return right;
    }

    //Generic setter methods
    //Node
    public void setValue(E value) {
        this.value = value;
    }

    //Left
    public void setLeft(BinaryTreeNode<E> left) {
        this.left = left;
    }

    //Right
    public void setRight(BinaryTreeNode<E> right) {
        this.right = right;
    }

}
