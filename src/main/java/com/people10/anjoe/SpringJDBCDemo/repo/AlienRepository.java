package com.people10.anjoe.SpringJDBCDemo.repo;

import com.people10.anjoe.SpringJDBCDemo.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlienRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Alien alien) {
        String query = "INSERT INTO aliens (id, name, tech) VALUES (?, ?, ?)";
        int rowsAffected = jdbcTemplate.update(query, alien.getId(), alien.getName(), alien.getTech());
        System.out.println("Rows affected: " + rowsAffected);
    }

    public List<Alien> getAll() {
        String query = "SELECT * FROM aliens";

        return jdbcTemplate.query(query, (resultSet, rowNum) -> {
            Alien alien = new Alien();
            alien.setId(resultSet.getInt("id"));
            alien.setName(resultSet.getString("name"));
            alien.setTech(resultSet.getString("tech"));
            return alien;
        });
    }

}
