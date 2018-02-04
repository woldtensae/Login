package medical.rank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import medical.rank.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String authenticate(@RequestParam("username") String username, @RequestParam("password")
	    String password, Model model) {
		if(loginService.authenticate(username, password))
			return "Welcome";
		
		
		return "login";
	}	
}
