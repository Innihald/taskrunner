package de.drentech.innihald.taskrunner.http.resource;


import de.drentech.innihald.taskrunner.domain.model.Task;
import de.drentech.innihald.taskrunner.domain.repository.TaskRepository;
import de.drentech.innihald.taskrunner.service.TaskService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDateTime;
import java.util.List;

@Path("/task")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource {

    @Inject
    TaskService taskService;

    @GET
    public List<Task> getAllDocuments() {
        return this.taskService.getAllTasks();
    }

    @POST
    public Task createTask(Task task) {
        task.isActive = true;
        task.createdAt = LocalDateTime.now();

        return this.taskService.persistTask(task);
    }
}