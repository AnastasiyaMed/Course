/**
 * 
 */
package by.pvt.medvedeva.education.entity;

/**
 * @author Anastasiya Medvedeva
 *
 */
public class Teacher extends User {

	private int idTeacher;

	public Teacher() {
		super();
	}

	public Teacher(int idTeacher, int idUser, String name, String surname, String login, String password, int role) {
		super(idUser, name, surname, login, password, role);
		this.idTeacher = idTeacher;
	}

	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + idTeacher;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Teacher)) {
			return false;
		}
		Teacher other = (Teacher) obj;
		if (idTeacher != other.idTeacher) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", surname=" + surname + ", login=" + login + ", password=" + password + ", role=" + role + "]";
	}

}
