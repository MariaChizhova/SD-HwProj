package ru.java.sdhwproj.models;

import java.sql.Timestamp;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.java.sdhwproj.requests.SubmissionRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-21T01:52:00+0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class SubmissionToDtoMapperImpl implements SubmissionToDtoMapper {

    @Override
    public Submission AddSubmissionRequestToSubmission(SubmissionRequest submissionRequest) {
        if ( submissionRequest == null ) {
            return null;
        }

        Timestamp time = null;
        String solution = null;

        time = submissionRequest.getTime();
        solution = submissionRequest.getSolution();

        Long id = null;
        Long homeworkId = null;
        Integer result = null;
        String programOutput = null;

        Submission submission = new Submission( id, homeworkId, time, solution, result, programOutput );

        return submission;
    }
}
