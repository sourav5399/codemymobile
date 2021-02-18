package com.codemymobile.Assesment.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.codemymobile.Assesment.repository.UserRelationshipId;

@Entity
@Table(name = "USER_RELATIONS")
@IdClass(UserRelationshipId.class)
public class UserRelations implements Serializable {

	private static final long serialVersionUID = -2377120703089592976L;

	@Id
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	User requester;

	@Id
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	User friend;

	public User getRequester() {
		return requester;
	}

	public void setRequester(User requester) {
		this.requester = requester;
	}

	public User getFriend() {
		return friend;
	}

	public void setFriend(User friend) {
		this.friend = friend;
	}

}
