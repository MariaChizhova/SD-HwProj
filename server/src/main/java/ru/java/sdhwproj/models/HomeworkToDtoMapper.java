package ru.java.sdhwproj.models;

import org.mapstruct.Mapper;
import ru.java.sdhwproj.requests.HomeworkRequest;

@Mapper(componentModel = "spring")
public interface HomeworkToDtoMapper {

    /**
     * Make homework model from HomeworkRequest model
     * @param homeworkRequest
     * @return homework as model
     */
    Homework AddHomeworkRequestToHomework(HomeworkRequest homeworkRequest);
}
