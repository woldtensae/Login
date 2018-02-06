package medical.rank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import medical.rank.domain.User;
import medical.rank.service.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping("/")
	public String getLoginPage() {
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String LoginPage(@ModelAttribute("user") User user) {
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String authenticate(@RequestParam("username") String username, @RequestParam("password")
	    String password,@ModelAttribute("user") User user, Model model) {
		if(loginService.authenticate(username, password))
			return "welcome";
		
		
		return "login";
	}
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void handle(Exception e) {
	    System.out.println("Returning HTTP 400 Bad Request"+e);
	}
	
}
