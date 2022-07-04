package ua.lviv.lgs.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.FacultyRepository;
import ua.lviv.lgs.domain.Faculty;

@Service
public class FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;
	
	private Logger logger = LoggerFactory.getLogger(FacultyService.class);

	public Faculty save(Faculty faculty) {
		logger.info("save faculty");
		return facultyRepository.save(faculty);

	}

	public List<Faculty> getAllFaculties() {
		logger.info("get all faculties");
		return facultyRepository.findAll();
	}
	
	public Faculty findOne(Integer id){
		logger.info("get faculty with id: " +id);
		return facultyRepository.getReferenceById(id);
	}
}
