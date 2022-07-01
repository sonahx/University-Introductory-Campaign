package ua.lviv.lgs.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class UserApplication {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "faculty_id", nullable = false)
	private Faculty faculty;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	private String status;

	public UserApplication() {

	}

	public UserApplication(Faculty faculty, User user) {
		this.faculty = faculty;
		this.user = user;
	}

	public UserApplication(Faculty faculty, User user, String status) {
		this.faculty = faculty;
		this.user = user;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Double getUserScore() {
		return user.getAverageScore();
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(faculty, id, status, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserApplication other = (UserApplication) obj;
		return Objects.equals(faculty, other.faculty) && Objects.equals(id, other.id)
				&& Objects.equals(status, other.status) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "UserApplication [id=" + id + ", faculty=" + faculty + ", user=" + user + ", status=" + status + "]";
	}

}
