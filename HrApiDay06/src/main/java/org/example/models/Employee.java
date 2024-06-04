package org.example.models;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.sql.ResultSet;
import java.sql.SQLException;


@XmlRootElement
public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String hireDate;
	private int jobId;
	private double salary;
	private int departmentId;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int employeeId, String firstName, String lastName, String email, String hireDate, int jobId,
                    double salary, int departmentId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.salary = salary;
		this.departmentId = departmentId;
	}

	public Employee(ResultSet rs) throws SQLException {
		this(
			rs.getInt("employee_id"),
			rs.getString("first_name"),
			rs.getString("last_name"),
			rs.getString("email"),
			rs.getString("hire_date"),
			rs.getInt("job_id"),
			rs.getDouble("salary"),
			rs.getInt("department_id")
		);
		
	}

	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getHireDate() {
		return hireDate;
	}


	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}


	public int getJobId() {
		return jobId;
	}


	public void setJobId(int jobId) {
		this.jobId = jobId;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"employeeId=" + employeeId +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", email='" + email + '\'' +
				", hireDate='" + hireDate + '\'' +
				", jobId=" + jobId +
				", salary=" + salary +
				", departmentId=" + departmentId +
				'}';
	}
}
