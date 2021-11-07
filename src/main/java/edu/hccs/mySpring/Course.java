package edu.hccs.mySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Autowired(required=false)
//	@Autowired
public class Course {

	String courseNo;
	String grade;
	long creditHours;
	public Course() {

	}

	/**
	 * @return the courseNo
	 */
	public String getCourseNo() {
		return courseNo;
	}

	/**
	 * @param courseNo the courseNo to set
	 */
	@Autowired(required=false)
	//@Autowired
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	@Autowired(required=false)
	//@Autowired
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the creditHours
	 */
	public long getCreditHours() {
		return creditHours;
	}

	/**
	 * @param creditHours the creditHours to set
	 */
	public void setCreditHours(long creditHours) {
		this.creditHours = creditHours;
	}
	//@Autowired(required=false)
	@Autowired
	public Course(String courseNo, String grade, long creditHours) {
		super();
		this.courseNo = courseNo;
		this.grade = grade;
		this.creditHours = creditHours;
	}
	@Override
	public String toString() {
		return "Course [courseNo=" + courseNo + ", grade=" + grade + ", creditHours=" + creditHours + "]";
	}

}
