package de.drentech.innihald.taskrunner.task;

import de.drentech.innihald.taskrunner.task.payload.Payload;
import io.quarkus.mongodb.panache.MongoEntity;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
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
