package edu.hccs.mySpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
	
	private long id;
	private String first_name;
	private String email;
	private String gender;
	private Course course;
		
	public Student() {	}
	
	@Autowired(required=false)
	//@Autowired
	public Student(int id, String first_name, String email, String gender, Course course) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.email = email;
		this.gender = gender;
		this.course = course;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param iId the id to set
	 */
	@Autowired(required=false)
	//@Autowired
	public void setId(long iId) {
		this.id = iId;
	}
	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	@Autowired(required=false)
	//@Autowired
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	@Autowired(required=false)
	//@Autowired
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	@Autowired(required=false)
	//@Autowired
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	@Autowired(required=false)
	//@Autowired
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", first_name=" + first_name + ", email=" + email + ", gender=" + gender
				+ ", course=" + course + "]";
	}


}
