package by.pvt.medvedeva.education.dao.interfacesDAO;

import by.pvt.medvedeva.education.dao.exeption.DAOException;

import java.util.List;

public interface CourseDAO <Course>  {


	List <Course> getAllCoursesInfo() throws DAOException;


	}
