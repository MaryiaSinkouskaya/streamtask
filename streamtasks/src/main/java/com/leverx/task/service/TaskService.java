package com.leverx.task.service;

import com.leverx.task.entity.Task;
import com.leverx.task.entity.enums.TaskType;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TaskService {

    List<Task> createTasks();

    String sort(List<Task> tasks);

    Map<String, List<Task>> groupByTitle(List<Task> tasks);

    Map<TaskType, List<Task>> groupByType(List<Task> tasks);

    Map<LocalDate, List<Task>> groupByCreatedOn(List<Task> tasks);

    Map<Set<String>, List<Task>> groupByTags(List<Task> tasks);

    List<Map<?, List<Task>>> groupTitlesByFourParams(List<Task> tasks);

    }
