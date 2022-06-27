package ua.lviv.lgs.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String name;
	@Column
	private Double value;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Subject() {
	}

	public Subject(Integer id, String name, Double value, User user) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.user = user;
	}

	public Subject(String name, Double value, User user) {
		this.name = name;
		this.value = value;
		this.user = user;
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

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, user, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(user, other.user)
				&& Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", value=" + value + ", user=" + user + "]";
	}

}
