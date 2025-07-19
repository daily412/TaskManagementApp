package TaskManagerApp.TaskManager.controller;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import TaskManagerApp.TaskManager.dto.TaskRequestDTO;
import TaskManagerApp.TaskManager.dto.TaskResponseDTO;
import TaskManagerApp.TaskManager.enums.Priority;
import TaskManagerApp.TaskManager.enums.TaskStatus;
import TaskManagerApp.TaskManager.exception.TaskNotFoundException;
import TaskManagerApp.TaskManager.service.TaskService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Autowired
    private ObjectMapper objectMapper;

    void shouldReturn201WhenValidTaskIsCreated() throws Exception {
    TaskRequestDTO requestDto = new TaskRequestDTO();
    requestDto.setTitle("Complete Assignment");
    requestDto.setDescription("Finish Spring Boot project");
    requestDto.setStatus(TaskStatus.PENDING);
    requestDto.setPriority(Priority.HIGH);
    requestDto.setDueDate(LocalDate.now().plusDays(1));

    TaskResponseDTO responseDto = new TaskResponseDTO(1L, requestDto.getTitle(), requestDto.getDescription(),
            requestDto.getStatus(), requestDto.getPriority(), requestDto.getDueDate());

    Mockito.when(taskService.createTask(Mockito.any())).thenReturn(responseDto);

    mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Complete Assignment"))
                .andExpect(jsonPath("$.status").value("PENDING"))
                .andExpect(jsonPath("$.priority").value("HIGH"));
}

    @Test
    void shouldReturn404WhenTaskNotFound() throws Exception {
    Mockito.when(taskService.getTaskById(999L))
           .thenThrow(new TaskNotFoundException("Task with ID 999 not found."));

    mockMvc.perform(get("/api/tasks/999"))
           .andExpect(status().isNotFound())
           .andExpect(jsonPath("$.error").value("Task with ID 999 not found."));
}
}
