package com.codemymobile.Assesment.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String firstName;

	private String lastName;

	private String avatarUri;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "friend")
	private Set<UserRelations> friends = new HashSet<>();
	
	public User() {
		super();
	}

	public User(String firstName, String lastName, String avatarUri) {
		super();
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

	public Set<UserRelations> getFriends() {
		return friends;
	}

	public void setFriends(Set<UserRelations> friends) {
		this.friends = friends;
	}

	public String getAvatarUri() {
		return avatarUri;
	}

	public void setAvatarUri(String avatarUri) {
		this.avatarUri = avatarUri;
	}

}
