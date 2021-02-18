package com.codemymobile.Assesment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.codemymobile.Assesment.model.User;
import com.codemymobile.Assesment.model.UserRelations;
import com.codemymobile.Assesment.repository.UserRelationRepository;
import com.codemymobile.Assesment.repository.UserRepository;

//@Component
public class DataLoader implements ApplicationRunner {

	private UserRepository userRepository;

	private UserRelationRepository userRelationRepository;

	@Autowired
	public DataLoader(UserRepository userRepository, UserRelationRepository userRelationRepository) {
		this.userRepository = userRepository;
		this.userRelationRepository = userRelationRepository;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		User user0 = new User("Jim", "Halpert", "https://upload.wikimedia.org/wikipedia/en/7/7e/Jim-halpert.jpg");
		User user1 = new User("Pam", "Beesly",
				"https://upload.wikimedia.org/wikipedia/en/thumb/6/67/Pam_Beesley.jpg/220px-Pam_Beesley.jpg");
		User user2 = new User("Michael", "Scott", "https://upload.wikimedia.org/wikipedia/en/d/dc/MichaelScott.png");
		User user3 = new User("Dwight", "Schrute", "https://upload.wikimedia.org/wikipedia/en/c/cd/Dwight_Schrute.jpg");
		User user4 = new User("Kevin", "Malone",
				"https://upload.wikimedia.org/wikipedia/en/6/60/Office-1200-baumgartner1.jpg");
		List<User> userList = new ArrayList<User>();
		userList.add(user0);
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);

		for (User user : userList) {
			userRepository.save(user);
		}

		for (User user : userList) {
			if (user.getId().equals(5)) {
				continue;
			} else {
				UserRelations friendship = new UserRelations();
				friendship.setFriend(user);
				List<User> otherUsers = userList.stream().filter(u -> u.getId() != user.getId() && u.getId() != 5)
						.collect(Collectors.toList());
				for (User other : otherUsers) {
					friendship.setRequester(other);
					userRelationRepository.save(friendship);
				}
			}
		}
	}

}
