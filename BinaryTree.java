
public class BinaryTree<T extends  Comparable<T>> {
    Node<T> topNode;

    BinaryTree() {
        this.topNode = null;
    }

    public static class Node<T extends Comparable<T>> {
        private T value;
        private Node<T> rightNode, leftNode;

        public Node(T value) {
            this.value = value;
            this.leftNode = this.rightNode = null;
        }
    }


    public Node<T> insert(Node<T> node, T value) {

        if (node == null) {
            node = new Node<T>(value);
            return node;
        }

        if (value.compareTo(node.value) < 0) {
            node.leftNode = insert(node.leftNode, value);
        } else if (value.compareTo(node.value) > 0) {
            node.rightNode = insert(node.rightNode, value);
        }

        return node;
    }

    public boolean find(Node<T> topNode, T value) {

       if (topNode == null) {
           return false;
       }

       if (topNode.value.compareTo(value) == 0) {
           return true;
       } else if (topNode.value.compareTo(value) < 0) {
           return find(topNode.leftNode, value);
       } else {
           return find(topNode.rightNode, value);
       }
    }

    public void display(Node<T> node) {

        if (node != null) {
            display(node.leftNode);
            System.out.println(node.value + " ");
            display(node.rightNode);
        }
    }

}
