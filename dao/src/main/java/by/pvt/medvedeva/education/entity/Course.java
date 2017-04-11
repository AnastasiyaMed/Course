/**
 * 
 */
package by.pvt.medvedeva.education.entity;

/**
 * @author Anastasiya Medvedeva
 *
 */
public class Course extends Entity {

	String name;
	int duration;
	int auditorium;
	int idTeacher;

	public Course() {
		super();
	}

	public Course(String name, int duration, int auditorium, int idTeacher) {
		super();
		this.name = name;
		this.duration = duration;
		this.auditorium = auditorium;
		this.idTeacher = idTeacher;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getAuditorium() {
		return auditorium;
	}

	public void setAuditorium(int auditorium) {
		this.auditorium = auditorium;
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
		int result = 1;
		result = prime * result + auditorium;
		result = prime * result + duration;
		result = prime * result + idTeacher;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Course)) {
			return false;
		}
		Course other = (Course) obj;
		if (auditorium != other.auditorium) {
			return false;
		}
		if (duration != other.duration) {
			return false;
		}
		if (idTeacher != other.idTeacher) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", duration=" + duration + ", auditorium=" + auditorium + ", idTeacher=" + idTeacher + "]";
	}

}