package ua.lviv.lgs.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.domain.User;

public class UserDTO {

	public static User encodeImage(MultipartFile file, User user) throws IOException {
		user.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
		return user;
	}

}
