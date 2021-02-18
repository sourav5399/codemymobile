package com.codemymobile.Assesment.repository;

import java.io.Serializable;

public class UserRelationshipId implements Serializable {

	private static final long serialVersionUID = -7267745854537043371L;

	Integer requester;

	Integer friend;

	public Integer getRequester() {
		return requester;
	}

	public void setRequester(Integer requester) {
		this.requester = requester;
	}

	public Integer getFriend() {
		return friend;
	}

	public void setFriend(Integer friend) {
		this.friend = friend;
	}

}
