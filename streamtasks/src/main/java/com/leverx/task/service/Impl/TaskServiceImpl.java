package com.leverx.task.service.Impl;

import com.leverx.task.entity.Task;
import com.leverx.task.entity.enums.TaskType;
import com.leverx.task.service.TaskService;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

public class TaskServiceImpl implements TaskService {

    public List<Task> createTasks() {
        Task task1 = new Task("Read Version Control with Git book", TaskType.READING, LocalDate.of(2015, Month.JULY, 1)).addTag("git").addTag("reading").addTag("books");

        Task task2 = new Task("Read Java 8 Lambdas book", TaskType.READING, LocalDate.of(2015, Month.JULY, 2)).addTag("java8").addTag("reading").addTag("books");

        Task task3 = new Task("Write a mobile application to store my tasks", TaskType.CODING, LocalDate.of(2015, Month.JULY, 3)).addTag("coding").addTag("mobile");

        Task task4 = new Task("Write a blog on Java 8 Streams", TaskType.WRITING, LocalDate.of(2015, Month.JULY, 4)).addTag("blogging").addTag("writing").addTag("streams");

        Task task5 = new Task("Read Domain Driven Design book", TaskType.READING, LocalDate.of(2015, Month.JULY, 5)).addTag("ddd").addTag("books").addTag("reading");

        return asList(task1, task2, task3, task4, task5);
    }

    public String sort(List<Task> tasks) {
        return tasks.stream()
                .limit(5)
                .sorted(Comparator.comparing(Task::getCreatedOn))
                .map(Task::getTitle)
                .collect(joining(", "));
    }

    public List<Map<?, List<Task>>> groupTitlesByFourParams(List<Task> tasks) {
        return asList(
                groupByTitle(tasks),
                groupByType(tasks),
                groupByCreatedOn(tasks),
                groupByTags(tasks));
    }

    public Map<String, List<Task>> groupByTitle(List<Task> tasks) {
        return tasks.stream().collect(groupingBy(Task::getTitle));
    }

    public Map<TaskType, List<Task>> groupByType(List<Task> tasks) {
        return tasks.stream().collect(groupingBy(Task::getType));
    }

    public Map<LocalDate, List<Task>> groupByCreatedOn(List<Task> tasks) {
        return tasks.stream().collect(groupingBy(Task::getCreatedOn));
    }

    public Map<Set<String>, List<Task>> groupByTags(List<Task> tasks) {
        System.out.println(tasks.stream().collect(groupingBy(Task::getTags)));
        return tasks.stream().collect(groupingBy(Task::getTags));
    }

//    public Map<Object, List<Task>> groupTitles(List<Task> tasks) {
//        Function<Task, List<Object>> compose = task -> Arrays.asList(
//                task.getTitle(),
//                task.getType(),
//                task.getCreatedOn(),
//                task.getTags()
//        );
//
//        return tasks.stream().collect(groupingBy(compose, toList()));
//    }
}
