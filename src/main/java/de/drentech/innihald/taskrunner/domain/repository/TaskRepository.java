package de.drentech.innihald.taskrunner.domain.repository;

import de.drentech.innihald.taskrunner.domain.model.Task;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaskRepository implements PanacheMongoRepository<Task> {
}
