package teme.w08_streams.ex4_person_registry;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class PersonsRegistryWithStreams implements PersonsRegistry {

    /**
     * Ok not to use streams for this one
     */

    Set<Person> persons = new HashSet<>();

    @Override
    public void register(Person p) {
        persons.add(p);
    }

    /**
     * Ok not to use streams for this one
     */
    @Override
    public void unregister(int cnp) {
        persons.removeIf(p -> p.getCnp() == cnp);
    }

    /**
     * Ok not to use streams for this one
     */
    @Override
    public int count() {
        //return persons.size();
        return (int) persons.stream().count();
    }

    /**
     * Ok not to use streams for this one
     */
    @Override
    public Person findByCnp(int cnp) {
        for (Person p : persons) {
            if (p.getCnp() == cnp) {
                return p;
            }
        }
        return null;
    }

    /**
     * Ok not to use streams for this one
     */
    @Override
    public Set<Integer> cnps() {
        /*Set<Integer> newSetCnps = new HashSet<>();
                for (Person p : persons) {
                    newSetCnps.add(p.getCnp());
                }
                return newSetCnps;*/

        return persons.stream()
                .map(p -> p.getCnp())
                .collect(Collectors.toSet());
    }

    //--- These should be done using streams operations! ---//

    @Override
    public Set<String> uniqueNames() {
        //Set<String> newSetUniqueNames = new HashSet<>();
        //        for (Person p : persons) {
        //            newSetUniqueNames.add(p.getName());
        //        }
        //        return newSetUniqueNames;

        return persons.stream()
                .map(p -> p.getName())
                .collect(Collectors.toSet());

    }

    @Override
    public Set<Person> findByName(String name) {
        //Set<Person> personsName = new HashSet<>();
        //        for (Person p : persons) {
        //            if (p.getName().equalsIgnoreCase(name)) {
        //                personsName.add(p);
        //            }
        //        }
        //        return personsName;

        return persons.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .collect(Collectors.toSet());
    }

    @Override
    public double averageAge() {
        //if (persons.size() > 0) {
        //            double nrOfPersons = persons.size();
        //            double sum = 0;
        //            for (Person p : persons) {
        //                sum += p.getAge();
        //            }
        //            return sum / nrOfPersons;
        //        }
        //        return 0;

        if (persons.size() > 0) {
            double nrOfPersons = persons.stream().count();
            double sum = persons.stream()
                    .map(p -> p.getAge())
                    .reduce(0, (a, b) -> a + b);
            return sum / nrOfPersons;
        }
        return 0;
    }

    @Override
    public double adultsPercentage() {
        // if (persons.size() > 0) {
        //            double nrOfPersons = persons.size();
        //            double nrOfAdults = 0;
        //            for (Person p : persons) {
        //                if (p.getAge() >= 18) {
        //                    nrOfAdults++;
        //                }
        //            }
        //            return nrOfAdults / nrOfPersons * 100;
        //        }
        //        return 0;

        if (persons.size() > 0) {
            double nrOfPersons = persons.stream().count();
            double nrOfAdults = persons.stream()
                    .filter(p -> p.getAge() >= 18).count();

            return nrOfAdults / nrOfPersons * 100;
        }
        return 0;
    }

    @Override
    public double adultsWhoVotedPercentage() {
        //if (persons.size() > 0) {
        //            Set<Person> newPersons = new HashSet<>();
        //            double nrOfAdults = 0;
        //            double nrOfAdultsVoted = 0;
        //            for (Person p : persons) {
        //                if (p.getAge() >= 18) {
        //                    nrOfAdults++;
        //                    newPersons.add(p);
        //                }
        //            }
        //            for (Person p : newPersons) {
        //                if (p.isHasVoted()) {
        //                    nrOfAdultsVoted++;
        //                }
        //            }
        //            return nrOfAdultsVoted / nrOfAdults * 100;
        //        }
        //        return 0;

        if (persons.size() > 0) {
            double nrOfAdults = persons.stream()
                    .filter(p -> p.getAge() >= 18).count();
            double nrOfAdultsVoted = persons.stream()
                    .filter(p -> p.isHasVoted()).count();

            return nrOfAdultsVoted / nrOfAdults * 100;
        }
        return 0;
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
