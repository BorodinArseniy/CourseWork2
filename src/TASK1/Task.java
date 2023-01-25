package TASK1;

import java.time.LocalDateTime;
import java.util.Objects;

public class Task {
    private String title;
    private String description;
    private Type taskType;
    private LocalDateTime date;
    private static Integer counter = 1;
    private final Integer id;

    public Task(String title, String description, Type taskType, LocalDateTime firstTime) {
        this.title = ValidateUtils.checkString(title);
        this.description = ValidateUtils.checkString(description);
        this.taskType = taskType;
        this.date = firstTime;
        this.id = counter;
        counter++;

    }

    public Task(String title, Type taskType, LocalDateTime firstTime) {
        this.title = ValidateUtils.checkString(title);
        this.taskType = taskType;
        this.date = firstTime;
        this.id = counter;
        counter++;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = ValidateUtils.checkString(title);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = ValidateUtils.checkString(description);
    }

    public Type getTaskType() {
        return taskType;
    }

    public void setTaskType(Type taskType) {
        this.taskType = taskType;
    }


    public LocalDateTime getFirstTime() {
        return date;
    }

    public void setFirstTime(LocalDateTime firstTime) {
        this.date = firstTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) && Objects.equals(description, task.description) && taskType == task.taskType && Objects.equals(date, task.date) && Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, taskType, date, id);
    }

    @Override
    public String toString() {
        return "TASK1.Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", taskType=" + taskType +
                ", firstTime=" + date +
                ", id=" + id +
                '}';
    }


}
