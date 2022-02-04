package Assignment;

import java.io.InputStreamReader;
import Assignment.Course;
import java.util.*;
//Main Class
public class MainClass {

	public static ArrayList<Course> courseList = new ArrayList<Course>();
	public static ArrayList<Student> studentList = new ArrayList<Student>();
	public static ArrayList<Result> resultList = new ArrayList<Result>();
	
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		
		boolean o=true;
		while(o) {
			showMenu();
			System.out.println("Please select an option");
			String choice=scan.nextLine();
			
			switch (choice) {
			case "1":
				addCourse();
				break;
			case "2":
				addStudent();
				break;
			case "3":
				addResult();
				break;
			case "4":
				resultChoice();
				break;
			case "5":
				System.out.println("Thank You");
				o=false;
				break;
				default:
					System.out.println("Your input is incorrect");
					break;
			}
		}
	}
	
	// method to display menu
	public static void showMenu() {
		System.out.println("------Welcome to students result management system-------");
		System.out.println("1) Add course\n" 
				+"2) Add student\n" 
				+"3) Add result\n"
				 +"4) View results\n" 
				+"5) Quit ");
		System.out.println("------------------------------------------------------");
	}
	
	//------------------------------------------------------------------------------
	//method to check if course already exist
	public static boolean checkIfCourseExist(String searchKey) {
		for(Course c:courseList) {
			if(c.getCourseId().equals(searchKey)) {
				return true;
			}
		}
		return false;	
	}
	
	//method to add courses starts here
	public static void addCourse() {
		//taking input
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter course Id");
		String cId=scan.nextLine();
		
		//checking if course id already exists, calling above method with parameter as cId		
		while(checkIfCourseExist(cId)) {
			System.out.println("This course already exist");
			System.out.println("Please enter unique course  Id");
			cId=scan.nextLine();
		}
		//taking course name
		System.out.println("Please enter course Name");
		String cName=scan.nextLine();
		
		//creating object of course
				Course course=new Course(cId,cName);
		
		//add course object to course list
		courseList.add(course);
		
		System.out.println("Would you like to [A]dd a new course or [R]eturn to the previous menu? ");
		
		String choice=scan.nextLine();
		
		while(!choice.equals("A") && !choice.equals("R")) {
			System.out.println("Pleae enter corrcet input");
			choice=scan.nextLine();
		}
		if(choice.equals("A")) {
			addCourse();
		}
	} //method to add courses ends here
	//-------------------------------------------------------------------------------------
	
	//method to check if student already exist
	public static boolean checkIfStudentExist(String searchKey) {
		for(Student c:studentList) {
			if(c.getStudentId().equals(searchKey)) {
				return true;
			}
		}
		return false;	
	}
	//method to add students starts here
	public static void addStudent() {
		//take input
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter Student Id");
		String sId=scan.nextLine();
		
		//checking if student id already exists, calling above method with parameter as sId			
		while(checkIfStudentExist(sId)) {
			System.out.println("This Student already exist");
			System.out.println("Please enter unique Student  Id");
			sId=scan.nextLine();
		}
		System.out.println("Please enter Student Name");
		String sName=scan.nextLine();
		//create object of Student
				Student Student=new Student(sId,sName);
		
		//add Student object to Student list
		studentList.add(Student);
		
		System.out.println("Would you like to [A]dd a new Student or [R]eturn to the previous menu? ");
		
		String choice=scan.nextLine();
		
		while(!choice.equals("A") && !choice.equals("R")) {
			System.out.println("Pleae enter corrcet input");
			choice=scan.nextLine();
		}
		if(choice.equals("A")) {
			addStudent();
		}
	}//method to add students ends here
	//---------------------------------------------------------------------------
				
	//method to add result starts here
		public static void addResult() {
			//take course code input
			Scanner scan=new Scanner(System.in);
			
			System.out.println("Please enter course Id");
			String cId=scan.nextLine();
					
			//checking if course id already exists, calling above method with parameter as cId			
			while(!checkIfCourseExist(cId)) {
				System.out.println("This course doesn't exist");
				System.out.println("Please enter correct course  Id");
				cId=scan.nextLine();
			}
			//take student code input
			System.out.println("Please enter student Id");
			String sId=scan.nextLine();
					
			//checking if student id already exists, calling above method with parameter as sId			
			while(!checkIfStudentExist(sId)) {
				System.out.println("This student doesn't exist");
				System.out.println("Please enter correct student  Id");
				sId=scan.nextLine();
			}
			//take student marks input
			try {
			System.out.println("Please enter Student marks between 0-100 only");
			Integer sMarks=scan.nextInt();
			scan.nextLine();
			while(sMarks<0 || sMarks>100) {
				throw new Exception();
			}
			//create object of Student
			Result result=new Result(cId,sId,sMarks);
	
	//add Student object to Student list
			resultList.add(result);
			}
			catch(Exception e) {
				System.out.println("You have entered invalid input");	
				System.out.println("Please enter corrcet input");
			}
			System.out.println("Would you like to [A]dd a new result or [R]eturn to the previous menu?");
			
			String choice = scan.nextLine();
			
			while(!choice.equals("A") && !choice.equals("R")) {
				choice=scan.nextLine();
			}
			if(choice.equals("A")) {
				addResult();
			}
		}//method to add marks ends here

//--------------------------------------------------------------------------------	
			// get student name by ID
				
				public static String getStudentNamebyId(String sId) {
					String sName="";
					for(Student st:studentList) {
						if(st.getStudentId().equals(sId)) {
							sName= st.getStudentName();
							break;
						}
					}
					return sName;
				}
				// get course name by ID
				
				public static String getCourseNamebyId(String cId) {
					String cName="";
					for(Course st:courseList) {
						if(st.getCourseId().equals(cId)) {
							cName= st.getCourseName();
							break;
						}
					}
					return cName;
				}
				//method to select choice to view student/course result 
				public static void resultChoice() {
					System.out.println("1) view result by Course Id");
					System.out.println("2) view result by Student Id");
					Scanner scan =new Scanner(System.in);
					String choice= scan.nextLine();
					
					while(!choice.equals("1") && !choice.equals("2")) {
						System.out.println("Pleae enter corrcet input");
						choice=scan.nextLine();
					}
					if(choice.equals("1")) {
						viewResultByCourse();
					}
					else viewResultByStudent();
				}
//method to view result by course Id
	public static void viewResultByCourse() {
		//take course code input
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter course Id to view results");
		String cId=scan.nextLine();
		
		//checking if course id already exists, calling above method with parameter as cId			
		while(!checkIfCourseExist(cId)) {
			System.out.println("This course doesn't exist");
			System.out.println("Please enter correct course  Id");
			cId=scan.nextLine();
		}
		//displaying course results:
		
		for(Result result:resultList) {
			if(result.getCourseId().equals(cId)) {
			String stName=getStudentNamebyId(result.getStudentId());
			String csName=getCourseNamebyId(result.getCourseId());
			System.out.println("------------");
			System.out.println("Course Name: "+csName);
			System.out.println("Student Name: "+stName);
			System.out.println("Marks: "+result.getStudentMarks());
			System.out.println("------------");
		}
		}
	}
	//method to view result by student Id 
	public static void viewResultByStudent() {
		//take course code input
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter student Id to view results");
		String sId=scan.nextLine();
		
		//checking if course id already exists, calling above method with parameter as cId			
		while(!checkIfStudentExist(sId)) {
			System.out.println("This student doesn't exist");
			System.out.println("Please enter correct student  Id");
			sId=scan.nextLine();
		}
		//displaying student results:
		ArrayList<Integer> studentMarks= new ArrayList<>();
		
		System.out.println("------------");
		for(Result result:resultList) {
			if(result.getStudentId().equals(sId)) {
			String stName=getStudentNamebyId(result.getStudentId());
			String csName=getCourseNamebyId(result.getCourseId());
			System.out.println("Student Name: "+stName);
			System.out.println("Course Name: "+csName);
			System.out.println("Marks: "+result.getStudentMarks());
			studentMarks.add(result.getStudentMarks());	
		}	
		}
		Integer totalMarks=0;
		for(Integer marks: studentMarks) {
			totalMarks += marks;
		}
		System.out.println("Average Marks= "+(totalMarks/studentMarks.size()));
		System.out.println("------------");
	}
	}
