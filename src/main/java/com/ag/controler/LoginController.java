package com.ag.controler;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ag.mode.ForgetPwd;
import com.ag.mode.Login;
import com.ag.service.LoginService;
import com.ag.util.ForgetPwdEmail;

/**
 * This class is used to read login form data 
 * @author AVNISH SINGH
 * @version 2.2
 */
@Controller
public class LoginController {
	@Autowired
	LoginService loginService;

	
	@Autowired
	ForgetPwdEmail pwdEmail;
	/**
	 * This method is used to display login form
	 * @param model
	 * @return
	 */
	@GetMapping("/loginPage")
	public String displayRegistrationForm(Model model ) {
		Login login = new Login();
		model.addAttribute("loginBean",login);

		return "login";
	}

	/**
	 * This method is used to read form data
	 * @param login
	 * @param model
	 * @param attributes
	 * @return String
	 */
	@PostMapping("/login")
	public String loginBtn(@ModelAttribute("loginBean") Login login, Model model, RedirectAttributes attributes) {
		String emailId = login.getEmail();
		String pwd = login.getPazzword();
		Integer isLogin = loginService.loginAccount(emailId, pwd);
		if (isLogin != null) {
			model.addAttribute("loginMsg", "Login Successfully");
		}else {
		model.addAttribute("loginFailMsg", "Emial Id and Password not Matched");
		}
		return "success";
	}

	
}
