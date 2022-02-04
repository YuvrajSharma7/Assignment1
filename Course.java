package Assignment;




public class Course {
	
	private String courseId;
	private String courseName;
	
	public Course(String cId,String cName) {
		this.courseId=cId;
		this.courseName=cName;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
}