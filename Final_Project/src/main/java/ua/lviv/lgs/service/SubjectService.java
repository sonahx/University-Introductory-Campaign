package ua.lviv.lgs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.SubjectRepository;
import ua.lviv.lgs.domain.Subject;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	public Subject save(Subject subject) {
		return subjectRepository.save(subject);
	}
	
}

