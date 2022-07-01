package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.UserApplicationRepository;
import ua.lviv.lgs.domain.UserApplication;

@Service
public class UserApplicationService {

	@Autowired
	private UserApplicationRepository userApplicationRepository;
	
	public void save(UserApplication userApplication) {
		userApplicationRepository.save(userApplication);
	}
	
	public void saveAll(List<UserApplication> userApplications) {
		userApplicationRepository.saveAll(userApplications);
	}
}
