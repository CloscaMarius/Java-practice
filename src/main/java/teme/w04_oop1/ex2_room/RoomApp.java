package teme.w04_oop1.ex2_room;

import teme.w04_oop1.ex1_person.Person;

import java.util.Arrays;

class RoomApp {
    //just for manual testing of the Room class
    public static void main(String[] args) {
        Room room = new Room(10);
        room.printAll();
        Room r = new Room(1);
        r.printAll();

        r.enter(new Person("p1", 2019, "blue"));
        r.printAll();

        r = new Room(3);
        r.printAll();
        r.enter(new Person("p1", 2019, "blue"));
        r.printAll();
        r.enter(new Person("p2", 2019, "blue"));
        r.printAll();
        r.enter(new Person("p3", 2019, "blue"));
        r.printAll();
    }
}


//TODO: define your Room class here (or in a separate file in same package)
//(using in it the existing Person class, done for previous exercise and placed in separate package)

class Room {

    private int capacity;

    Person[] persons = new Person[capacity];

    Room(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    int getCount() {
        return persons.length;
    }

    void printAll() {

        System.out.println("Room capacity: " + capacity + "; persons in the room: " + getCount());
        if (persons.length == 0) {
            System.out.println("None");
        }
        for (Person p : persons) {
            System.out.println(p.toString());
        }
    }

    int personsCount = getCount();


    void enter(Person person) {
        Person[] grup = Arrays.copyOf(persons, persons.length + 1);

        if (persons.length < capacity) {
            int nrOfPersons = 0;
            for (Person p : persons) {
                if (p.getName().equalsIgnoreCase(person.getName())) {
                    nrOfPersons++;
                }
            }
            if (nrOfPersons == 0) {
                grup[grup.length - 1] = person;
                this.persons = grup;
            }
        }
    }

    boolean isPresent(String personName) {
        for (Person p : persons) {
            if (personName.equals(p.getName())) {
                return true;
            }
        }
        return false;
    }

    String getOldest() {
        int n = persons.length;
        if (persons.length == 0 || persons == null) {
            return "";
        }
        for (int j = 1; j < n; j++) {
            Person p = persons[j];
            int i = j - 1;
            while ((i > -1) && (persons[i].getBirthYear() > p.getBirthYear())) {
                persons[i + 1] = persons[i];
                i--;
            }
            persons[i + 1] = p;
        }
        String oldest = String.format("(%s)", persons[0].getBirthYear());
        return persons[0].getName() + oldest;
    }

    String[] getNames(String hairColor) {

        int sameColorCount = 0;
        for (Person p : persons) {
            if (p.getHairColor().equalsIgnoreCase(hairColor)) {
                sameColorCount++;
            }
        }
        String[] sameHairColor = new String[sameColorCount];
        int i = 0;
        for (Person p : persons) {
            if (p.getHairColor().equalsIgnoreCase(hairColor)) {
                sameHairColor[i] = p.getName();
                i++;
            }

        }
        return sameHairColor;
    }

    void exit(String personName) {
        if (persons == null || persons.length == 0 || indexOf(personName) == -1) {
            this.persons = persons;
        } else {
            Person[] result = new Person[persons.length - 1];
            int k = 0;
            for (int i = 0; i < persons.length; i++) {
                if (indexOf(personName) == i) {
                    continue;
                }
                result[k] = persons[i];
                k++;
            }
            this.persons = result;
            System.out.println(Arrays.asList(persons));
        }
    }

    int indexOf(String name) {
        if (isPresent(name)) {
            return 0;
        }
        return -1;
    }


}

