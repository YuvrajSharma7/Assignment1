package Assignment;

public class Result {

	private String courseId;
	private String studentId;
	private Integer studentMarks;
	
	public Result(String cId, String sId, Integer marks) {
		this.courseId=cId;
		this.studentId=sId;
		this.studentMarks=marks;
	}
	
	public Result(String cId) {
		this.courseId=cId;
		
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Integer getStudentMarks() {
		return studentMarks;
	}

	public void setStudentMarks(Integer studentMarks) {
		this.studentMarks = studentMarks;
	}
	
}
