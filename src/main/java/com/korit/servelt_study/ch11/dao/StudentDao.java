package com.korit.servelt_study.ch11.dao;

import com.korit.servelt_study.ch11.entity.Student;
import com.korit.servelt_study.ch11.util.DBConnectionMgr;
import lombok.RequiredArgsConstructor;

import java.sql.*;

@RequiredArgsConstructor
public class StudentDao {

    private final DBConnectionMgr mgr;

    public void insert(Student student) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = mgr.getConnection();
            String sql =
                    """
                        INSERT INTO student_tb (student_id, student_name, phone, email, department_id, grade, major_type, admission_year)
                        values (
                                default, ? ,? ,? ,? ,? ,? ,?
                        )
                    """;

            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, student.getStudentName());
            ps.setString(2, student.getPhone());
            ps.setString(3, student.getEmail());
            ps.setInt(4, student.getDepartmentId());
            ps.setInt(5, student.getGrade());
            ps.setString(6, student.getMajorType());
            ps.setString(7, student.getAdmissionYear());

            if (ps.executeUpdate() < 1) {
                throw new SQLException();
            }

            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                int studentId = rs.getInt(1);
                student.setStudentId(studentId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mgr.freeConnection(con, ps, rs);
        }

    }
}
