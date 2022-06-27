package ua.lviv.lgs.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String passwordConfirm;
	
	@Column(columnDefinition="Decimal(10,2)")
	private Double averageScore;
	
	private Double avgSchoolScore;

	private UserRole role;

	@ManyToMany(mappedBy = "applicants")
	private List<Faculty> applications = new ArrayList<Faculty>();

	@OneToMany(mappedBy = "user")
	private List<Subject> subjects = new ArrayList<Subject>();

	public User() {
	};

	public User(User user) {
		this.id = user.id;
		this.email = user.email;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.password = user.password;
		this.role = user.role;
		this.applications = user.applications;
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

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Double getAvgSchoolScore() {
		return avgSchoolScore;
	}

	public void setAvgSchoolScore(Double avgSchoolScore) {
		this.avgSchoolScore = avgSchoolScore;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(Double averageScore) {
		this.averageScore = averageScore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(averageScore, avgSchoolScore, email, firstName, id, lastName, password, passwordConfirm,
				role);
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
		return Objects.equals(averageScore, other.averageScore) && Objects.equals(avgSchoolScore, other.avgSchoolScore)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(passwordConfirm, other.passwordConfirm)
				&& role == other.role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", passwordConfirm=" + passwordConfirm + ", averageScore=" + averageScore
				+ ", avgSchoolScore=" + avgSchoolScore + ", role=" + role + "]";
	}

}
