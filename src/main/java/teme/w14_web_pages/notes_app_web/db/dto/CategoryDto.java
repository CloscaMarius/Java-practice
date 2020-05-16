package teme.w14_web_pages.notes_app_web.db.dto;

import java.util.Objects;

public class CategoryDto {
    private final long id;
    private final String description;

    public CategoryDto(long id, String description) {
        this.id = id;
        this.description = description;
    }

    public CategoryDto(String description) {
        this(-1, description);
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDto that = (CategoryDto) o;
        return id == that.id &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }
}
