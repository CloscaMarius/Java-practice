package teme.w04_oop1.ex1_person;

public class Person {
    private String name;
    private int birthYear;
    private String hairColor;

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public Person(String name, int birthYear, String hairColor) {
        this.name = name;
        this.birthYear = birthYear;
        this.hairColor = hairColor;
    }

    public Person(String name, int birthYear) {
        this(name, birthYear, "brown");
    }

    boolean isOlderThan(Person other) {
        return this.birthYear < other.birthYear;
    }

    public String toString() {
        return name + ":" + birthYear + ":" + hairColor;
    }

    int getAgeInYear(int year) {
        if (year <= birthYear) {
            return 0;
        }
        return year - birthYear;
    }
}
