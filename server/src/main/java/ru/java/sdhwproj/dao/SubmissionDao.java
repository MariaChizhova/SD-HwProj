package ru.java.sdhwproj.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.java.sdhwproj.models.Submission;

@Repository
public class SubmissionDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SubmissionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*
    Creates new submission in db
     */
    public void create(Submission submission) {
        jdbcTemplate.update("INSERT INTO submission(homework, solution, date, mark, comment) VALUES(?, ?, ?, ?, ?)",
                submission.getHomeworkId(), submission.getSolution(), submission.getTime(),
                submission.getResult(), submission.getProgramOutput());
    }

    /*
    Read submission from db by id
     */
    public Submission read(Long homeworkId, Long submissionId) {
        return jdbcTemplate.queryForObject("SELECT * FROM submission WHERE id = ? AND homework = ?",
                (rs, rowNum) ->
                        new Submission(
                                rs.getLong("id"),
                                rs.getLong("homework"),
                                rs.getTimestamp("date"),
                                rs.getString("solution"),
                                rs.getInt("mark"),
                                rs.getString("comment")
                        ), submissionId, homeworkId);
    }

    /*
     Read submissions from db
     */
    public List<Submission> readAll(Long homeworkId) {
        return jdbcTemplate.query("SELECT * FROM submission  WHERE homework = ?",
                (rs, rowNum) ->
                        new Submission(
                                rs.getLong("id"),
                                rs.getLong("homework"),
                                rs.getTimestamp("date"),
                                rs.getString("solution"),
                                rs.getInt("mark"),
                                rs.getString("comment")
                        ), homeworkId);
    }

    /*
    Update submission's mark in db
    */
    public void updateMark(Long submissionId, Integer mark) {
        jdbcTemplate.update("UPDATE submission SET mark = ? WHERE id = ?", mark, submissionId);
    }

    /*
    Update submission's comment in db
    */
    public void updateComment(Long submissionId, String comment) {
        jdbcTemplate.update("UPDATE submission SET comment = ? WHERE id = ?", comment, submissionId);
    }
}
