package com.codemymobile.Assesment.dto;

public class UserDTO {

	private Integer id;

	private String firstName;

	private String lastName;

	private String avatarUri;

	public UserDTO() {
		super();
	}

	public UserDTO(Integer id, String firstName, String lastName, String avatarUri) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.avatarUri = avatarUri;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAvatarUri() {
		return avatarUri;
	}

	public void setAvatarUri(String avatarUri) {
		this.avatarUri = avatarUri;
	}

}
