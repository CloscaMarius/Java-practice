package teme.w08_streams.ex4_person_registry;

import java.util.Set;

class PersonsRegistryWithStreams implements PersonsRegistry {

    /**
     * Ok not to use streams for this one
     */
    @Override
    public void register(Person p) {
        //TODO
    }

    /**
     * Ok not to use streams for this one
     */
    @Override
    public void unregister(int cnp) {
        //TODO
    }

    /**
     * Ok not to use streams for this one
     */
    @Override
    public int count() {
        //TODO
        return -1;
    }

    /**
     * Ok not to use streams for this one
     */
    @Override
    public Person findByCnp(int cnp) {
        //TODO
        return null;
    }

    /**
     * Ok not to use streams for this one
     */
    @Override
    public Set<Integer> cnps() {
        //TODO
        return null;
    }

    //--- These should be done using streams operations! ---//

    @Override
    public Set<String> uniqueNames() {
        //TODO
        return null;
    }

    @Override
    public Set<Person> findByName(String name) {
        //TODO
        return null;
    }

    @Override
    public double averageAge() {
        //TODO
        return -1;
    }

    @Override
    public double adultsPercentage() {
        //TODO
        return -1;
    }

    @Override
    public double adultsWhoVotedPercentage() {
        //TODO
        return -1;
    }


    /**
     * Some manual tests
     */
    public static void main(String[] args) {
        PersonsRegistryWithStreams reg = new PersonsRegistryWithStreams();
        reg.register(new Person(1234, "Ion", 14, false));
        reg.register(new Person(2233, "Ana", 12, false));
        reg.register(new Person(2678, "Ana", 3, false));
        reg.register(new Person(1235, "Costel", 21, false));
        reg.register(new Person(2367, "Maria", 33, true));

        System.out.println("Registered persons count: " + reg.count());
        System.out.println("Average age: " + reg.averageAge());
        System.out.println("Adults percentage: " + reg.adultsPercentage());
        System.out.println("Voters percentage (vs all adults): " + reg.adultsWhoVotedPercentage());

        System.out.println("Unique names: " + reg.uniqueNames());
        System.out.println("Persons named 'ana': " + reg.findByName("ana"));
        System.out.println("Person with cnp 2678: " + reg.findByCnp(2678));
        System.out.println("Person with cnp 1000: " + reg.findByCnp(1000));

        reg.unregister(2678);
        System.out.println("Registered persons count: " + reg.count());
        System.out.println("Person with cnp 2678: " + reg.findByCnp(2678));
    }
}
