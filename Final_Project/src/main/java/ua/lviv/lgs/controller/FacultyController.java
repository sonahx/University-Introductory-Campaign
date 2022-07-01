package ua.lviv.lgs.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.domain.UserApplication;
import ua.lviv.lgs.service.FacultyService;
import ua.lviv.lgs.service.UserApplicationService;
import ua.lviv.lgs.service.UserDTO;
import ua.lviv.lgs.service.UserService;

@Controller
public class FacultyController {

	@Autowired
	private UserService userService;

	@Autowired
	private FacultyService facultyService;
	
	@Autowired
	UserApplicationService userApplicationService;

	@RequestMapping(value = "/addFaculty", method = RequestMethod.POST)
	public ModelAndView createFaculty(@ModelAttribute("faculty") Faculty faculty) {
		facultyService.save(faculty);
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = "/faculty/{id}", method = RequestMethod.GET)
	public ModelAndView watchFaculty(@PathVariable Integer id, HttpServletRequest req) {
		Faculty faculty = facultyService.findOne(id);
		req.setAttribute("faculty", faculty);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		Optional<User> user = userService.findByEmail(userEmail);

		req.setAttribute("user", user.get());

		ModelAndView map = new ModelAndView("faculty");
		map.addObject("applicants", faculty.getApplicants());
		return map;
	}

	@RequestMapping(value = "/faculty/{id}/apply/{email}", method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView apply(@PathVariable String email, @PathVariable Integer id, HttpServletRequest req) {
		Optional<User> user = userService.findByEmail(email);
		Faculty faculty = facultyService.findOne(id);

		UserApplication userApplication	= new UserApplication(faculty,user.get());
		userApplicationService.save(userApplication);
		
		List<UserApplication> userList = faculty.getApplicants();
		userList.add(userApplication);
		faculty.setApplicants(userList);
		facultyService.save(faculty);

		
		List<UserApplication> facultyList = user.get().getApplications();
		facultyList.add(userApplication);
		user.get().setApplications(facultyList);
		userApplicationService.saveAll(UserDTO.setStatus(faculty, user.get(), userApplication));
		
		return new ModelAndView("redirect:/faculty/" + id.toString());
	}

}
