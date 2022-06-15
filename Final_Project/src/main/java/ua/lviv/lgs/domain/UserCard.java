package ua.lviv.lgs.domain;

import java.util.Objects;

public class UserCard {
	private Integer id;
	private Double avgSchoolScore;
	private Double subjScore_1;
	private Double subjScore_2;
	private Double subjScore_3;
	private Double subjScore_4;
	private Integer user_id;

	public UserCard() {
	}

	public UserCard(Integer id, Double avgSchoolScore, Double subjScore_1, Double subjScore_2, Double subjScore_3,
			Double subjScore_4, Integer user_id) {
		this.id = id;
		this.avgSchoolScore = avgSchoolScore;
		this.subjScore_1 = subjScore_1;
		this.subjScore_2 = subjScore_2;
		this.subjScore_3 = subjScore_3;
		this.subjScore_4 = subjScore_4;
		this.user_id = user_id;
	}

	public UserCard(Double avgSchoolScore, Double subjScore_1, Double subjScore_2, Double subjScore_3,
			Double subjScore_4, Integer user_id) {
		this.avgSchoolScore = avgSchoolScore;
		this.subjScore_1 = subjScore_1;
		this.subjScore_2 = subjScore_2;
		this.subjScore_3 = subjScore_3;
		this.subjScore_4 = subjScore_4;
		this.user_id = user_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAvgSchoolScore() {
		return avgSchoolScore;
	}

	public void setAvgSchoolScore(Double avgSchoolScore) {
		this.avgSchoolScore = avgSchoolScore;
	}

	public Double getSubjScore_1() {
		return subjScore_1;
	}

	public void setSubjScore_1(Double subjScore_1) {
		this.subjScore_1 = subjScore_1;
	}

	public Double getSubjScore_2() {
		return subjScore_2;
	}

	public void setSubjScore_2(Double subjScore_2) {
		this.subjScore_2 = subjScore_2;
	}

	public Double getSubjScore_3() {
		return subjScore_3;
	}

	public void setSubjScore_3(Double subjScore_3) {
		this.subjScore_3 = subjScore_3;
	}

	public Double getSubjScore_4() {
		return subjScore_4;
	}

	public void setSubjScore_4(Double subjScore_4) {
		this.subjScore_4 = subjScore_4;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avgSchoolScore, id, subjScore_1, subjScore_2, subjScore_3, subjScore_4, user_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCard other = (UserCard) obj;
		return Objects.equals(avgSchoolScore, other.avgSchoolScore) && Objects.equals(id, other.id)
				&& Objects.equals(subjScore_1, other.subjScore_1) && Objects.equals(subjScore_2, other.subjScore_2)
				&& Objects.equals(subjScore_3, other.subjScore_3) && Objects.equals(subjScore_4, other.subjScore_4)
				&& Objects.equals(user_id, other.user_id);
	}

	@Override
	public String toString() {
		return "UserCard [id=" + id + ", avgSchoolScore=" + avgSchoolScore + ", subjScore_1=" + subjScore_1
				+ ", subjScore_2=" + subjScore_2 + ", subjScore_3=" + subjScore_3 + ", subjScore_4=" + subjScore_4
				+ ", user_id=" + user_id + "]";
	}

}
