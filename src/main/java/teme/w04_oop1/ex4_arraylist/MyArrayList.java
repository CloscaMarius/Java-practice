package teme.w04_oop1.ex4_arraylist;

import java.util.Arrays;

/**
 * Custom class, which stores a sequence of elements, of type String,
 * using an array of String values.
 */
class MyArrayList {

    String[] arrayList = new String[0];

    /**
     * Returns true if list is empty, false otherwise
     */
    boolean isEmpty() {

        return arrayList == null || arrayList.length == 0;
    }

    /**
     * Get the size of the list (number of elements it contains)
     */
    int size() {
        return arrayList.length;
    }

    /**
     * Return the element at the specified index
     * (or null if index is invalid)
     */
    String get(int index) {
        if (index < arrayList.length && index >= 0) {
            return arrayList[index];
        }

        return null;
    }

    /**
     * Update the element at a specified index
     * (does nothing if index is invalid)
     */
    void set(int index, String newValue) {
        if (index < arrayList.length && index >= 0) {
            arrayList[index] = newValue;
        }
    }


    /**
     * Add a new value at the END of the list
     */
    void addLast(String newValue) {
        String[] newArray = Arrays.copyOf(arrayList, arrayList.length + 1);
        newArray[newArray.length - 1] = newValue;
        arrayList = newArray;


    }

    /**
     * Insert a new value at the given position in the list,
     * shifting all elements after it with one position up.
     * (does nothing if index is invalid)
     */
    void insert(int index, String newValue) {
        if (index < arrayList.length && index >= 0) {

            String[] secondArrayList = new String[arrayList.length + 1];

            for (int i = 0; i < arrayList.length + 1; i++) {
                if (i < index) {
                    secondArrayList[i] = arrayList[i];
                } else if (i == index) {
                    secondArrayList[i] = newValue;
                } else {
                    secondArrayList[i] = arrayList[i - 1];
                }
            }
            this.arrayList = secondArrayList;
        }
    }

    /**
     * Remove the last element of the list, also returning its value
     * (does nothing if list is empty, returns null)
     */
    String removeLast() {
        if (arrayList == null || arrayList.length == 0) {
            return null;
        }
        String[] newArray = Arrays.copyOf(arrayList, arrayList.length - 1);
        String lastElement = arrayList[arrayList.length - 1];
        this.arrayList = newArray;

        return lastElement;
    }

    /**
     * Remove the element at the given index from the list,
     * shifting all elements after it with one position down.
     * (does nothing if index is invalid)
     */
    String remove(int index) {
        if (arrayList == null
                || index < 0
                || index >= arrayList.length) {

            return null;
        }
        String[] anotherArray = new String[arrayList.length - 1];
        String removedElement = null;
        for (int i = 0, k = 0; i < arrayList.length; i++) {
            if (i == index) {
                removedElement = arrayList[i];
                continue;
            }
            anotherArray[k++] = arrayList[i];
        }
        arrayList = anotherArray;
        return removedElement;
    }


    /**
     * Searches for the given value in the list, and returns the index
     * of its first apparition (or -1 if not found)
     */
    int indexOf(String valueToFind) {
        if (arrayList == null || arrayList.length == 0) {
            return -1;
        }
        //int index=0;
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i].equals(valueToFind)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Searches for the given value in the list and returns true if found,
     * false if not found.
     */
    boolean contains(String valueToFind) {
        if (arrayList == null || arrayList.length == 0) {
            return false;
        }
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i].equalsIgnoreCase(valueToFind)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a String description of the list, which includes all
     * elements (in the order in which they appear in list)
     */
    @Override
    public String toString() {
        return Arrays.toString(arrayList);
    }


    /**
     * Some manual tests...
     */
    public static void main(String[] args) {

        MyArrayList list = new MyArrayList();
        System.out.println("\nBefore any action: " + list); //[]
        System.out.println("size: " + list.size() + ", isEmpty: " + list.isEmpty());

        list.addLast("aa");
        list.addLast("bb");
        list.addLast("cc");
        list.addLast("dd");
        System.out.println("\nAfter adding 4 elements: " + list); //[aa, bb, cc, dd]
        System.out.println("size: " + list.size() + ", isEmpty: " + list.isEmpty());

        System.out.println("\nindexOf(aa): " + list.indexOf("aa")); //0
        System.out.println("indexOf(cc): " + list.indexOf("cc")); //2
        System.out.println("indexOf(xx): " + list.indexOf("xx")); //-1
        System.out.println("contains(cc): " + list.contains("cc")); //true
        System.out.println("contains(xx): " + list.contains("xx")); //false

        System.out.println("\nget(2): " + list.get(2)); //cc
        System.out.println("get(5): " + list.get(5)); //null

        list.insert(0, "ee"); //[ee, aa, bb, cc, dd]
        System.out.println("\nAfter inserting 'ee' at index 0: " + list);
        list.insert(3, "ff"); //[ee, aa, bb, ff, cc, dd]
        System.out.println("After inserting 'ff' at index 3: " + list);


        list.set(5, "DD!");
        System.out.println("\nAfter update(5, 'DD!'): " + list);
        list.set(10, "ZZ");
        System.out.println("After update(10, 'ZZ'): " + list);


        String removed = list.removeLast();
        System.out.println("\nAfter removing last elem (" + removed + "): " + list); //[ee, aa, bb, ff, cc]

        removed = list.remove(0); //[aa, bb, ff, cc]
        System.out.println("\nAfter removing elem at index 0 (" + removed + "): " + list);

        removed = list.remove(3); //[aa, bb, ff]
        System.out.println("After removing elem at index 3 (" + removed + "): " + list);
    }
}
