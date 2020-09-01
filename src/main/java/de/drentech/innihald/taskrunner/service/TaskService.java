package de.drentech.innihald.taskrunner.service;

import de.drentech.innihald.taskrunner.domain.model.Task;
import de.drentech.innihald.taskrunner.domain.repository.TaskRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class TaskService {

    @Inject
    TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return this.taskRepository.listAll();
    }

    public Task persistTask(Task task) {
        this.taskRepository.persist(task);

        return task;
    }
}
