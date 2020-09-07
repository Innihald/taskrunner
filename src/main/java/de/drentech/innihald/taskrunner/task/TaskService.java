package de.drentech.innihald.taskrunner.task;

import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
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

    @Transactional
    public Task getNextActive(String topic, String task) {
        Task nextTask = this.taskRepository.find("{topic: ?1, task: ?2, isActive: {$eq: ?3}}", Sort.by("createdAt", Sort.Direction.Descending), topic, task, true).firstResult();

        if(nextTask == null) {
            return new Task();
        } else {
            nextTask.isActive = false;

            this.taskRepository.update(nextTask);

            return nextTask;
        }
    }
}
