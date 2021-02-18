package com.codemymobile.Assesment.repository;

import org.springframework.data.repository.CrudRepository;

import com.codemymobile.Assesment.model.UserRelations;

public interface UserRelationRepository extends CrudRepository<UserRelations, UserRelationshipId> {

}
