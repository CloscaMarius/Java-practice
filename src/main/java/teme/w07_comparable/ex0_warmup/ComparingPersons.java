package teme.w07_comparable.ex0_warmup;

import java.util.*;

class ComparingPersons {

    public static void main(String[] args) {

        List<Person> personList = Arrays.asList(
                new Person(1111, "Ion", 20, 180),
                new Person(3333, "Ana", 22, 170),
                new Person(2222, "Vasile", 22, 170),
                new Person(4444, "Maria", 19, 160));

        Set<Person> persons = new TreeSet<>(personList);
        System.out.println("\nPersons (default sorting):");
        for (Person p : persons) System.out.println(p);

        Set<Person> sortedByCnp = new TreeSet<>(new PersonComparatorByCnp());
        sortedByCnp.addAll(personList);
        System.out.println("\nPersons (sorted by cnp):");
        for (Person p : sortedByCnp) System.out.println(p);

        //TreeSet+Comparator => contains only 3 persons, not 4!! persons for which comparator returns 0 are considered duplicates by a TreeSet!!
        Set<Person> sortedByHeightAndAge = new TreeSet<>(new PersonComparatorByHeightAndAge());
        sortedByHeightAndAge.addAll(personList);
        System.out.println("\nPersons (sorted by height+age, with a TreeSet):");
        for (Person p : sortedByHeightAndAge) System.out.println(p);

        //but if we use a List with .sort(), we will retain all 4 persons, including the ones for which comparator returns 0 (unlike for the TreeSet case)
        List<Person> listSortedByHeightAndAge = new ArrayList<>(personList);
        listSortedByHeightAndAge.sort(new PersonComparatorByHeightAndAge());
        System.out.println("\nPersons (sorted by height+age, in a List):");
        for (Person p : listSortedByHeightAndAge) System.out.println(p);
    }
}

class Person implements Comparable<Person> {

    private int cnp;
    private String name;
    private int age;
    private int height;

    Person(int cnp, String name, int age, int height) {
        this.cnp = cnp > 0 ? cnp : 0;
        this.name = name;
        this.age = age > 0 ? age : 0;
        this.height = height;
    }

    public int getCnp() {
        return cnp;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                getHeight() == person.getHeight() &&
                Objects.equals(getCnp(), person.getCnp()) &&
                Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCnp(), getName(), getAge(), getHeight());
    }

    @Override
    public int compareTo(Person person) {
        return this.getName().compareTo(person.getName());
    }

    @Override
    public String toString() {
        return "Person{" +
                "cnp=" + cnp +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}

class PersonComparatorByCnp implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        //return person.getCnp().compareTo(t1.getCnp());
        return Integer.compare(p1.getCnp(), p2.getCnp());
    }
}

class PersonComparatorByHeightAndAge implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        int result = Integer.compare(p1.getHeight(), p2.getHeight());
        return result != 0 ?
                result :
                -Integer.compare((p1.getAge()), p2.getAge());
    }
}

