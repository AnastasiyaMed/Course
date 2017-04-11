package by.pvt.medvedeva.education.dao.interfacesDAO;

public interface UserDAO  <User>{

	User getUserByLogin(final String login);

//	void addUser(final User user);


	boolean CheckLogin(String login);

}
