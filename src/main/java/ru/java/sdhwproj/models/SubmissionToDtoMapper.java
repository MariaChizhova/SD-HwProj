package ru.java.sdhwproj.models;

import org.mapstruct.Mapper;
import ru.java.sdhwproj.requests.SubmissionRequest;

@Mapper(componentModel = "spring")
public interface SubmissionToDtoMapper {
    Submission AddSubmissionRequestToSubmission(SubmissionRequest submissionRequest);
}
