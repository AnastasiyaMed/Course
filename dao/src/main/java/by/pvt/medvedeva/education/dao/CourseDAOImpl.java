package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.interfacesDAO.CourseDAO;
import by.pvt.medvedeva.education.entity.Course;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CourseDAOImpl implements CourseDAO {
	public static final String SQL_QUERY_GET_ALL_COURSES = "SELECT *  FROM course";
	public static final String SQL_QUERY_ADD_COURSE = "INSERT INTO course (course_name, duration, auditorium, teacher_teacher_id) VALUES (?,?,?,?)";
	private final String COLUMN_NAME_COURSE = "course_name";
	private final String COLUMN_NAME_DURATION = "duration";
	private final String COLUMN_NAME_AUDITORIUM = "auditorium";

	@Override
	public ArrayList<Course> getAllCoursesInfo() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Course> allCourses = new ArrayList<>();
		try {
			ConnectionPool pool = new ConnectionPool();
			connection = pool.getConnect();
			preparedStatement = connection.prepareStatement(SQL_QUERY_GET_ALL_COURSES);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Course course = new Course();
				course.setName(resultSet.getString(COLUMN_NAME_COURSE));
				course.setDuration(Integer.parseInt(resultSet.getString(COLUMN_NAME_DURATION)));
				course.setAuditorium(Integer.parseInt(resultSet.getString(COLUMN_NAME_AUDITORIUM)));
				allCourses.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return allCourses;
	}

	@Override
	public void addCourse(final Course course) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			ConnectionPool pool = new ConnectionPool();
			conn = pool.getConnect();
			preparedStatement = conn.prepareStatement(SQL_QUERY_ADD_COURSE);
			preparedStatement.setString(1, course.getName());
			preparedStatement.setInt(2, course.getDuration());
			preparedStatement.setInt(3, course.getAuditorium());
			preparedStatement.setInt(4, course.getIdTeacher());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

}
