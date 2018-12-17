/**
 * 
 */
package com.bucom.security.model;

import java.util.Date;

import javax.validation.constraints.Past;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhailiang
 *
 */
@Data
public class User {

	public interface UserSimpleView {};
	public interface UserDetailView extends UserSimpleView {};
	private  String id;
	@ApiModelProperty(value = "用户名" )
	private String username;
	@NotBlank
	private String password;
	@Past
	private Date birthday;

	public User (){

	}

	public User(String username) {
		this.username = username;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@JsonView(UserSimpleView.class)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	@JsonView(UserDetailView.class)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}