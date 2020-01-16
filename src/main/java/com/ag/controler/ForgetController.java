package com.ag.controler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ag.mode.ForgetPwd;
import com.ag.service.LoginService;

@Controller
public class ForgetController {

	@Autowired 
	private LoginService loginService;
	@GetMapping("/forgetPage")
	public String displayFrgtForm(Model model) {
		ForgetPwd forget = new ForgetPwd();
		model.addAttribute("forgetBean", forget);
		return "forgetpwd";
	}
	
	/**
	 * This method is used to read forget password form data
	 * @param fp
	 * @param model
	 * @return String
	 * @throws IOException 
	 */
	@PostMapping("/forget")
	public String forgetSubmitBtn(@ModelAttribute("forgetBean") ForgetPwd fp, Model model) throws IOException {
		String email = fp.getEmail();
		 boolean forgetPwd = loginService.forgetPwd(email);
				if (forgetPwd) {
			model.addAttribute("forgetEmailmsg", "Please Check your Email");
		}
		else {
		model.addAttribute("forgetEmailnot", "Please Enter Valied Email Id");
		}
		return "success";

	}
}
