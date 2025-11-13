package com.korit.servelt_study.ch11.dao;

import com.korit.servelt_study.ch11.entity.Course;
import com.korit.servelt_study.ch11.util.DBConnectionMgr;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@RequiredArgsConstructor
public class CourseDao {

    private final DBConnectionMgr mgr;

    public void insert(Course course) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = mgr.getConnection();
            String sql =
                    """
                        INSERT INTO course_tb
                        values (
                                default, ?, ?, ?, ?, ?, ?
                        )
                    """;

            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, course.getCourseCode());
            ps.setString(2, course.getCourseName());
            ps.setInt(3, course.getProfessorId());
            ps.setInt(4, course.getCredit());
            ps.setInt(5, course.getEnrollmentCapacity());
            ps.setString(6, course.getClassroom());

            ps.execute();
            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                int courseId = rs.getInt(1);
                course.setCourseId(courseId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mgr.freeConnection(con, ps, rs);
        }
    }
}
