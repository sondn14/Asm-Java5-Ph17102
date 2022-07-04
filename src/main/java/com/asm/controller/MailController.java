package com.asm.controller;

import java.math.BigInteger;
import java.util.Random;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.model.MailInfo;
import com.asm.model.User;
import com.asm.service.MailService;
import com.asm.service.UserService;


@Controller
@RequestMapping("mailer")
public class MailController {
	
	@Autowired
	MailService mailer;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("forgot-password")
	public String list() {
		return"forgotPass";
	}
	
	@ResponseBody
	@PostMapping("/send")
	public String send(Model model,@Valid @ModelAttribute("user") User dto) {
		User user = userService.forgot(dto.getUserName(), dto.getEmail());
		if (user == null) {
			model.addAttribute("error", "sai tài khoản hoặc email");
			return("Sai email hoặc tài khoản");
		}
		try {
			Random ran = new Random();
			int chonSo = 90000;
			int kq = 10000+ran.nextInt(chonSo);
			System.out.println(kq);
			System.out.println(dto.getEmail());
			dto.setPassWord(String.valueOf(kq));
			userService.save(dto);
			MailInfo mail=new MailInfo();
			mail.setTo(dto.getEmail());
			mail.setSubject("Mật khẩu mới");
			mail.setBody("Mật khẩu mới của bạn là : "+ kq + "---> Vui lòng đổi mật khẩu mới để bảo vệ tài khoản của bạn!");	
			mailer.send(mail);
			return "<h1>Gửi email thành công</h1>";
		} catch (MessagingException e) {
			return "<h1>Gửi email thất bại</h1>"+e.getMessage();
		}
	}

}
