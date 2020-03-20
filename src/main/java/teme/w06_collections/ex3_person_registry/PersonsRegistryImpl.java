package teme.w06_collections.ex3_person_registry;

import java.util.HashSet;
import java.util.Set;

class PersonsRegistryImpl implements PersonsRegistry {

    private Person person;
    Set<Person> persons = new HashSet<>();

    @Override
    public void register(Person p) {
        persons.add(p);
    }

    @Override
    public void unregister(int cnp) {
        persons.removeIf(p -> p.getCnp() == cnp);
    }

    @Override
    public int count() {
        return persons.size();
    }

    @Override
    public Set<Integer> cnps() {
        Set<Integer> newSetCnps = new HashSet<>();
        for (Person p : persons) {
            newSetCnps.add(p.getCnp());
        }
        return newSetCnps;
    }

    @Override
    public Set<String> uniqueNames() {
        Set<String> newSetUniqueNames = new HashSet<>();
        for (Person p : persons) {
            newSetUniqueNames.add(p.getName());
        }
        return newSetUniqueNames;
    }

    @Override
    public Person findByCnp(int cnp) {
        for (Person p : persons) {
            if (p.getCnp() == cnp) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Set<Person> findByName(String name) {
        Set<Person> personsName = new HashSet<>();
        for (Person p : persons) {
            if (p.getName().equalsIgnoreCase(name)) {
                personsName.add(p);
            }
        }
        return personsName;
    }

    @Override
    public double averageAge() {
        if (persons.size() > 0) {
            double nrOfPersons = persons.size();
            double sum = 0;
            for (Person p : persons) {
                sum += p.getAge();
            }
            return sum / nrOfPersons;
        }
        return 0;
    }

    @Override
    public double adultsPercentage() {
        if (persons.size() > 0) {
            double nrOfPersons = persons.size();
            double nrOfAdults = 0;
            for (Person p : persons) {
                if (p.getAge() >= 18) {
                    nrOfAdults++;
                }
            }
            return nrOfAdults / nrOfPersons * 100;
        }
        return 0;
    }

    @Override
    public double adultsWhoVotedPercentage() {
        if (persons.size() > 0) {
            Set<Person> newPersons = new HashSet<>();
            double nrOfAdults = 0;
            double nrOfAdultsVoted = 0;
            for (Person p : persons) {
                if (p.getAge() >= 18) {
                    nrOfAdults++;
                    newPersons.add(p);
                }
            }
            for (Person p : newPersons) {
                if (p.isHasVoted()) {
                    nrOfAdultsVoted++;
                }
            }
            return nrOfAdultsVoted / nrOfAdults * 100;
        }
        return 0;
    }
}
