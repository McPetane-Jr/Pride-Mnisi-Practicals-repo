class Node {

    int data;
    private Node left;
    private Node right;

    //Loaded constr
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    //getters
    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }
    public Node getRight(){
        return right;
    }

    //setters
    public void setData(int dataReplacement){
        this.data = dataReplacement;
    }
    public void setLeft(Node leftReplacement){
        this.left = leftReplacement;
    }
    public void setRight(Node rightReplacement){
        this.right = rightReplacement;
    }
}


