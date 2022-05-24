package ru.java.sdhwproj.models;

import org.mapstruct.Mapper;
import ru.java.sdhwproj.requests.SubmissionRequest;

@Mapper(componentModel = "spring")
public interface SubmissionToDtoMapper {

    /**
     * Make Submission model from SubmissionRequest model
     * @param submissionRequest
     * @return
     */
    Submission AddSubmissionRequestToSubmission(SubmissionRequest submissionRequest);
}
