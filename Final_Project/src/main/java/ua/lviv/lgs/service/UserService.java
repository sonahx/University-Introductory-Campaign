package ua.lviv.lgs.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.UserRepository;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserRole;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);

	public void save(User user) {
		logger.info("save encoded user");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
		user.setRole(UserRole.ROLE_USER);
		userRepository.save(user);
	}

	public User findOne(Integer id) {
		logger.info("get user by id: " +id);
		return userRepository.getReferenceById(id);
	}

	public Optional<User> findByEmail(String email) {
		logger.info("get user by email: " +email);
		return userRepository.findByEmail(email);
	}
	
	public void update(User user) {
		logger.info("update user");
		userRepository.save(user);
	}
	public void updateAll(List<User> userList) {
		logger.info("update all users");
		userRepository.saveAll(userList);
	}
	
}