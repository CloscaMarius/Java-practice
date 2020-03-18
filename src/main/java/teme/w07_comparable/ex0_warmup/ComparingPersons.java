package teme.w07_comparable.ex0_warmup;

class ComparingPersons {

    public static void main(String[] args) {

        //TODO: uncomment when ready
        /*
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
        */
    }
}

class Person {
    //TODO: add class content here
}

class PersonComparatorByCnp {
    //TODO
}

class PersonComparatorByHeightAndAge {
    //TODO
}
