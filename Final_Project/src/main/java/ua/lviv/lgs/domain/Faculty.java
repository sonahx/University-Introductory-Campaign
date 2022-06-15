package ua.lviv.lgs.domain;

import java.util.List;
import java.util.Objects;

public class Faculty {
	private Integer id;
	private String name;
	private String description;
	private Double minimumScore;
	private List<User> applicants;

	public Faculty() {
	}

	public Faculty(Integer id, String name, String description, Double minimumScore, List<User> applicants) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.minimumScore = minimumScore;
		this.applicants = applicants;
	}

	public Faculty(String name, String description, Double minimumScore, List<User> applicants) {
		this.name = name;
		this.description = description;
		this.minimumScore = minimumScore;
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

	public Double getMinimumScore() {
		return minimumScore;
	}

	public void setMinimumScore(Double minimumScore) {
		this.minimumScore = minimumScore;
	}

	public List<User> getApplicants() {
		return applicants;
	}

	public void setApplicants(List<User> applicants) {
		this.applicants = applicants;
	}

	@Override
	public int hashCode() {
		return Objects.hash(applicants, description, id, minimumScore, name);
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
		return Objects.equals(applicants, other.applicants) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(minimumScore, other.minimumScore)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", description=" + description + ", minimumScore="
				+ minimumScore + ", applicants=" + applicants + "]";
	}

}
