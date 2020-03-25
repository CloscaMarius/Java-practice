package teme.w08_streams.ex4_person_registry;

import java.util.Objects;

class Person {
    private final int cnp;
    private final String name;
    private final int age;
    private final boolean hasVoted;

    Person(int cnp, String name, int age, boolean hasVoted) {
        this.cnp = cnp;
        this.name = name;
        this.age = age;
        this.hasVoted = hasVoted;
    }

    int getCnp() {
        return cnp;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    boolean isHasVoted() {
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
                Objects.equals(name, person.name);
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
