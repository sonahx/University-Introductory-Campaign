package ua.lviv.lgs.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.UserApplicationRepository;
import ua.lviv.lgs.domain.UserApplication;

@Service
public class UserApplicationService {

	@Autowired
	private UserApplicationRepository userApplicationRepository;
	
	private Logger logger = LoggerFactory.getLogger(UserApplicationService.class);
	
	public void save(UserApplication userApplication) {
		logger.info("save UserApplication");
		userApplicationRepository.save(userApplication);
	}
	
	public void saveAll(List<UserApplication> userApplications) {
		logger.info("save all UserApplications");
		userApplicationRepository.saveAll(userApplications);
	}
}
