package teme.w12_jdbc.Ex1_PetShop.dto;

import java.util.Objects;

public class PersonsDto {
    private long id;
    private String first_name;
    private String last_name;
    private int age;
    private Gender gender;

    public PersonsDto() {

    }

    public PersonsDto(String first_name, String last_name, int age, Gender gender) {
        this(-1, first_name, last_name, age, gender);
    }

    public PersonsDto(long id, String first_name, String last_name, int age, Gender gender) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonsDto that = (PersonsDto) o;
        return id == that.id &&
                age == that.age &&
                Objects.equals(first_name, that.first_name) &&
                Objects.equals(last_name, that.last_name) &&
                gender == that.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, age, gender);
    }

    @Override
    public String toString() {
        return "\nPersons{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
