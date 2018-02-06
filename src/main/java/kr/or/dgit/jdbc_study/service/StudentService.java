package kr.or.dgit.jdbc_study.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import kr.or.dgit.db_connection.jdbc.DBConn;
import kr.or.dgit.jdbc_study.dao.StudentDao;
import kr.or.dgit.jdbc_study.dto.Student;

public class StudentService implements StudentDao {
	private static final StudentService instance = new StudentService();

	public static StudentService getInstance() {
		return instance;
	}

	private StudentService() {}

	@Override
	public Student findStudentById(int studId) {
		return null;
	}

	@Override
	public void insertStudent(Student student) {

	}

	@Override
	public void deleteStudent(int studId) {

	}

	@Override
	public List<Student> findAllStudents() {
		List<Student> lists = null;
		Connection conn = DBConn.getInstance().getConnection();
		String sql = "select stud_id, name, email, dob from stduent";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {
			if (!rs.next()) {
				return Collections.emptyList();
			}
			lists = new ArrayList<>();
			do {
				lists.add(getStudent(rs));
			} while(rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	private Student getStudent(ResultSet rs) throws SQLException {
		int studId = rs.getInt("stud_id");
		String name = rs.getString("name");
		String email = rs.getString("email");
		Date dob = rs.getDate("dob");
		
		return new Student(studId, name, email, dob);
	}

}
