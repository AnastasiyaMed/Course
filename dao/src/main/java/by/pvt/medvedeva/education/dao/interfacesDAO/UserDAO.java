package by.pvt.medvedeva.education.dao.interfacesDAO;

public interface UserDAO  <User>{

	User getUserByLogin(final String login);

	boolean CheckLogin(String login);

}
