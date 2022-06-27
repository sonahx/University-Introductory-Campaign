package ua.lviv.lgs.service;

import java.util.Optional;

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

	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setPasswordConfirm(bCryptPasswordEncoder.encode(user.getPasswordConfirm()));
		user.setRole(UserRole.ROLE_USER);
		userRepository.save(user);
	}

	public User findOne(Integer id) {
		return userRepository.getReferenceById(id);
	}

	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public void update(User user) {
		userRepository.save(user);
	}
	
	public Double calculateScore(User user) {
		Double subjectSum =user.getSubjects().stream().mapToDouble(s -> s.getValue()).sum();
		Double schoolScore = user.getAvgSchoolScore();
		
		Double score = subjectSum + schoolScore;
		int size = user.getSubjects().size()+1;
		return score / size;
	}
}