package ru.java.sdhwproj.models;

import org.mapstruct.Mapper;
import ru.java.sdhwproj.requests.HomeworkRequest;

@Mapper(componentModel = "spring")
public interface HomeworkToDtoMapper {
    Homework AddHomeworkRequestToHomework(HomeworkRequest homeworkRequest);
}
