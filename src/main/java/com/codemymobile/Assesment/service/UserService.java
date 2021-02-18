package com.codemymobile.Assesment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.codemymobile.Assesment.dto.UserDTO;
import com.codemymobile.Assesment.model.User;
import com.codemymobile.Assesment.model.UserRelations;
import com.codemymobile.Assesment.repository.UserRelationRepository;
import com.codemymobile.Assesment.repository.UserRepository;

@Service
public class UserService {

	ModelMapper modelMapper;

	private UserRepository userRepository;

	private UserRelationRepository userRelationRepository;

	@Autowired
	public UserService(UserRepository userRepository, UserRelationRepository userRelationRepository,
			ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.userRelationRepository = userRelationRepository;
		this.modelMapper = modelMapper;
	}

	public Page<User> getUsers(Integer pageNumber, Integer size) {
		Pageable paging = PageRequest.of(pageNumber, size);
		Page<User> users = userRepository.findAll(paging);
		return users;
	}

	public List<UserDTO> getFriends(Integer id) throws Exception {
		Optional<User> userVal = userRepository.findById(id);
		List<UserDTO> usersDto = new ArrayList<>();
		if(userVal.isPresent()) {
			User user = userVal.get();
			Set<UserRelations> userRelation = user.getFriends();
			for (UserRelations userRelations : userRelation) {
				usersDto.add(convertToDto(userRelations.getRequester()));
			}
		}
		else {
			throw new Exception("User not found");
		}
		return usersDto;
	}
	
	private UserDTO convertToDto(User user) {
		UserDTO userDto = modelMapper.map(user, UserDTO.class);
	    return userDto;
	}
}
