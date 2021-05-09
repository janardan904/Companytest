package com.app.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
// this is model class using data jpa 
import lombok.Data;
@Data
@Entity
@Table(name= "USER_DTLS")
public class User {
	@Id
	@GeneratedValue
	@Column(name="userId")
	private Integer userId;
	@Column(name="user_Email")
	private String userEmail;
	@Column(name="user_Name")
	private String userName;
	@Column(name="user_Contact")
	private String mobileNo;

}
