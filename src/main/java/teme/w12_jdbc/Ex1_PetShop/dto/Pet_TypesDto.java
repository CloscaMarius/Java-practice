package teme.w12_jdbc.Ex1_PetShop.dto;

import java.util.Objects;

public class Pet_TypesDto {

    private long id;
    private String description;

    public Pet_TypesDto() {
    }

    public Pet_TypesDto(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet_TypesDto that = (Pet_TypesDto) o;
        return id == that.id &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    @Override
    public String toString() {
        return "\nPet_Types{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
