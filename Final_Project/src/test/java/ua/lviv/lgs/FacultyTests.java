package ua.lviv.lgs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.service.FacultyService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacultyTests {

	@Autowired
	FacultyService facultyService;

	@Autowired
	FacultyRepository facultyRepository;

	@BeforeEach
	void clear() {
		facultyRepository.deleteAll();
	}

	@Test
	void saveFacultyTest() {
		List<Faculty> list = facultyRepository.findAll();
		assertThat(list, hasSize(0));
		craeteFaculty("name", "universityName", 5, "description", 10000);
		list = facultyRepository.findAll();
		assertThat(list, hasSize(1));
	}

	@Test
	void findOneTest() {
		List<Faculty> list = facultyRepository.findAll();
		assertThat(list, hasSize(0));
		Faculty createdFaculty = craeteFaculty("name", "universityName", 5, "description", 10000);
		Faculty faculty = facultyService.findOne(createdFaculty.getId());
		assertTrue(faculty.getId().equals(createdFaculty.getId()));
	}

	@Test
	void getAllFacultiesTest() {
		List<Faculty> list = facultyRepository.findAll();
		assertThat(list, hasSize(0));

		Faculty createdFaculty1 = craeteFaculty("name1", "universityName1", 5, "description1", 10000);
		Faculty createdFaculty2 = craeteFaculty("name2", "universityName2", 15, "description2", 50000);
		List<Faculty> facultyList = new ArrayList<>();
		facultyList.add(createdFaculty1);
		facultyList.add(createdFaculty2);

		list = facultyRepository.findAll();

		assertThat(list, hasSize(facultyList.size()));
	}

	Faculty craeteFaculty(String name, String universityName, Integer studentsToAccept, String description,
			Integer studentQuantity) {
		Faculty faculty = new Faculty();
		faculty.setName(name);
		faculty.setUniversityName(universityName);
		faculty.setStudentsToAccept(studentsToAccept);
		faculty.setDescription(description);
		faculty.setStudentQuantity(studentQuantity);
		facultyService.save(faculty);
		return faculty;
	}
}
