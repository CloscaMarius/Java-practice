package teme.w05_oop2.ex5_specialized;

import teme.w05_oop2.ex4_list.MyList;

class DoubleLinkedList implements MyList {

    //TODO!


    //some manual tests
    public static void main(String[] args) {
        MyList list = new DoubleLinkedList();
        System.out.println("list: " + list);

        //uncomment when ready
        /*
        System.out.println("size?: " + list.size());
        System.out.println("get(0): " + list.get(0));
        System.out.println("get(1): " + list.get(1));
        System.out.println("get(-1): " + list.get(-1));
        list.set(0, "aa");
        System.out.println("after set(0,'aa'), list: " + list);
        list.remove(0);
        System.out.println("after remove(0), list: " + list);
        System.out.println("indexOf('a'): " + list.indexOf("a"));

        list.insert(0, "cc"); //insert first
        System.out.println("after insert(0,'cc'): " + list);
        list.insert(0, "aa"); //insert in front => [aa,cc]
        System.out.println("after insert(0,'aa'): " + list);
        list.insert(1, "bb"); //insert at index 1 => [aa,bb,cc]
        System.out.println("after insert(1,'bb'): " + list);
        list.insert(3, "dd"); //insert at end (append) => [aa,bb,cc,dd]
        System.out.println("after insert(3,'dd'): " + list);
        */
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public void set(int index, String newValue) {

    }

    @Override
    public void insert(int index, String newValue) {

    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public int indexOf(String valueToFind) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(String valueToFind) {
        return false;
    }

    @Override
    public void add(String newValue) {

    }

    @Override
    public void addFirst(String newValue) {

    }

    @Override
    public String remove() {
        return null;
    }

    @Override
    public String removeFirst() {
        return null;
    }
}
