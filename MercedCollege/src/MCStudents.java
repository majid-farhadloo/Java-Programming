
public class MCStudents implements Comparable {
	private String awardYear;
	private String term;
	private String  discipline;
	private String grade;
	private String course;
	
	public MCStudents(String[] data){
		term = data[1];
		awardYear = data[0];
		grade = data[4];
		discipline = data[3];
		course = data[2];
	}

	public String getAwardYear() {
		return awardYear;
	}

	public void setAwardYear(String awardYear) {
		this.awardYear = awardYear;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "MCStudents [awardYear=" + awardYear + ", term=" + term + ", discipline=" + discipline + ", grade="
				+ grade + ", course=" + course + "]";
	}
	public int compareTo(Object o){
		MCStudents otherStudnet = (MCStudents)o;
		//TODO auto-generated method stub
		return this.course.compareTo(otherStudnet.course);
	}
	
}