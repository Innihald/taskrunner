package de.drentech.innihald.taskrunner.domain.model;

import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.Dictionary;
import java.util.List;

@MongoEntity(collection = "Task")
public class Task {

    public ObjectId id;

    public String topic;

    public String task;

    public Boolean isActive;

    public LocalDateTime createdAt;

    public List<Payload> payload;
}
