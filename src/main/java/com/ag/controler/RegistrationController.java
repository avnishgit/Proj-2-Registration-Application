package com.ag.controler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ag.mode.StudentRegistration;
import com.ag.service.RegistrationService;
/**
 * This class contain registration form data
 * @author AVNISH SINGH
 * @version 2.2
 */
@Controller
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;
	/**
	 * This method is used to Display registration form
	 * @param model
	 * @return String
	 */
	
	@GetMapping("/registered")
	public String displayRegistrationForm(Model model ) {
		StudentRegistration reg = new StudentRegistration();
		model.addAttribute("registationBean",reg);

		return "registration";
	}
	/**
	 * This Method takes form data and pass to service 
	 * @param reg
	 * @param model
	 * @param attributes
	 * @return String
	 * @throws IOException
	 */
	@PostMapping("/registeredBtn")
	public String handleSubmitBtn(@ModelAttribute("registationBean") StudentRegistration reg,Model model, RedirectAttributes attributes) throws IOException {
		boolean flage = registrationService.saveStudentdetail(reg);
		if(flage) {
			
			attributes.addFlashAttribute("successMsg", "Check Your Email");
		}
		else {
			attributes.addFlashAttribute("failMsg", "Recored Not Inserted ");
		}   
		return "redirect:/registered";
	}
}
