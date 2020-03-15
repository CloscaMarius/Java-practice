package teme.w05_oop2.ex4_list;

/**
 * Interface to be implemented by both MyArrayList and MyLinkedList (from week 4),
 * specifying the generic behavior of a list (basically their common behavior)
 */
public interface MyList {

    int size();

    String get(int index);

    void set(int index, String newValue);

    void insert(int index, String newValue);

    String remove(int index);

    int indexOf(String valueToFind);

    boolean isEmpty();

    boolean contains(String valueToFind);

    void add(String newValue);

    void addFirst(String newValue);

    String remove();

    String removeFirst();

}
