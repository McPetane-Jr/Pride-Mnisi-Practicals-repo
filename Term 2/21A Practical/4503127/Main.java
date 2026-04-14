public class Main {

public static void main(String[] args){

    // Create nodes (bottom-up)
    BinaryTreeNode<Character> e = new BinaryTreeNode<>('e', null, null);
    BinaryTreeNode<Character> d = new BinaryTreeNode<>('d', null, null);
    BinaryTreeNode<Character> c = new BinaryTreeNode<>('c', null, null);
    BinaryTreeNode<Character> b = new BinaryTreeNode<>('b', d, e);
    BinaryTreeNode<Character> a = new BinaryTreeNode<>('a', b, c);

    BinaryTree<Character> bt1 = new BinaryTree<>(a);

    // Create nodes (bottom-up)
    
    BinaryTreeNode<Double> node_4 = new BinaryTreeNode<>(-9.3, null, null);
    BinaryTreeNode<Double> node_3 = new BinaryTreeNode<>(2.9, null, null);
    BinaryTreeNode<Double> node_2 = new BinaryTreeNode<>(-1.5, node_4, null);
    BinaryTreeNode<Double> node_1 = new BinaryTreeNode<>(3.4, node_2, node_3);

    BinaryTree<Double> bt2 = new BinaryTree<>(node_1);

    System.out.println("Tree 1 (Level Order):");
        bt1.printInLevelOrder();

        System.out.println("Tree 2 (Level Order):");
        bt2.printInLevelOrder();
    }

}
