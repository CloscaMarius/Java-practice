package teme.w04_oop1.ex4_arraylist;

class MyArrayList {

    //TODO!

    /**
     * Get the size of the list (number of 'useful' elements)
     */
    int size() {
        return -1;
    }

    /**
     * Return the element at the specified index
     * (or null if index is invalid)
     */
    String get(int index) {
        return null;
    }

    /**
     * Update the elment at a specified index
     * (does nothing if index is invalid)
     */
    void set(int index, String newValue) {

    }

    /**
     * Add a new value at the end of the list
     */
    void add(String newValue) {

    }

    /**
     * Insert a new value at the given position in the list,
     * shifting all elements after it with one position up.
     */
    void add(int index, String newValue) {

    }

    /**
     * Remove the last element of the list
     * (does nothing if list is empty)
     */
    void remove() {

    }

    /**
     * Remove the element at the given index from the list,
     * shifting all elements after it with one position down.
     * (does nothing if index is invalid)
     */
    void remove(int index) {

    }


    //Some other nice methods to implement:

    /**
     * Searches for the given value in the list, and returns the index
     * of its first apparition (or -1 if not found)
     */
    int indexOf(String valueToFind) {
        return -1;
    }

    /**
     * Searches for the given value in the list and returns true if found,
     * false if not found.
     */
    boolean contains(String valueToFind) {
        return false;
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
        System.out.println(list); //[]

        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        System.out.println(list); //[aa, bb, cc, dd]

        list.remove();
        System.out.println(list); //[aa, bb, cc]

        System.out.println("indexOf(aa): " + list.indexOf("aa")); //0
        System.out.println("indexOf(bb): " + list.indexOf("bb")); //2

        list.add(0, "ee"); //[ee, aa, bb, cc]
        System.out.println(list);

        list.add(3, "ff"); //[ee, aa, bb, ff, cc]
        System.out.println(list);

        list.remove(0); //[aa, bb, ff, cc]
        System.out.println(list);

        list.remove(3); //[aa, bb, ff, cc]
        System.out.println(list);
    }
}
