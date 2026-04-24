class Node<E> {

    E data;
    private Node<E> left;
    private Node<E> right;

    //Loaded constr
    public Node(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    //getters
    public E getData() {
        return data;
    }

    public Node<E> getLeft() {
        return left;
    }
    public Node<E> getRight(){
        return right;
    }

    //setters
    public void setData(E dataReplacement){
        this.data = dataReplacement;
    }
    public void setLeft(Node<E> leftReplacement){
        this.left = leftReplacement;
    }
    public void setRight(Node<E> rightReplacement){
        this.right = rightReplacement;
    }
}


