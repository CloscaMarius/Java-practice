package teme.w05_oop2.ex4_list;

import java.util.Arrays;

public class MyArrayList implements MyList {

    private String[] arr = new String[0];

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public String get(int index) {
        if (index >= 0 && index < arr.length) {
            return arr[index];
        }
        return null;
    }

    @Override
    public void set(int index, String newValue) {
        if (index >= 0 && index < arr.length) {
            arr[index] = newValue;
        }
    }

    @Override
    public void insert(int index, String newValue) {
        if (index >= 0 && index <= arr.length) {
            arr = Arrays.copyOf(arr, arr.length + 1);
            for (int i = arr.length - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = newValue;
        }
    }

    @Override
    public String remove(int index) {
        if (index >= 0 && index < arr.length) {
            String result = arr[index];

            for (int i = index; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr = Arrays.copyOf(arr, arr.length - 1);
            return result;
        }
        return null;
    }

    @Override
    public int indexOf(String valueToFind) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(valueToFind)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0 || arr == null;
    }

    @Override
    public boolean contains(String valueToFind) {
        return indexOf(valueToFind) >= 0;
    }

    @Override
    public void add(String newValue) {
        insert(arr.length, newValue);
    }

    @Override
    public void addFirst(String newValue) {
        insert(0, newValue);
    }

    @Override
    public String remove() {
        return remove(arr.length - 1);

    }

    @Override
    public String removeFirst() {
        return remove(0);
    }

    @Override
    public String toString() {
        return "MyArrayList2{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
