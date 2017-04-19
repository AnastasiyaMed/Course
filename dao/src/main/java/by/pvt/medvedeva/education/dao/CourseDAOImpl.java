package by.pvt.medvedeva.education.dao;

import by.pvt.medvedeva.education.dao.exeption.DAOException;
import by.pvt.medvedeva.education.dao.interfacesDAO.AbstractDAO;
import by.pvt.medvedeva.education.dao.interfacesDAO.ConnectionPool;
import by.pvt.medvedeva.education.dao.interfacesDAO.CourseDAO;
import by.pvt.medvedeva.education.entity.Course;
import by.pvt.medvedeva.education.utils.MySQLConnectionPool;

import java.sql.SQLException;
import java.util.ArrayList;


public class CourseDAOImpl extends AbstractDAO<Course> implements CourseDAO<Course>   {
    private static final String SQL_QUERY_GET_ALL_COURSES = "SELECT *  FROM course";
    private static final String SQL_QUERY_ADD_COURSE = "INSERT INTO course (course_name, duration, auditorium, teacher_teacher_id) VALUES (?,?,?,?)";
    private static final String COLUMN_NAME_COURSE = "course_name";
    private static final String COLUMN_NAME_DURATION = "duration";
    private static final String COLUMN_NAME_AUDITORIUM = "auditorium";
    private static CourseDAOImpl instance;

     /**
     * Singleton-fabric
     *
     */
    public static CourseDAOImpl getInstance() throws DAOException {
        if (instance == null) {
            try {
                instance = new CourseDAOImpl(MySQLConnectionPool.getInstance());
            } catch (SQLException e) {
                throw new DAOException("Some trouble whith connect to database", e);
            }
        }
        return instance;
    }


    CourseDAOImpl(ConnectionPool connectionPool) throws SQLException {
        this.connectionPool = connectionPool;
    }



    @Override
    public void create(Course course) throws DAOException {
        try {
            connection = connectionPool.getConnect();
            preparedStatement = connection.prepareStatement(SQL_QUERY_ADD_COURSE);
            preparedStatement.setString(1, course.getName());
            preparedStatement.setInt(2, course.getDuration());
            preparedStatement.setInt(3, course.getAuditorium());
            preparedStatement.setInt(4, course.getIdTeacher());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Some trouble whith connect to database", e);
        } finally {
            try {
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
    }

    @Override
    public ArrayList <Course> getAllCoursesInfo() throws DAOException {
        ArrayList <Course> allCourses = new ArrayList <>();
        try {
            connection = connectionPool.getConnect();
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
            throw new DAOException("Some trouble whith connect to database", e);
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


    }






