public class MySortedList<T extends  Comparable<T>> extends MyList<T> {

    Node<T> head, tail;
    MySortedList() {
        this.head = this.tail = null;
    }

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (head == null) {
            head = tail = newNode;
        } else if (value.compareTo(head.value) <= 0) {
            addAtStart(newNode.value);
        } else if (value.compareTo(tail.value) >= 0) {
            addAtEnd(newNode.value);
        } else {
            Node<T> current = head;
            MyIterator<T> iterator = new MyIterator<>(current);

            while (iterator.hasNext()) {
                if (iterator.next().value.compareTo(newNode.value) < 0) {
                    break;
                }
            }
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
    }


    public void addAtEnd(T value) {
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

    public void addAtStart(T value) {
        Node<T> temp = new Node<>(value);

        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    @Override
    public void display() {
        MyIterator<T> iterator = new MyIterator<>(this.head);

        while (iterator.hasNext()) {
            System.out.println(iterator.next().value);
        }
        System.out.println(iterator.curretNode.value + "\n");
    }



}
