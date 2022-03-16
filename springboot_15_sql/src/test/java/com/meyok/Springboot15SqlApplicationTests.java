package com.meyok;

import com.meyok.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class Springboot15SqlApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testJdbcTemplate(@Autowired JdbcTemplate jdbcTemplate) {
        String sql = "SELECT * FROM tbl_book";
        RowMapper<Book> rm = (rs, rowNum) -> {
            Book temp = new Book();
            temp.setId(rs.getInt("id"));
            temp.setName(rs.getString("name"));
            temp.setType(rs.getString("type"));
            temp.setDesc(rs.getString("desc"));
            return temp;
        };
        List<Book> query = jdbcTemplate.query(sql, rm);
        System.out.println(query);
    }

    @Test
    void testJdbcTemplateSave(@Autowired JdbcTemplate jdbcTemplate) {
        String sql = "INSERT INTO tbl_book VALUES(3, 'springboot1', 'springboot2', 'springboot3')";
        jdbcTemplate.update(sql);
    }

}
