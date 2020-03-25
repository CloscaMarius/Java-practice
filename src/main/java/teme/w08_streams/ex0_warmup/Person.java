package teme.w08_streams.ex0_warmup;

import java.util.Objects;

enum HairColor {
    BLACK, BROWN, BLONDE, RED
}

class Person {

    private final String name;
    private final HairColor hairColor;
    private final int age;

    Person(String name, HairColor hairColor, int age) {
        this.name = name;
        this.hairColor = hairColor;
        this.age = age;
    }

    String getName() {
        return name;
    }

    HairColor getHairColor() {
        return hairColor;
    }

    int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", hairColor=" + hairColor +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                hairColor == person.hairColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hairColor, age);
    }
}
