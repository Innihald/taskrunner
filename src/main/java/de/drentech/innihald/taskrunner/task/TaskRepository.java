package de.drentech.innihald.taskrunner.task;

import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaskRepository implements PanacheMongoRepository<Task> {
}
