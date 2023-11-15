public class MyList<T> implements MyListInterface<T> {

    Node<T> head, tail;


    MyList() {
        this.head = this.tail = null;
    }

    @Override
    public void add(T value) {
        Node<T> temp = new Node<>(value);

        if (tail == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail.prev = tail;
            tail = temp;
        }
    }

    @Override
    public T getElementAt(int index) {
        MyIterator<T> iterator = new MyIterator<>(this.head);

        if (index == 1) {
            return this.head.value;
        }

        int position = 1;
        while (iterator.hasNext()) {
            if (position == index) {
                return iterator.curretNode.value;
            }
            position++;
            iterator.next();
        }

        return null;
    }

    @Override
    public int size() {
        MyIterator<T> iterator = new MyIterator<>(this.head);

        int size = 1;
        while (iterator.hasNext()) {
           size++;
           iterator.next();
        }
        return size;
    }

    public void display() {
        MyIterator<T> iterator = new MyIterator<>(this.head);

        while (iterator.hasNext()) {
            System.out.println(iterator.next().value);
        }
        System.out.println(iterator.curretNode.value + "\n");
    }
}
