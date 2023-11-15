public class TestClass1 {
    public static void main(String[] args) {

        MyList<Integer> list = new MyList<>();

        // 10 20 30 40 50 60 70 80 90 100
        for (int i = 1; i <= 10; i++) {
            list.add(i * 10);
        }

        list.display(); // 10 20 30 40 50 60 70 80 90 100
        System.out.println(list.size()); // 10
        System.out.println(list.getElementAt(1)); // 10
        System.out.println(list.getElementAt(4)); // 40
        System.out.println(list.getElementAt(100)); // null



    }


}
