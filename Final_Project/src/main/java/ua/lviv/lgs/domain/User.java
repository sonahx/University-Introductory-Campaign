package ua.lviv.lgs.domain;

import java.util.List;
import java.util.Objects;

public class User {
	private Integer id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private UserRole role;
	private List<Faculty> applications;

	public User() {
	};

	public User(Integer id, String email, String firstName, String lastName, String password, UserRole role,
			List<Faculty> applications) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
		this.applications = applications;
	}

	public User(String email, String firstName, String lastName, String password, UserRole role) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
	}

	public User(Integer id, String email, String firstName, String lastName, String password, UserRole role) {
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public List<Faculty> getApplications() {
		return applications;
	}

	public void setApplications(List<Faculty> applications) {
		this.applications = applications;
	}

	@Override
	public int hashCode() {
		return Objects.hash(applications, email, firstName, id, lastName, password, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(applications, other.applications) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& role == other.role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", role=" + role + ", applications=" + applications + "]";
	}

}
