package teme.w04_oop1.ex4_arraylist;

/**
 * Custom class, which stores a sequence of elements, of type String,
 * using an array of String values.
 */
public class MyArrayList {

    //TODO!

    /**
     * Get the size of the list (number of elements it contains)
     */
    public int size() {
        return -1;
    }

    /**
     * Return the element at the specified index
     * (or null if index is invalid)
     */
    public String get(int index) {
        return null;
    }

    /**
     * Update the element at a specified index
     * (does nothing if index is invalid)
     */
    public void set(int index, String newValue) {

    }

    /**
     * Insert a new value at the given position in the list,
     * shifting all elements after it with one position up.
     * If index equals size, it means append to list.
     * (does nothing if index is invalid)
     */
    public void insert(int index, String newValue) {

    }

    /**
     * Remove the element at the given index from the list,
     * shifting all elements after it with one position down.
     * (does nothing if index is invalid)
     */
    public String remove(int index) {
        return null;
    }

    /**
     * Searches for the given value in the list, and returns the index
     * of its first apparition (or -1 if not found)
     */
    public int indexOf(String valueToFind) {
        return -1;
    }

    /**
     * Returns a String description of the list, which includes all
     * elements (in the order in which they appear in list)
     */
    @Override
    public String toString() {
        return "MyArrayList{ ??? }";
    }


    /**
     * Some manual tests...
     */
    public static void main(String[] args) {

        MyArrayList list = new MyArrayList();
        System.out.println("\nBefore any action: " + list); //[]
        System.out.println("size: " + list.size());

        list.insert(0, "aa");
        list.insert(1, "bb");
        list.insert(2, "cc");
        list.insert(3, "dd");
        System.out.println("\nAfter adding 4 elements: " + list); //[aa, bb, cc, dd]
        System.out.println("size: " + list.size()); //4

        System.out.println("\nindexOf(aa): " + list.indexOf("aa")); //0
        System.out.println("indexOf(cc): " + list.indexOf("cc")); //2
        System.out.println("indexOf(xx): " + list.indexOf("xx")); //-1

        System.out.println("\nget(2): " + list.get(2)); //cc
        System.out.println("get(5): " + list.get(5)); //null

        list.insert(0, "ee");
        System.out.println("\nAfter inserting 'ee' at index 0: " + list);  //[ee, aa, bb, cc, dd]
        list.insert(3, "ff");
        System.out.println("After inserting 'ff' at index 3: " + list); //[ee, aa, bb, ff, cc, dd]


        list.set(5, "DD!");
        System.out.println("\nAfter update(5, 'DD!'): " + list); //[ee, aa, bb, ff, cc, DD!]
        list.set(10, "ZZ");
        System.out.println("After update(10, 'ZZ'): " + list); //[ee, aa, bb, ff, cc, DD!]


        String removed = list.remove(list.size() - 1);
        System.out.println("\nAfter removing last elem (" + removed + "): " + list); //[ee, aa, bb, ff, cc]

        removed = list.remove(0);
        System.out.println("\nAfter removing elem at index 0 (" + removed + "): " + list); //[aa, bb, ff, cc]

        removed = list.remove(3);
        System.out.println("After removing elem at index 3 (" + removed + "): " + list); //[aa, bb, ff]
    }
}
