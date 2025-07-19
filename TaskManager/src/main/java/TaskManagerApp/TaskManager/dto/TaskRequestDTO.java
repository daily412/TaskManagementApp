package TaskManagerApp.TaskManager.dto;

import TaskManagerApp.TaskManager.enums.TaskStatus;

import java.time.LocalDate;

import TaskManagerApp.TaskManager.enums.Priority;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskRequestDTO {

@NotBlank(message = "Title is required")
@Size(min = 3,max = 100,message = "Title must be between 3 and 100 characters")
private String title;

@NotBlank(message = "Decription is required")
@Size(max = 500,message = "Description cannot exceed 500 characters")
private String description;

@NotNull(message ="Status is Required")
private TaskStatus status;

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public TaskStatus getStatus() {
    return status;
}

public void setStatus(TaskStatus status) {
    this.status = status;
}

public Priority getPriority() {
    return priority;
}

public void setPriority(Priority priority) {
    this.priority = priority;
}

public LocalDate getDueDate() {
    return dueDate;
}

public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
}

@NotNull(message ="Priority is Required")
private Priority priority;

@NotNull(message = "Due date is required")
@FutureOrPresent(message = "Due date cannot be in the past")
private LocalDate dueDate;


}
