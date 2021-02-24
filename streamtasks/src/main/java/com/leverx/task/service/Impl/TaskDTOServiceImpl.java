package com.leverx.task.service.Impl;

import com.leverx.task.entity.Task;
import com.leverx.task.entity.TaskDTO;
import com.leverx.task.service.TaskDTOService;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class TaskDTOServiceImpl implements TaskDTOService {

    public TaskDTO convert(Task task) {
        return new TaskDTO(task.getId(), task.getTitle(), task.getType(), task.getCreatedOn());
    }

    public List<TaskDTO> convertTasksToTaskDTO(List<Task> tasks) {
        return tasks.stream().map(this::convert).collect(toList());
    }

}
