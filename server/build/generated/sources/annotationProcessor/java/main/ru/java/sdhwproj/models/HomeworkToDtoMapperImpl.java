package ru.java.sdhwproj.models;

import java.sql.Timestamp;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.java.sdhwproj.requests.HomeworkRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-21T01:52:00+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class HomeworkToDtoMapperImpl implements HomeworkToDtoMapper {

    @Override
    public Homework AddHomeworkRequestToHomework(HomeworkRequest homeworkRequest) {
        if ( homeworkRequest == null ) {
            return null;
        }

        String name = null;
        String description = null;
        Timestamp publication = null;
        Timestamp deadline = null;

        name = homeworkRequest.getName();
        description = homeworkRequest.getDescription();
        publication = homeworkRequest.getPublication();
        deadline = homeworkRequest.getDeadline();

        Long id = null;

        Homework homework = new Homework( id, name, description, publication, deadline );

        return homework;
    }
}
