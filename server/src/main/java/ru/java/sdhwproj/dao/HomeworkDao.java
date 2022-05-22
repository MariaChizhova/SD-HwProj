package ru.java.sdhwproj.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.java.sdhwproj.models.Homework;

@Repository
public class HomeworkDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HomeworkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Homework homework) {
        jdbcTemplate.update("INSERT INTO homework(name, publication, description, deadline) VALUES(?, ?, ?, ?)",
                homework.getName(), homework.getPublication(), homework.getDescription(), homework.getDeadline());
    }

    public Homework read(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM homework WHERE id = ?", (rs, rowNum) ->
                new Homework(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getTimestamp("publication"),
                        rs.getTimestamp("deadline")
                ), id);
    }

    public List<Homework> readAll() {
        return jdbcTemplate.query("SELECT * FROM homework", (rs, rowNum) ->
                new Homework(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getTimestamp("publication"),
                        rs.getTimestamp("deadline")
                ));
    }
}
