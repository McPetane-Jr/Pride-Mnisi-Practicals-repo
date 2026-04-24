
class BST {

    private E data;
    private Node<E> root;
    int size;
    
    //
    public BST() {
        this.root = root;
        this.size = 0;

    }

    public BST(Node<E> root, int size){
        this.root = root;
        this.size = size;
    }

    public Node<E> getRoot(){
        return root;
    }

    public void setRoot(Node<E> root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }
    
    public boolean search(int data){
        return searchInt(root, data)
    }
    //
    private boolean searchInt(Node<E> node, int data) {
        if (node==null) return false;
        if (data==node.getData()) return true;
        if (data>node.getData()) return searchInt(node.getRight(), data);
        else return searchInt(node.getLeft(), data);
    }
}
