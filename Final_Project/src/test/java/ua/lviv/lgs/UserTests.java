package ua.lviv.lgs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserRole;
import ua.lviv.lgs.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserTests {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@BeforeEach
	void clear() {
		userRepository.deleteAll();
	}

	@Test
	void saveUserTest() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		createUser("firstName", "lastName", "email", "password");
		users = userRepository.findAll();
		assertThat(users, hasSize(1));
	}

	@Test
	void findByEmailTest() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User createdUser = createUser("firstName", "lastName", "email", "password");
		Optional<User> user = userService.findByEmail(createdUser.getEmail());
		assertTrue(user.get().getEmail().equals(createdUser.getEmail()));
	}

	@Test
	void findOneTest() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User createdUser = createUser("firstName", "lastName", "email", "password");
		User user = userService.findOne(createdUser.getId());
		assertTrue(user.getId().equals(createdUser.getId()));

	}

	@Test
	void updateAllTest() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User createdUser1 = createUser("firstName1", "lastName1", "email1", "password1");
		User createdUser2 = createUser("firstName2", "lastName2", "email2", "password2");
		List<User> list = new ArrayList<>();
		list.add(createdUser1);
		list.add(createdUser2);
		userService.updateAll(list);

		assertThat(list, hasSize(2));

	}

	User createUser(String firstName, String lastName, String email, String password) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setPasswordConfirm(password);
		user.setRole(UserRole.ROLE_USER);
		userService.save(user);
		return user;
	}

}