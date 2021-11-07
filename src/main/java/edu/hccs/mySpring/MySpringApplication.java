package edu.hccs.mySpring;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MySpringApplication {

	public static void main(String[] args) throws IOException, ParseException {
		Scanner Scan = new Scanner (System.in); //create a scanner class for keyboard input for search purpose
		String filePath = null;

		//context contained the container information
		ConfigurableApplicationContext context = SpringApplication.run(MySpringApplication.class, args);

		//create object of a Student
		//Student student = new Student();
		Student student = context.getBean(Student.class); //create object of a Student and handle by spring container
		JSONParser jsonParser = new JSONParser(); //create object of JSONParser for parsing the JSON string

		int jsonId; //variable holding for id input
		//System.out.println("Please \n enter 1 for Id =1, \n enter 2 for Id =2,"
		//		+ "\n enter 3 for Id =3,\n enter 4 for Id =4,"); //requesting user to put the id for looking for
		//jsonId = Scan.nextInt(); //assign user input to jsonId

		jsonId = 2; //sample example for id 2
		//jsonId = 3; //sample example for id 3
		if (jsonId == 1) {
			filePath = ".\\Json\\course1.json"; //create a filePath variable for Json file source id =1 
		}else if (jsonId == 2) {
			filePath = ".\\Json\\course2.json";//create a filePath variable for Json file source id =2 
		}
		else if (jsonId == 3) {
			filePath = ".\\Json\\course3.json";//create a filePath variable for Json file source id =3 
		}
		else if (jsonId == 4) {
			filePath = ".\\Json\\course4.json";//create a filePath variable for Json file source id =4
		}else
			System.out.println("incorrection");

		//FileReader reader = new FileReader(".\\Json\\course.json");
		FileReader reader = new FileReader(filePath); 		// make connection and read a file 
		Object obj = jsonParser.parse(reader);				// read and assign to obj of object data type 
		JSONObject jsonObjType = (JSONObject)obj;			// casting obj to JSONObject data type and assign to jsonObjType

		long iId = (long) jsonObjType.get("id"); 			// get the id part and cast it to long data type and assign to iId
		student.setId(iId);						            //set the id to the student object 
		System.out.println("Id is =" +  student.getId()); 	//display/print the Id

		String fName = (String) jsonObjType.get("first_name");  // get the first name part and cast it to String data type and assign to fName
		student.setFirst_name(fName); 							//set the first name to the student object 
		System.out.println("First Name is =" +  student.getFirst_name()); //display/print the first name

		String eEmail = (String) jsonObjType.get("email");     // get the email part and cast it to String data type and assign to eEmail
		student.setEmail(eEmail);							   //set the email to the student object 
		System.out.println("email is = " +  student.getEmail()); //display/print the email

		String gGender = (String) jsonObjType.get("gender");  // get the gender part and cast it to string data type and assign to gGender
		student.setGender(gGender);							  //set the gender to the student object 
		System.out.println("Gender is = " +  student.getGender()); //display/print the Gender 

		System.out.println("Student Information = " + student.toString());

		//create object of a Course
		Course course = new Course();						//create object of a Course
		//Course course = context.getBean(Course.class);    //create object of a Course and handle by Spring container

		JSONArray courseArray = (JSONArray)jsonObjType.get("course"); //get the course details and cast it to JSONArray data type and assign to courseArray
		double sum =0;
		long creditHoursCount =0;
		for (int i=0; i< courseArray.size(); i++) {

			JSONObject courseDetails =(JSONObject)courseArray.get(i);
			//System.out.println("address  " + address);
			String courNo = (String) courseDetails.get("courseNo");     //get the courseNo part and cast it to string data type and assign to courNo
			course.setCourseNo(courNo);								    //set the course No to the Course object 
			String grade = (String) courseDetails.get("grade");         //get the grade part and cast it to string data type and assign to grade
			course.setGrade(grade);										//set the grade to the Course object
			long creditHours = (long) courseDetails.get("creditHours"); //get the credit Hours part and cast it to string data type and assign to creditHours
			course.setCreditHours(creditHours);							//set the credit Hours to the Course object

			System.out.println("\n Course " + i  + " is ........");
			System.out.println("Course No is :" + course.getCourseNo());       //display/print the Course no 
			System.out.println("Grade is  :" + course.getGrade());			   //display/print the Grade 
			System.out.println("Credit Hours is :" + course.getCreditHours()); //display/print the CreditHours 

			if (grade.equals("A")) {
				long product = 4*course.getCreditHours(); //assign the product of the grade point and course credit hour to product variable
				System.out.println("Point (Grade * CreditHours) is : " + product); //display the product
				//System.out.println("Point (Grade * CreditHours) is : " + 4*course.getCreditHours()); //display the product
				sum +=product;								//sum up and assign the grade point 
				//System.out.println(sum);					//display the sub total for each course
				long hourCounter = course.getCreditHours();	//assign the course credit hour to counter variable
				creditHoursCount +=hourCounter; 			//sum up the course credit hour counter 
				//System.out.println(creditHoursCount);		/display the total credit hour
			}
			else if(grade.equals("B")) {
				long product = 3*course.getCreditHours();  //assign the product of the grade point and course credit hour to product variable
				System.out.println("Point (Grade * CreditHours) is : " + 3*course.getCreditHours()); //display the product
				sum +=product;											//sum up and assign the grade point 
				long hourCounter = course.getCreditHours();		//assign the course credit hour to counter variable
				creditHoursCount +=hourCounter;					//sum up the course credit hour counter 
				}
			else if(grade.equals("C")) {
				
				long product = 2*course.getCreditHours();		//assign the product of the grade point and course credit hour to product variable
				System.out.println("Point (Grade * CreditHours) is : " + product); //display the product
				sum +=product;									//sum up and assign the grade point 
				long hourCounter = course.getCreditHours();	//assign the course credit hour to counter variable
				creditHoursCount +=hourCounter;				//sum up the course credit hour counter 
				
			}
			else if(grade.equals("D")) {
				long product = 1*course.getCreditHours();		//assign the product of the grade point and course credit hour to product variable
				System.out.println("Point (Grade * CreditHours) is : " + product); //display the product
				sum +=product;									//sum up and assign the grade point 
				long hourCounter = course.getCreditHours();		//assign the course credit hour to a counter variable
				creditHoursCount +=hourCounter;					//sum up the course credit hour counter 
				
			}
			else { 							//checking any thing else 
				System.out.println("No information available"); // display no information available 
			}
			}
		System.out.println("Total Grade Point : " + sum);
		System.out.println("Total credit hour : " + creditHoursCount);
		System.out.println("GPA for the Id is : " + sum/creditHoursCount);
	}
	
}



