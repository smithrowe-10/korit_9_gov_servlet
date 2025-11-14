package com.korit.servelt_study.ch11.dao;

import com.korit.servelt_study.ch11.entity.Professor;
import com.korit.servelt_study.ch11.util.DBConnectionMgr;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ProfessorDaoName {

    private final DBConnectionMgr mgr;

    public List<Professor> findAllLikeName(String name) {
        List<Professor> professors = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = mgr.getConnection();
            String sql =
                    """
                        SELECT 
                            professor_id,
                            professor_name
                        FROM professor_tb
                        WHERE 
                            professor_name LIKE concat('%', ?, '%')
                        order by professor_id;
                    """;

            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                Professor professor = Professor.builder()
                        .professorID(rs.getInt("professor_id"))
                        .professorName(rs.getString("professor_name"))
                        .build();

                professors.add(professor);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            mgr.freeConnection(con, ps, rs);
        }

        return professors;
    }


}
