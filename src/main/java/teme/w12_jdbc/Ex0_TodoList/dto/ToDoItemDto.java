package teme.w12_jdbc.Ex0_TodoList.dto;

import java.sql.Date;
import java.util.Objects;

public class ToDoItemDto {
    private long id;
    private String description;
    private Priority priority;
    private Date dueDate;
    private State state;

    public ToDoItemDto() {
    }

    public ToDoItemDto(String description, Priority priority, Date dueDate, State state) {
        this(-1, description, priority, dueDate, state);
    }

    public ToDoItemDto(long id, String description, Priority priority, Date dueDate, State state) {
        this.id = id;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public State getState() {
        return state;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ToDoItemDto that = (ToDoItemDto) o;
        return id == that.id &&
                Objects.equals(description, that.description) &&
                priority == that.priority &&
                Objects.equals(dueDate, that.dueDate) &&
                state == that.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, priority, dueDate, state);
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setState(State state) {
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", dueDate=" + dueDate +
                ", state=" + state +
                '}';
    }
}
