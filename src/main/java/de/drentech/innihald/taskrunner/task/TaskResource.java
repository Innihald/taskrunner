package de.drentech.innihald.taskrunner.task;


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

    @GET
    @Path("/next/{topic}/{task}")
    public Task getNextActiveTask(@PathParam("topic") String topic, @PathParam("task") String task) {
        System.out.println("Topic: " + topic);
        System.out.println("Task: " + task);
        return this.taskService.getNextActive(topic, task);
    }
}
