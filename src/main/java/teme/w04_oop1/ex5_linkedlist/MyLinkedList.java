package teme.w04_oop1.ex5_linkedlist;

class Cell {
    //TODO
}

public class MyLinkedList {

    //TODO

    boolean isEmpty() {
        return false;
    }

    //add in front of head
    void add(int elem) {

    }

    //removes head value, returning its value
    void remove() {

    }


    int get(int idx) {
        return -1;
    }

    void update(int idx, int value) {

    }

    @Override
    public String toString() {
        return "MyLinkedList{ ??? }";
    }


    /**
     * Some manual tests...
     */
    public static void main(String[] args) {
        MyLinkedList l = new MyLinkedList();
        l.add(10);
        l.add(20);
        l.add(30);
        System.out.println(l);
        l.remove();
        System.out.println("After remove: " + l);
        l.add(31);
        System.out.println("After add: " + l);

        System.out.println("On idx 0: " + l.get(0));

        l.update(0, 42);
        System.out.println("After update: " + l);
    }
}
