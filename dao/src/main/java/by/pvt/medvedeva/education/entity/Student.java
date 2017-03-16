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

public class Student extends User {

	private int idStudent;
	private int level;
	private double average;
	private String studentIdCard;

	public Student() {
		super();
	}

	public Student(int idStudent, int level, int average, String studentIdCard, int idUser, String name, String surname, String login, String password, int role) {
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

	public String getStudentIdCard() {
		return studentIdCard;
	}

	public void setStudentIdCard(String studentIdCard) {
		this.studentIdCard = studentIdCard;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(average);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + idStudent;
		result = prime * result + level;
		result = prime * result + ((studentIdCard == null) ? 0 : studentIdCard.hashCode());
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
		if (!(obj instanceof Student)) {
			return false;
		}
		Student other = (Student) obj;
		if (Double.doubleToLongBits(average) != Double.doubleToLongBits(other.average)) {
			return false;
		}
		if (idStudent != other.idStudent) {
			return false;
		}
		if (level != other.level) {
			return false;
		}
		if (studentIdCard == null) {
			if (other.studentIdCard != null) {
				return false;
			}
		} else if (!studentIdCard.equals(other.studentIdCard)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Student [level=" + level + ", average=" + average + ", studentIdCard=" + studentIdCard + ", name=" + name + ", surname=" + surname + ", login=" + login + ", password=" + password + ", role=" + role + "]";
	}

}
