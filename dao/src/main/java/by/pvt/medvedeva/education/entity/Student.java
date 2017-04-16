/**
 * 
 */
package by.pvt.medvedeva.education.entity;

/**
 * @author Anastasiya Medvedeva
 *
 *
 *
 */

public class Student extends User  {

	private int idStudent;
	private int level;
	private double average;
	private int studentIdCard;

	public Student() {
		super();
	}

	public Student(int idStudent, int level, int average, int studentIdCard, int idUser, String name, String surname, String login, String password, int role) {
		super(idUser, name, surname, login, password, role);
		this.idStudent = idStudent;
		this.level = level;
		this.average = average;
		this.studentIdCard = studentIdCard;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}

	public int getStudentIdCard() {
		return studentIdCard;
	}

	public void setStudentIdCard(int studentIdCard) {
		this.studentIdCard = studentIdCard;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		long temp;
		result = 31 * result + idStudent;
		result = 31 * result + level;
		temp = Double.doubleToLongBits(average);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		result = 31 * result + studentIdCard;
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Student)) return false;
		if (!super.equals(o)) return false;

		Student student = (Student) o;

		if (idStudent != student.idStudent) return false;
		if (level != student.level) return false;
		if (Double.compare(student.average, average) != 0) return false;
		return studentIdCard == student.studentIdCard;
	}

	@Override
	public String toString() {
		return "Student [level=" + level + ", average=" + average + ", studentIdCard=" + studentIdCard + ", name=" + name + ", surname=" + surname + ", login=" + login + ", password=" + password + ", role=" + role + "]";
	}

}
