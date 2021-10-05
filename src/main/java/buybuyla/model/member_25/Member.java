package buybuyla.model.member_25;   //packagesToScan

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MemberTable")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
//	@Column(name = "account",columnDefinition = "nvarchar(255)")
	@Column(name = "account",nullable = false) //想到改名成+not null
	String userId;
	String password;
	String name;
	String email;
	String tel; 
	Integer experience;   
	//不能用基本型態int  只能用類別
	//因為Hibernate精神是操作物件去對應DB

	public Member(String userId, String password, String name, String mail,
			String tel, Integer expericnce) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		email = mail;
		this.tel = tel;
		this.experience = expericnce;
	}

	public Member() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		email = mail;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer expericnce) {
		this.experience = expericnce;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
