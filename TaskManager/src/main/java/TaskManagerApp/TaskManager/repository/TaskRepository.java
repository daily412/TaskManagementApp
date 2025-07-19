package TaskManagerApp.TaskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import TaskManagerApp.TaskManager.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{
    

}
