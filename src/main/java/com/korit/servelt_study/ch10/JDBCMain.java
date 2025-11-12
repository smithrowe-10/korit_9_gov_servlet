package com.korit.servelt_study.ch10;

import java.sql.*;

/*

    JDBC JavaDataBaseConnection

 */
public class JDBCMain {
    public static void main(String[] args) {
        //  http://ip.port       -> http 프로토콜
        //  jdbc:mysql://ip.port -> jdbc:mysql 프로토콜
        //  mysql의 port: 기본(3306), 우리가 설정(3309)

        final String
                URL = "jdbc:mysql://localhost:3309/Q3_answer",
                USERNAME = "root" ,
                PASSWORD = "1q2w3e4r";

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql =
                    """
                    select *
                    from student_tb
                    where student_name = '김준일';
                    """;
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();

            int studentId = rs.getInt("student_id");
            String studentName = rs.getString("student_name");
            System.out.println("id: " + studentId);
            System.out.println("id: " + studentName);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("데이터 베이스 연결 실패했어요");
        }
    }
}
