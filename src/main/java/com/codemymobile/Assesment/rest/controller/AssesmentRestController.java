package com.codemymobile.Assesment.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.codemymobile.Assesment.dto.UserDTO;
import com.codemymobile.Assesment.model.User;
import com.codemymobile.Assesment.service.UserService;

@RestController
@RequestMapping(value = "/v1/assesment/users")
public class AssesmentRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = "")
	public ResponseEntity<Object> getUsers(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size) {
		List<User> users = new ArrayList<User>();
		List<UserDTO> usersDto = new ArrayList<UserDTO>();
		Page<User> pagingUser = userService.getUsers(page, size);
		pagingUser.getContent().forEach(users::add);
		for (User user : users) {
			usersDto.add(convertToDto(user));
		}
		Map<String, Object> response = new HashMap<>();
		response.put("users", usersDto);
		response.put("currentPage", pagingUser.getNumber());
		response.put("totalItems", pagingUser.getTotalElements());
		response.put("totalPages", pagingUser.getTotalPages());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("{id}/friends")
	@ResponseBody
	public ResponseEntity<Object> getFriends(@PathVariable Integer id) {
		List<UserDTO> users = null;
		try {
			users = userService.getFriends(id);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	private UserDTO convertToDto(User user) {
		UserDTO userDto = modelMapper.map(user, UserDTO.class);
		return userDto;
	}
}
