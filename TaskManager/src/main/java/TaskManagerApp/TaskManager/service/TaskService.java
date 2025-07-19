package TaskManagerApp.TaskManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TaskManagerApp.TaskManager.dto.TaskRequestDTO;
import TaskManagerApp.TaskManager.dto.TaskResponseDTO;
import TaskManagerApp.TaskManager.entity.Task;
import TaskManagerApp.TaskManager.exception.TaskNotFoundException;
import TaskManagerApp.TaskManager.repository.TaskRepository;

@Service
public class TaskService {

@Autowired
private TaskRepository taskRepository;

public TaskResponseDTO createTask(TaskRequestDTO dto){
    Task task = new Task();
    task.setTitle(dto.getTitle());
    task.setDescription(dto.getDescription());
    task.setStatus(dto.getStatus());
    task.setPriority(dto.getPriority());
    task.setDueDate(dto.getDueDate());
    Task saved = taskRepository.save(task);
    return mapToResponseDto(saved);   
}

public TaskResponseDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID " + id + " not found."));
        return mapToResponseDto(task);
    }

    private TaskResponseDTO mapToResponseDto(Task task) {
        return new TaskResponseDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getDueDate()
        );
    }

}
