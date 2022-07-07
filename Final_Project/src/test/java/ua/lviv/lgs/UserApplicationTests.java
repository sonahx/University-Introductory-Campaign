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

import ua.lviv.lgs.dao.UserApplicationRepository;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserApplication;
import ua.lviv.lgs.domain.UserRole;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.UserApplicationService;
import ua.lviv.lgs.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserApplicationTests {

	@Autowired
	UserApplicationRepository userApplicationRepository;

	@Autowired
	UserApplicationService userApplicationService;
	
	@Autowired
	FacultyService facultyService;
	
	@Autowired
	UserService userService;

	@BeforeEach
	void clear() {	
		userApplicationRepository.deleteAll();
	}
	
	@Test
	void saveUserApplicationTest() {
		List<UserApplication> list = userApplicationRepository.findAll();
		assertThat(list, hasSize(0));
		
		createUserApplication();
		list = userApplicationRepository.findAll();
		assertThat(list, hasSize(1));
	}
	
	UserApplication	createUserApplication() {
		UserApplication userApplication = new UserApplication();
		
		Faculty faculty = new Faculty();
		faculty.setName("name");
		faculty.setUniversityName("universityName");
		faculty.setDescription("desc");
		faculty.setStudentQuantity(10000);
		faculty.setStudentsToAccept(5);
		facultyService.save(faculty);
		
		User user = new User();
		user.setFirstName("firstName");
		user.setLastName("lastName");
		user.setEmail("email");
		user.setPassword("password");
		user.setPasswordConfirm("password");
		user.setRole(UserRole.ROLE_USER);	
		userService.save(user);
		
		userApplication.setFaculty(faculty);
		userApplication.setUser(user);
		userApplication.setStatus("declined");
		userApplicationService.save(userApplication);
		return userApplication;
	}

}
