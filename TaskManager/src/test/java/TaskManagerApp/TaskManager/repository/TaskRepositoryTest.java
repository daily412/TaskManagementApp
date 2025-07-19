package TaskManagerApp.TaskManager.repository;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import TaskManagerApp.TaskManager.entity.Task;
import TaskManagerApp.TaskManager.enums.Priority;
import TaskManagerApp.TaskManager.enums.TaskStatus;
import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class TaskRepositoryTest {

  @Autowired
    private TaskRepository taskRepository;

    @Test
    void shouldSaveAndRetrieveTask() {
        Task task = new Task();
        task.setTitle("Demo Task");
        task.setDescription("Testing JPA Repository");
        task.setStatus(TaskStatus.IN_PROGRESS);
        task.setPriority(Priority.MEDIUM);
        task.setDueDate(LocalDate.now().plusDays(2));

        Task savedTask = taskRepository.save(task);

        assertThat(savedTask.getId()).isNotNull();
        assertThat(taskRepository.findById(savedTask.getId())).isPresent();
        assertThat(taskRepository.findById(savedTask.getId()).get().getTitle()).isEqualTo("Demo Task");
    }

}
