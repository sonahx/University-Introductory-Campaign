package ua.lviv.lgs.service;

import java.io.IOException;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserApplication;

public class UserDTO {

	public static User encodeImage(MultipartFile file, User user) throws IOException {
		user.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
		return user;
	}
	public static Double calculateScore(User user) {
		Double subjectSum =user.getSubjects().stream().mapToDouble(s -> s.getValue()).sum();
		Double schoolScore = user.getAvgSchoolScore();
		
		Double score = subjectSum + schoolScore;
		int size = user.getSubjects().size()+1;
		return score / size;
	}
	
	public static List<UserApplication> setStatus(Faculty faculty, User user, UserApplication userApplication) {
		
		List<UserApplication> list= faculty.getApplicants().stream().sorted(Comparator.comparing(UserApplication::getUserScore).reversed())
				.limit(faculty.getStudentsToAccept()).collect(Collectors.toList());
			
		List<User> userList = list.stream().map(u -> u.getUser()).collect(Collectors.toList());
			
		if(userList.contains(user)) {
			userApplication.setStatus("Accepted");
		}else{
			userApplication.setStatus("Declined");
		}
		
		List<UserApplication> applicants = faculty.getApplicants();
		applicants.forEach(u ->{	
			if(!list.contains(u)) {
				u.setStatus("Declined");		
			}	
		});	
		return applicants;
	}
}
