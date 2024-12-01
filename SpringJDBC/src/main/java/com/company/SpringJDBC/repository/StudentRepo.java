package com.company.SpringJDBC.repository;

import com.company.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student std) {
        String sql = "insert into student(rollno, name, marks) values (?,?,?)";
       int res = jdbc.update(sql,std.getRollNo(),std.getName(),std.getMarks());
        System.out.println(res);
    }

    public List<Student> findAll() {
        String sql = "select * from student";

        RowMapper<Student> map = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student std = new Student();
                std.setRollNo(rs.getInt("rollno"));
                std.setName(rs.getString("name"));
                std.setMarks(rs.getInt("marks"));
                return std;
            }
        };

        return jdbc.query(sql,map);
    }
}
