package com.asm.controller;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.asm.model.User;
import com.asm.service.UserService;

@Controller
public class AdminLoginController {
	@Autowired
	private UserService userService;

	@Autowired
	HttpSession session;

//	public String listUser(Model model) {
//		List<User> listUser = userService.findAll();
//		model.addAttribute("listUser", listUser);
//		return null;
//	}

	@GetMapping("/login")
	public ModelAndView login(ModelMap modelMap) {
		modelMap.addAttribute("user", new User());
		return new ModelAndView("login", modelMap);
	}

	@PostMapping("alogin")
	public ModelAndView alogin(ModelMap modelMap, @Valid @ModelAttribute("user") User dto) {
			User user = userService.login(dto.getUserName(), dto.getPassWord());
			if (user == null) {
				modelMap.addAttribute("error", "sai tk mk");
				return new ModelAndView("login",modelMap);
			}
			session.setAttribute("userSession", user);
			Object ruri = session.getAttribute("redirect-uri");
			if(ruri != null) {
				session.removeAttribute("redirect-uri");
				return new ModelAndView("redirect:" + ruri);
			} 
			return new ModelAndView("index",modelMap);
		}
	 @RequestMapping("/logout")
	    public ModelAndView logOut() {
	        session.removeAttribute("userSession");
	        return new ModelAndView("forward:/login");
	    }
}
