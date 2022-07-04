package ua.lviv.lgs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.SubjectRepository;
import ua.lviv.lgs.domain.Subject;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	private Logger logger = LoggerFactory.getLogger(SubjectService.class);
	
	public Subject save(Subject subject) {
		logger.info("save subject");
		return subjectRepository.save(subject);
	}
	
}

