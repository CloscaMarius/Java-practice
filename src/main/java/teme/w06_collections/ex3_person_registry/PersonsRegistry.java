package teme.w06_collections.ex3_person_registry;

import java.util.Set;

interface PersonsRegistry {

    //Adds a new person to the registry. If a person with same CNP already exists,
    //it will NOT register this new person (just ignore it, and show an error)
    void register(Person p);

    //Finds a person by cnp and removes it from registry
    //If person not found, will still work (does nothing, but raises no error either)
    void unregister(int cnp);

    //Get the number of currently registered persons
    int count();

    //Get the list of cnp values of all persons
    Set<Integer> cnps();

    //Get the list of unique names of all persons
    Set<String> uniqueNames();

    //Find a person by cnp. Returns null if no person found.
    Person findByCnp(int cnp);

    //Find the persons with a specified name (may be zero, one or more)
    //(comparing person name with specified name should be case insensitive)
    Set<Person> findByName(String name);

    //Get the average age for all persons (or 0 as default if it cannot be computed)
    double averageAge();

    //Get the percent (a value between 0-100) of adults (persons with age >=18)
    //from the number of all persons (or 0 as default if it cannot be computed)
    double adultsPercentage();

    //Get the percent (a value between 0-100) of adults who voted
    //from the number of all adult persons (age>=18)
    double adultsWhoVotedPercentage();
}
