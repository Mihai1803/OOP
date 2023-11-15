import java.util.Iterator;

public class MyIterator<T> implements MyIteratorInterface<T> {

    Node<T> curretNode;

    public MyIterator(Node<T> curretNode) {
        this.curretNode = curretNode;
    }

    @Override
    public boolean hasNext() {
        return curretNode.next != null;
    }

    @Override
    public Node<T> next() {
        Node<T> savedCurrent = curretNode;
        curretNode = curretNode.next;
        return savedCurrent;
    }
}

