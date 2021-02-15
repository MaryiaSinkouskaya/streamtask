package com.leverx.task.entity;

import com.leverx.task.entity.enums.TaskType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class Task {
    @Setter
    private String id;

    private final String title;

    private final TaskType type;

    private final LocalDate createdOn;

    @Setter
    private boolean done = false;

    private final Set<String> tags = new HashSet<>();

    @Setter
    private LocalDate dueTo;

    public Task addTag(String tag) {
        tags.add(tag);
        return this;
    }
}