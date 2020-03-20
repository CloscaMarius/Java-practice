package teme.w06_collections.ex3_person_registry;

import java.util.Objects;

class Person {

    private int cnp;
    private String name;
    private int age;
    private boolean hasVoted;

    Person(int cnp, String name, int age, boolean hasVoted) {
        this.cnp = cnp;
        this.name = name;
        this.age = age;
        this.hasVoted = hasVoted;
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

    public boolean isHasVoted() {
        return hasVoted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return cnp == person.cnp &&
                age == person.age &&
                hasVoted == person.hasVoted &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp, name, age, hasVoted);
    }

    @Override
    public String toString() {
        return "Person{" +
                "cnp=" + cnp +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hasVoted=" + hasVoted +
                '}';
    }
}
