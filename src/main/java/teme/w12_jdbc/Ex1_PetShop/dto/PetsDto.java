package teme.w12_jdbc.Ex1_PetShop.dto;

import java.sql.Date;
import java.util.Objects;

public class PetsDto {
    private long id;
    private long type_id;
    private String name;
    private Date birth_date;
    private Gender gender;
    private long person_id;

    public PetsDto() {

    }

    public PetsDto(long type_id, String name, Date birth_date, Gender gender, long person_id) {
        this(-1, type_id, name, birth_date, gender, person_id);
    }

    public PetsDto(long id, long type_id, String name, Date birth_date, Gender gender, long person_id) {
        this.id = id;
        this.type_id = type_id;
        this.name = name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.person_id = person_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getType_id() {
        return type_id;
    }

    public void setType_id(long type_id) {
        this.type_id = type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(long person_id) {
        this.person_id = person_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetsDto petsDto = (PetsDto) o;
        return id == petsDto.id &&
                type_id == petsDto.type_id &&
                person_id == petsDto.person_id &&
                Objects.equals(name, petsDto.name) &&
                Objects.equals(birth_date, petsDto.birth_date) &&
                gender == petsDto.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type_id, name, birth_date, gender, person_id);
    }

    @Override
    public String toString() {
        return "\nPets{" +
                "id=" + id +
                ", type_id=" + type_id +
                ", name='" + name + '\'' +
                ", birth_date=" + birth_date +
                ", gender=" + gender +
                ", person_id=" + person_id +
                '}';
    }
}
