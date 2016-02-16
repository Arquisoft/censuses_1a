package es.uniovi.asw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CreateH2Database {


    @Autowired
    protected JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public void create() {
        createUsers();
    }

    private void createUsers() {

        jdbcTemplate.execute("create table if not exists users (id serial, first_name varchar(255), last_name varchar(255))");
        String[] names = "John Woo;Jeff Dean;Josh Bloch;Josh Long".split(";");
        for (String fullname : names) {
            String[] name = fullname.split(" ");
            jdbcTemplate.update(
                "INSERT INTO users(first_name,last_name) values(?,?)",
                name[0], name[1]);
            }
        }
    }