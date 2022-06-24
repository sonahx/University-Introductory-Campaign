package ua.lviv.lgs.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String universityName;
	
	@Lob
	private String description;
	private Integer studentQuantity;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "faculty_user", joinColumns = @JoinColumn(name = "faculty_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	public List<User> applicants = new ArrayList<User>();

	public Faculty() {
	}

	public Faculty(Integer id, String name, String universityName, String description, Integer studentQuantity,
			List<User> applicants) {
		this.id = id;
		this.name = name;
		this.universityName = universityName;
		this.description = description;
		this.studentQuantity = studentQuantity;
		this.applicants = applicants;
	}

	public Faculty(String name, String universityName, String description, Integer studentQuantity,
			List<User> applicants) {
		this.name = name;
		this.universityName = universityName;
		this.description = description;
		this.studentQuantity = studentQuantity;
		this.applicants = applicants;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getApplicants() {
		return applicants;
	}

	public void setApplicants(List<User> applicants) {
		this.applicants = applicants;
	}

	public Integer getStudentQuantity() {
		return studentQuantity;
	}

	public void setStudentQuantity(Integer studentQuantity) {
		this.studentQuantity = studentQuantity;
	}
	

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(universityName, description, id, name, studentQuantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return Objects.equals(universityName, other.universityName) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(studentQuantity, other.studentQuantity);
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", UniversityName=" + universityName + ", description="
				+ description + ", studentQuantity=" + studentQuantity + "]";
	}

}
