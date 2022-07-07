package ua.lviv.lgs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.dao.SubjectRepository;
import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.Subject;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserRole;
import ua.lviv.lgs.service.SubjectService;
import ua.lviv.lgs.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SubjectTests {

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@BeforeEach
	void clear() {	
		userRepository.deleteAll();
		subjectRepository.deleteAll();
		craeteUser();
	}

	@Test
	void saveSubjectTest() {
		List<Subject> list = subjectRepository.findAll();
		assertThat(list, hasSize(0));

		createSubject("name", 111.5, userService.findOne(craeteUser().getId()));
		list = subjectRepository.findAll();
		assertThat(list, hasSize(1));
	}

	Subject createSubject(String name, Double value, User user) {
		Subject subject = new Subject();
		subject.setName(name);
		subject.setValue(value);
		subject.setUser(user);

		subjectService.save(subject);
		return subject;
	}

	User craeteUser() {
		User user = new User();
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setEmail("email");
		user.setPassword("password");
		user.setPasswordConfirm("password");
		user.setRole(UserRole.ROLE_USER);
		userService.save(user);
		return user;
	}
}
