package com.example.employee_service.Response;

public class EmployeeResponse {
	
	
	private int id;
	
	private String name;
	
	private String email;
	
	private String bloodgroup;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public EmployeeResponse(int id, String name, String email, String bloodgroup) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.bloodgroup = bloodgroup;
	}

	public EmployeeResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmployeeResponse [id=" + id + ", name=" + name + ", email=" + email + ", bloodgroup=" + bloodgroup
				+ "]";
	}
	

}
