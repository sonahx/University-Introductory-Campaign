package ua.lviv.lgs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.domain.Faculty;
import ua.lviv.lgs.service.FacultyService;

@Controller
public class FacultyController {

	@Autowired
	private FacultyService facultyService;
	
	@RequestMapping(value = "/addFaculty", method = RequestMethod.POST)
	public ModelAndView createFaculty(@ModelAttribute("faculty") Faculty faculty,
			BindingResult bindingResult) {
		facultyService.save(faculty);
		return new ModelAndView("redirect:/home");
	}
}
