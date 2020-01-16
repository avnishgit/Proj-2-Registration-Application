package com.ag.controler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ag.mode.UnlockAccount;
import com.ag.service.UnlockAccountService;

/**
 * This class perform unlock operations details
 * @author AVNISH SINGH
 *@version2.2
 */
@Controller

public class UnlockAccountController {
	
	@Autowired
	UnlockAccountService unlockService;
	
	/**
	 * This method is used perform display form
	 * @param model
	 * @return String
	 */
	@GetMapping("/unlockForm")
	public String displayUnlockForm(Model model,HttpServletRequest req) {
		UnlockAccount ua = new UnlockAccount();
		String email = req.getParameter("email");
		ua.setEmail(email);
		model.addAttribute("unllockAccBean", ua);
		return "unlock";
	}
	/**
	 * This method is use to unlock account
	 * @param ua
	 * @param model
	 * @param attributes
	 * @return String
	 */
	@PostMapping("/unlockSubmit")
	public String unlockSubmitBtn(@ModelAttribute("unllockAccBean") UnlockAccount ua, Model model
			) {
		
		boolean isUnlock = unlockService.unlockAccount(ua);
		if(isUnlock) {
			model.addAttribute("updateScsMsg", "Account is unlocked Please Login Once");
		}
		else {
		model.addAttribute("failMsg", "Invalid Password");
		}
		return "success";
	}
}
