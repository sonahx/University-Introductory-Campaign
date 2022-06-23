package ua.lviv.lgs.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Subject {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	@Column
	private String name;
	@Column
	private Double value;

	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "subject_user", joinColumns = @JoinColumn(name =
	 * "subject_id"), inverseJoinColumns = @JoinColumn(name = "user_id")) private
	 * List<User> applicants = new ArrayList<User>();
	 */
	
	
	public Subject() {
	}

	public Subject(Integer id, String name, Double value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public Subject(String name, Double value) {
		this.name = name;
		this.value = value;
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

	@Override
	public int hashCode() {
		return Objects.hash(id, name, value);
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
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(value, other.value);
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", value=" + value + "]";
	}

}
