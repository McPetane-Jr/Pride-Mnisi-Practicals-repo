class BinaryTree<E> {
    
    int size;
    //Encapsulation
    private BinaryTreeNode<E> root;

    public BinaryTree() {
        this.size = 0;
        this.root = null;
    }

    //loaded constructor
    public BinaryTree(BinaryTreeNode<E> root) {
        this.size = 1;
        this.root = root;
    }

    //getter methods
    //root geter
    public BinaryTreeNode<E> getRoot() {
        return root;
    }

    //setter methods
    //root setter
    public void setRoot(BinaryTreeNode<E> root) {
        this.root = root;
    }


    // Source: Assisted by ChatGPT (OpenAI), April 2026
    // Pasted ruric, question paper and the code and prompted "Check if the following code correctly implements a level order traversal for a binary tree. If not, please correct it."
    public void printInLevelOrder() {
        if (root == null) return;

        java.util.Queue<BinaryTreeNode<E>> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<E> current = queue.poll();
            System.out.print(current.getValue() + " ");

            if (current.getLeft() != null)
                queue.add(current.getLeft());

            if (current.getRight() != null)
                queue.add(current.getRight());
        }
        System.out.println();
    }

}








