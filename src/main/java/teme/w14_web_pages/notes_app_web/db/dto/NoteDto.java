package teme.w14_web_pages.notes_app_web.db.dto;

import java.sql.Date;
import java.util.Objects;

public class NoteDto {

    private final long id;
    private final String description;
    private final long categoryId;
    private final Date dueDate;
    private final Priority priority;
    private final State state;

    public NoteDto(long id, String description, long categoryId, Date dueDate, Priority priority, State state) {
        this.id = id;
        this.categoryId = categoryId;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.state = state;
    }

    //version without id, needed for the case of new notes to insert in db (when id is not yet set/known)
    public NoteDto(String description, long categoryId, Date dueDate, Priority priority, State state) {
        this(-1, description, categoryId, dueDate, priority, state);
    }

    public long getId() {
        return id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return "NoteDto{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                ", state=" + state +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NoteDto noteDto = (NoteDto) o;
        return id == noteDto.id &&
                categoryId == noteDto.categoryId &&
                Objects.equals(description, noteDto.description) &&
                Objects.equals(dueDate, noteDto.dueDate) &&
                priority == noteDto.priority &&
                state == noteDto.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryId, description, dueDate, priority, state);
    }
}

