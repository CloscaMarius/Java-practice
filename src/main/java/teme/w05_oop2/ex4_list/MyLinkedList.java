package teme.w05_oop2.ex4_list;


public class MyLinkedList implements MyList {

    private Cell head = null;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public String get(int index) {
        Cell cell = getCellAt(index);
        return cell != null ? cell.value : null;
    }

    @Override
    public void set(int index, String newValue) {
        Cell cell = getCellAt(index);
        if (cell != null) {
            cell.value = newValue;
        }
    }

    private Cell getCellAt(int idx) {
        if (idx < 0 || idx > size - 1) {
            return null;
        }
        Cell cell = head;
        for (int i = 0; i < idx; i++) {
            cell = cell.next;
        }
        return cell;
    }

    @Override
    public void insert(int index, String newValue) {
        if (index == 0) {
            head = new Cell(newValue, head);
            size++;
        } else {
            Cell cellBefore = getCellAt(index - 1);
            if (cellBefore != null) {
                Cell cellAfter = cellBefore.next;
                Cell cellToInsert = new Cell(newValue, cellAfter);
                cellBefore.next = cellToInsert;
                size++;
            }
        }
    }

    @Override
    public String remove(int index) {
        if (size > 0) {
            if (index == 0) { //removing first one is again special (no previous cell, and only need to update head field)
                String removedValue = head.value;
                head = head.next; //move head to next cell
                size--;
                return removedValue;
            }
            Cell cellBefore = getCellAt(index - 1);
            if (cellBefore != null) {
                Cell cellToRemove = cellBefore.next;
                if (cellToRemove != null) {
                    String removedValue = cellToRemove.value;
                    cellBefore.next = cellToRemove.next;
                    size--;
                    return removedValue;
                }
            }
        }
        return null;
    }

    @Override
    public int indexOf(String valueToFind) {
        Cell cell = head;
        int idx = 0;
        while (cell != null) {
            if (cell.value.equals(valueToFind)) {
                return idx;
            }
            cell = cell.next;
            idx++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(String valueToFind) {
        return indexOf(valueToFind) >= 0;
    }

    @Override
    public void add(String newValue) {
        insert(size, newValue);
    }

    @Override
    public void addFirst(String newValue) {
        insert(0, newValue);
    }

    @Override
    public String remove() {
        return remove(size - 1);
    }

    @Override
    public String removeFirst() {
        return remove(0);
    }

    @Override
    public String toString() {
        String res = "MyLinkedList{";
        for (Cell c = head; c != null; c = c.next) {
            res += " " + c.value + (c.next != null ? "," : "");
        }
        res += "}";
        return res;
    }
}

class Cell {
    String value;
    Cell next;

    Cell(String value, Cell next) {
        this.value = value;
        this.next = next;
    }
}