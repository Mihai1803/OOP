public class Main {

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinaryTree();

        tree.topNode = tree.insert(tree.topNode, 50);
        tree.insert(tree.topNode,30);
        tree.insert(tree.topNode,20);
        tree.insert(tree.topNode,40);
        tree.insert(tree.topNode,70);
        tree.insert(tree.topNode,60);
        tree.insert(tree.topNode,80);

        int value = 6;
        if (tree.find(tree.topNode, value)) {
            System.out.println(value + " found");
        } else {
            System.out.println(value + " not found");
        }


        value = 60;
        if (tree.find(tree.topNode, value)) {
            System.out.println(value + " found");
        } else {
            System.out.println(value + " not found");
        }

        tree.display(tree.topNode);
    }

}
