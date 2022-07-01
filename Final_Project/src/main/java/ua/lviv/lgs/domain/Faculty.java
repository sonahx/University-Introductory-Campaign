package ua.lviv.lgs.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String universityName;
	private Integer studentsToAccept;

	@Lob
	private String description;
	private Integer studentQuantity;

	@OneToMany(mappedBy="faculty")
	public List<UserApplication> applicants = new ArrayList<UserApplication>();

	public Faculty() {
	}

	public Faculty(Integer id, String name, String universityName, Integer studentsToAccept, String description,
			Integer studentQuantity, List<UserApplication> applicants) {
		this.id = id;
		this.name = name;
		this.universityName = universityName;
		this.studentsToAccept = studentsToAccept;
		this.description = description;
		this.studentQuantity = studentQuantity;
		this.applicants = applicants;
	}

	public Faculty(String name, String universityName, Integer studentsToAccept, String description,
			Integer studentQuantity, List<UserApplication> applicants) {
		this.name = name;
		this.universityName = universityName;
		this.studentsToAccept = studentsToAccept;
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

	public List<UserApplication> getApplicants() {
		return applicants;
	}

	public void setApplicants(List<UserApplication> applicants) {
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

	public Integer getStudentsToAccept() {
		return studentsToAccept;
	}

	public void setStudentsToAccept(Integer studentsToAccept) {
		this.studentsToAccept = studentsToAccept;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, name, studentQuantity, studentsToAccept, universityName);
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
		return Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(studentQuantity, other.studentQuantity)
				&& Objects.equals(studentsToAccept, other.studentsToAccept)
				&& Objects.equals(universityName, other.universityName);
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", universityName=" + universityName + ", studentsToAccept="
				+ studentsToAccept + ", description=" + description + ", studentQuantity=" + studentQuantity + "]";
	}

}
